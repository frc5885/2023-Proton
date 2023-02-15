package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.ADIS16448_IMU.IMUAxis;

import java.util.function.DoubleSupplier;
import frc.robot.subsystems.DrivingSubsystem;
import frc.robot.SwitchController;

public class BalanceCommand extends CommandBase {
    private final DrivingSubsystem m_drivingSubsystem;

    // Does the power calculation for a given ramp angle
    private final SwitchController m_switchController = new SwitchController();
    private final double m_rampAngle = 3.0;

    private  boolean m_onRamp = false;  // are we on the ramp yet?
    
    public BalanceCommand(DrivingSubsystem drivingSubsystem) {
        m_drivingSubsystem = drivingSubsystem;
        addRequirements(m_drivingSubsystem);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        m_drivingSubsystem.gyroscope.reset();
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        super.end(interrupted);
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return super.isFinished();
    }

    @Override
    public boolean runsWhenDisabled() {
        return false;
    }
}