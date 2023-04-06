package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.GripperSubsystem;

public class ArmRetractCommand extends CommandBase {
    private final GripperSubsystem m_gripperSubsystem;
    
    public ArmRetractCommand(GripperSubsystem gripperSubsystem) {
        m_gripperSubsystem = gripperSubsystem;
        addRequirements(m_gripperSubsystem);
    }

    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        m_gripperSubsystem.retractArm();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return true;
    }

    @Override
    public boolean runsWhenDisabled() {
        return false;
    }
}
