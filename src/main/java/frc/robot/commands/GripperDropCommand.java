package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Timer;
import java.util.function.*;
import frc.robot.subsystems.GripperSubsystem;
import frc.robot.Constants;

public class GripperDropCommand extends CommandBase {
    enum GripperState {
        OPEN,
        EXTEND,
        FINISH
    };
    
    private final GripperSubsystem m_gripperSubsystem;
    private final Timer m_timer = new Timer();
    private final double m_dwellTime = .25;

    // Assume the gripper is closed initially
    private  GripperState m_nextState = GripperState.OPEN;

    public GripperDropCommand (GripperSubsystem gripperSubsystem) {
        m_gripperSubsystem = gripperSubsystem;
        addRequirements(m_gripperSubsystem);
    }

    @Override
     public void initialize() {
        m_nextState = GripperState.OPEN;
     }
 
     // Called every time the scheduler runs while the command is scheduled.
     @Override
     public void execute() {
        if (m_nextState == GripperState.OPEN) {
            m_gripperSubsystem.openGripper();
            m_nextState = GripperState.EXTEND;
            m_timer.reset();
            m_timer.start();
        } else if (m_nextState == GripperState.EXTEND && m_timer.get() >= m_dwellTime) {
            m_gripperSubsystem.extendArm();
            m_nextState = GripperState.FINISH;
        }
    }
 
     // Called once the command ends or is interrupted.
     @Override
     public void end(boolean interrupted) {
     }
 
     // Returns true when the command should end.
     @Override
     public boolean isFinished() {
        return m_nextState == GripperState.FINISH;
     }
 
     @Override
     public boolean runsWhenDisabled() {
         return false;
     }
 }
 
