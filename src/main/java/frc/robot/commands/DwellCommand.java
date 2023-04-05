package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Timer;

public class DwellCommand extends CommandBase {
    private double m_dwell;
    private final Timer m_timer = new Timer(); 
       
    public DwellCommand(double dwell) {
        m_dwell = dwell;
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        m_timer.reset();
        m_timer.start();
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        boolean isFinished = (m_timer.get() > m_dwell);
        return isFinished;
    }


    @Override
    public boolean runsWhenDisabled() {
        return false;
    }
}
