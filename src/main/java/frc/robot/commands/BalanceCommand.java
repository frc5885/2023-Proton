package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.ADIS16470_IMU.IMUAxis;

import frc.robot.subsystems.DrivingSubsystem;
import frc.robot.SwitchController;

public class BalanceCommand extends CommandBase {
    private final DrivingSubsystem m_drivingSubsystem;

    // Does the power calculation for a given ramp angle
    private final SwitchController m_switchController = new SwitchController();
    private final double m_rampAngle = 10.0;
    private final double m_flatSpeed = .6;
    private final double m_powerScale = 1.05;  // scale output up/down quickly
    private double m_angle = 0.0;
    private  boolean m_onRamp = false;  // are we on the ramp yet?
    
    
    public BalanceCommand(DrivingSubsystem drivingSubsystem) {
        m_drivingSubsystem = drivingSubsystem;
        addRequirements(m_drivingSubsystem);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        m_drivingSubsystem.gyroscope.setYawAxis(IMUAxis.kZ);
        m_drivingSubsystem.gyroscope.reset();
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        m_angle = m_drivingSubsystem.getAngle();

        if (m_onRamp)
        {
            ExecuteRampControl();
        }
        else
        {
            ExecuteFlatControl();
        }
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        if (!interrupted) {
            m_drivingSubsystem.SetBrakeMode(true);
            m_drivingSubsystem.drive(0.0, 0.0, 1.0);
            System.out.println("End!!!");
        }
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        boolean stopped = m_drivingSubsystem.IsStopped();
        boolean finished = (m_onRamp && stopped); 
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

        double power = m_switchController.GetPower(Math.abs(m_angle));

        if (m_angle < 0) {
            power *= -1;
        }

        power *= m_powerScale;
        System.out.println("On the ramp: Angle = " + m_angle + "Power = " + power);
        m_drivingSubsystem.drive(power, power, 1.0);
    }

    private void ExecuteFlatControl() {
        // see if we are on the ramp, at which point we stop running this controller
        if (Math.abs(m_angle) > m_rampAngle)
        {
            m_onRamp = true;
            return;
        }

        System.out.println("On the flat" + m_flatSpeed);
        m_drivingSubsystem.drive(-m_flatSpeed, -m_flatSpeed, 1.0);
    }
}