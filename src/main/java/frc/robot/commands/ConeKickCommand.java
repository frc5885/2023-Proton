package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.subsystems.DrivingSubsystem;
import frc.robot.subsystems.GripperSubsystem;

public class ConeKickCommand extends CommandBase {
    private final GripperSubsystem m_gripperSubsystem;

    // Does the power calculation for a given ramp angle
    private final Timer m_timer = new Timer();    
    public ConeKickCommand(GripperSubsystem kickSubsystem) {
        m_gripperSubsystem = kickSubsystem;

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
        // kick the cone at the start of autonomous
        m_gripperSubsystem.extendKicker();
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        boolean isFinished = (m_timer.get() > 1);
        return isFinished;
    }


    @Override
    public boolean runsWhenDisabled() {
        return false;
    }
}