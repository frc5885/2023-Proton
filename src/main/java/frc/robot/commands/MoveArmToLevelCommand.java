package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmSubsystem;

public class MoveArmToLevelCommand extends CommandBase {
    private final ArmSubsystem m_armSubsystem;
    private final double m_targetPos;

    public MoveArmToLevelCommand(ArmSubsystem armSubsystem, double targetPos) {
        m_armSubsystem = armSubsystem;
        m_targetPos = targetPos;
        addRequirements(m_armSubsystem);
    }

    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        m_armSubsystem.goToClosedLoopPosition(m_targetPos);
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {   
        System.out.println("Move arm to level command has been interupted *****");
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
