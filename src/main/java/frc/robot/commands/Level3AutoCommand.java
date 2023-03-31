package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.DrivingSubsystem;
import frc.robot.subsystems.GripperSubsystem;
import frc.robot.subsystems.FlapSubsystem;
import frc.robot.Constants;

public class Level3AutoCommand extends CommandBase {
    private final FlapSubsystem  m_flapSubsystem;
    private final DrivingSubsystem m_drivingSubsystem;
    private final ArmSubsystem m_armSubsystem;
    private final GripperSubsystem m_gripperSubsystem;

    // Does the power calculation for a given ramp angle
    private final Timer m_timer = new Timer();  
    
    public Level3AutoCommand(FlapSubsystem flapSubsystem, ArmSubsystem armSubsystem, GripperSubsystem gripperSubsystem, DrivingSubsystem drivingSubsystem) {
        m_flapSubsystem = flapSubsystem;
        m_armSubsystem = armSubsystem;
        m_gripperSubsystem = gripperSubsystem;
        m_drivingSubsystem = drivingSubsystem;
        addRequirements(m_drivingSubsystem);
        addRequirements(m_armSubsystem);
        addRequirements(m_gripperSubsystem);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        m_timer.reset();
        m_timer.start();
        return;
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        // //Drive backwards
        // if (m_timer.get() < 1.5 ){
        //     m_drivingSubsystem.drive(.75, .75, 1.0);
        // }

        // //Lift arm
        // m_armSubsystem.goToClosedLoopPosition(Constants.levelThreeTarget);
        
        // //Drive forwards
        // if (m_timer.get() < 5.0 ){
        //     m_drivingSubsystem.drive(-.25, -.25, 1.0);
        // }

        // //Release gripper
        // m_gripperSubsystem.closeGripper();

        if (m_timer.get() < 0.9){
            m_drivingSubsystem.drive(.75, .75, 1.0);
        }
        else if (m_timer.get() > 0.95){
            m_flapSubsystem.lowerFlaps();
        // else{
            m_armSubsystem.goToClosedLoopPosition(Constants.levelThreeTarget);
            if (m_timer.get() < 6 ){
                    m_drivingSubsystem.drive(-.5, -.5, 1.0);
                }
            else{
                m_drivingSubsystem.drive(0, 0, 1);
                m_gripperSubsystem.openGripper();
            }
        }

    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        if (!interrupted) {
            System.out.println("End!!!");
        }
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        boolean finished = (m_timer.get() > 10);
        return finished;
    }


    @Override
    public boolean runsWhenDisabled() {
        return false;
    }
}