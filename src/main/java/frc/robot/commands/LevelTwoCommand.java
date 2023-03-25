package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmSubsystem;

public class LevelTwoCommand extends CommandBase {
    private final ArmSubsystem m_armSubsystem;
    private final double kPosition = -98000.0;

    public LevelTwoCommand(ArmSubsystem armSubsystem) {
        m_armSubsystem = armSubsystem;
        addRequirements(m_armSubsystem);
    }

    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        m_armSubsystem.goToClosedLoopPosition(kPosition);
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public boolean runsWhenDisabled() {
        return false;
    }
}
