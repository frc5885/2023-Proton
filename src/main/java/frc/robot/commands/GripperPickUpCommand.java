package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Timer;
import java.util.function.*;
import frc.robot.subsystems.GripperSubsystem;
import frc.robot.Constants;

public class GripperPickUpCommand extends CommandBase {
    enum GripperState {
        EXTEND,
        CLOSE,
        RETRACT,
        FINISH,
    };
    
    private final GripperSubsystem m_gripperSubsystem;
    private final Timer m_timer = new Timer();
    private final double m_dwellTime = .25;

    // Assume the gripper is closed initially
    private  GripperState m_nextState = GripperState.CLOSE;

    public GripperPickUpCommand (GripperSubsystem gripperSubsystem) {
        m_gripperSubsystem = gripperSubsystem;
        addRequirements(m_gripperSubsystem);
    }

    @Override
     public void initialize() {
        m_nextState = GripperState.EXTEND;
     }
 
     @Override
     public void execute() {
        if ( m_nextState == GripperState.EXTEND) {
            m_gripperSubsystem.extendArm();
            m_nextState = GripperState.CLOSE;
            m_timer.reset();
            m_timer.start();
        }
        else if (m_nextState == GripperState.CLOSE && m_timer.get() >= m_dwellTime) {
            m_gripperSubsystem.closeGripper();
            m_nextState = GripperState.RETRACT;
        } else if (m_nextState == GripperState.RETRACT && m_timer.get() >= (m_dwellTime * 2)) {
            m_gripperSubsystem.retractArm();
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
 
