package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.*;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.ADIS16470_IMU.IMUAxis;
import edu.wpi.first.wpilibj.Timer;

import java.util.function.DoubleSupplier;
import frc.robot.subsystems.DrivingSubsystem;

public class TimedGoStraightCommand extends CommandBase {
    private final DrivingSubsystem m_drivingSubsystem;
    private final double m_targetTime; // In seconds
    private final Timer m_timer = new Timer();


    public TimedGoStraightCommand(DrivingSubsystem drivingSubsystem, double targetTime) {
        m_targetTime = targetTime;
        m_drivingSubsystem = drivingSubsystem;
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        System.out.println("Init timer");
        m_timer.reset();
        m_timer.start();
        m_drivingSubsystem.SetBrakeMode(true);
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        //TODO This should be set in constants
        m_drivingSubsystem.drive(.5, .5, 1.0);
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        m_drivingSubsystem.drive(0, 0, 1);
        super.end(interrupted);
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        boolean finished = (m_timer.get() > m_targetTime);
        return finished;
    }

    @Override
    public boolean runsWhenDisabled() {
        return false;
    }
}
