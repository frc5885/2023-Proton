package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.GripperSubsystem;

public class ArmExtendCommand extends CommandBase {
    private final GripperSubsystem m_gripperSubsystem;

    public ArmExtendCommand(GripperSubsystem gripperSubsystem) {
        m_gripperSubsystem = gripperSubsystem;
        addRequirements(m_gripperSubsystem);
    }

    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        m_gripperSubsystem.extendArm();
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
