package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.subsystems.GripperSubsystem;

public class GripperDropCommand extends CommandBase {
    enum GripperState {
        OPEN,
        EXTEND,
        FINISH
    };
    
    private final GripperSubsystem m_gripperSubsystem;
    private Timer m_timer = new Timer();
    private final double m_dwellTime = .25;

    public GripperDropCommand (GripperSubsystem gripperSubsystem) {
        m_gripperSubsystem = gripperSubsystem;
        addRequirements(m_gripperSubsystem);
    }

    @Override
     public void initialize() {
     }
 
     // Called every time the scheduler runs while the command is scheduled.
     @Override
     public void execute() {
            m_gripperSubsystem.openGripper();
            m_timer.start();
    }
 
     // Called once the command ends or is interrupted.
     @Override
     public void end(boolean interrupted) {
     }
 
     // Returns true when the command should end.
     @Override
     public boolean isFinished() {
        return m_timer.get() > m_dwellTime;
     }
 
     @Override
     public boolean runsWhenDisabled() {
         return false;
     }
 }
 
