package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.GripperSubsystem;

public class ArmRetractCommand extends CommandBase {
    private final GripperSubsystem m_gripperSubsystem;
    private Timer m_timer = new Timer();
    private boolean m_timerStarted = false;
    
    public ArmRetractCommand(GripperSubsystem gripperSubsystem) {
        m_gripperSubsystem = gripperSubsystem;
        addRequirements(m_gripperSubsystem);
    }

    @Override
    public void initialize() {
        m_timer.reset();
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        m_gripperSubsystem.retractArm();

        if (!m_timerStarted) {
            m_timer.start();
            m_timerStarted = true;
        }
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        boolean finished = m_timer.get() > Constants.gripperDwellTime;

        if (finished) {
            System.out.println("\n\n\n$$$$$ Arm Retract finished $$$$$\n\n\n");
        }

        return finished;
    }

    @Override
    public boolean runsWhenDisabled() {
        return false;
    }
}
