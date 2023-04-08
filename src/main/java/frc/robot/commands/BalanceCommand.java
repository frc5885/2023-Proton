package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.ADIS16470_IMU.IMUAxis;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.DrivingSubsystem;
import frc.robot.subsystems.FootSubsystem;
import frc.robot.subsystems.GripperSubsystem;
import frc.robot.SwitchController;
import frc.robot.Constants;

public class BalanceCommand extends CommandBase {
    private final DrivingSubsystem m_drivingSubsystem;
    private final FootSubsystem m_FootSubsystem;
    private final XboxController m_controller;

    // Does the power calculation for a given ramp angle
    private final SwitchController m_switchController = new SwitchController();
    private final double m_rampAngle = 15.0;
    private final double m_flatSpeed = 0.85; //was .85
    private final double m_powerScale = 1.05;  // scale output up/down quickly //was 1.02   
    private boolean m_isCancelled = false;
    private double m_angle = 0.0;
    private boolean m_onRamp = false;  // are we on the ramp yet?
    private final Timer m_timer = new Timer();
    private final Timer m_delay = new Timer();
    boolean m_timerStarted = false;
    private final double m_stopTime = 2;  
    double m_direction = 1.0; //1 = forward and -1 = reverse
    
    public BalanceCommand(DrivingSubsystem drivingSubsystem, FootSubsystem footSubsystem,
        XboxController controller, boolean isReversed) {
        m_drivingSubsystem = drivingSubsystem;
        m_FootSubsystem = footSubsystem;
        m_controller = controller;
        m_direction = isReversed ? -1.0 : 1.0;
        addRequirements(m_drivingSubsystem);
        addRequirements(m_FootSubsystem);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        m_timer.reset();
        m_drivingSubsystem.gyroscope.setYawAxis(IMUAxis.kX);
        m_drivingSubsystem.gyroscope.reset();
        m_delay.reset();
        m_delay.start();
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        if (m_controller != null) {
            // manually kill this command if something goes south
            m_isCancelled = m_controller.getRawAxis(Constants.LeftYAxis) >= 0.2 || m_controller.getRawAxis(Constants.LeftYAxis) <= -0.2 ||
                            m_controller.getRawAxis(Constants.RightYAxis) >= 0.2 || m_controller.getRawAxis(Constants.RightYAxis) <= -0.2;
        }

        m_angle = m_drivingSubsystem.getAngle();

        if (m_delay.get() > .1){
            if (m_onRamp)
            {
                // Controller for balancing on the charger
                ExecuteRampControl();
            }
            else
            {
                // Approach the ramp
                ExecuteFlatControl();
            }
        }
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        if (!interrupted) {
            m_drivingSubsystem.SetBrakeMode(true);
            m_drivingSubsystem.drive(0.0, 0.0, 1.0);
            m_FootSubsystem.extendFoot();
            System.out.println("End!!!");
        }
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        if (m_isCancelled) {
            return true;
        }

        if (!m_onRamp){
            return false;
        }

        boolean motorsOff = m_drivingSubsystem.IsStopped();
        boolean finished = false;

        if (motorsOff){
            if (m_timerStarted){
                finished = (m_timer.get() > m_stopTime);
            }   
            else{
                m_timer.start();
                m_timerStarted = true;
            } 
        }
        else{
            m_timer.reset();
        }
        return finished;
    }

    @Override
    public boolean runsWhenDisabled() {
        return false;
    }

    // Start of 5885 private methods
    private void ExecuteRampControl() {
        // Sanity checks
        if (!m_onRamp)
        {
            return;
        }

        // Get motor power from |ramp angle|
        double power = m_switchController.GetPower(Math.abs(m_angle));

        // Compensate for if we are going up or down the ramp
        // If we are approaching the ramp forward, and going down the ramp
        // m_angle < 0
        // If we are approaching the ramp backward, and going down the ramp
        // m_angle > 0
        if ((m_direction == 1.0 && m_angle < 0.0) || 
            (m_direction == -1.0 && m_angle > 0.0)) {
            power *= -1;    // reverse the direction
        }        

        // Compensate for if we are approaching forward (m_direction = 1) or
        // backward (m_direction = -1)
        power *= m_direction;

        // Scale the result as determined by testing
        power *= m_powerScale;
        System.out.println("On the ramp: Angle = " + m_angle + "Power = " + power);

        // power < 0 drives forward, power > 0 drives backward
        m_drivingSubsystem.drive(-power, -power, 1.0);
    }

    private void ExecuteFlatControl() {
        // see if we are on the ramp, at which point we stop running this controller
        if (Math.abs(m_angle) > m_rampAngle)
        {
            m_onRamp = true;
            return;
        }
        double power = -m_flatSpeed * m_direction;
        System.out.println("On the flat" + power);
        m_drivingSubsystem.drive(power, power, 1.0);
    }
}