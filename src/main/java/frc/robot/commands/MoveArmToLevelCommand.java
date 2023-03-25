package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmSubsystem;

public class MoveArmToLevelCommand extends CommandBase {
    private final ArmSubsystem m_armSubsystem;
    private final double m_targetPos;
    private final Timer m_timer = new Timer();

    public MoveArmToLevelCommand(ArmSubsystem armSubsystem, double targetPos) {
        m_armSubsystem = armSubsystem;
        m_targetPos = targetPos;
        addRequirements(m_armSubsystem);
    }

    @Override
    public void initialize() {
        m_timer.reset();
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        m_timer.start();
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
        if (m_armSubsystem.motorOutput() == 0 && m_timer.get() > 0.5)
            return true;
        return false;
    }

    @Override
    public boolean runsWhenDisabled() {
        return false;
    }
}
