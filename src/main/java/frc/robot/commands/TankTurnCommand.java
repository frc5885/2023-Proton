package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import edu.wpi.first.math.controller.PIDController;
import java.util.function.DoubleSupplier;
import frc.robot.subsystems.DrivingSubsystem;

public class TankTurnCommand extends PIDCommand {
    private final DrivingSubsystem m_drivingSubsystem;

    public TankTurnCommand(DrivingSubsystem drivingSubsystem, double targetAngle) {
        super(new PIDController(0.0975, 0.003, -0.02), drivingSubsystem::getAngle,
        targetAngle, output -> drivingSubsystem.drive(output, -output, 1.0), drivingSubsystem);
        m_drivingSubsystem = drivingSubsystem;
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        m_drivingSubsystem.gyroscope.reset();
        super.initialize();
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        super.execute();
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
