package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Timer;
import java.util.function.*;
import frc.robot.subsystems.GripperSubsystem;
import frc.robot.Constants;

public class GripperPickUpCommand extends CommandBase {
    enum GripperState {
        Initial,
        Closed,
        Open,
        Extended,
        Retracted,
    };
    
    private final GripperSubsystem m_gripperSubsystem;
    private final Timer m_timer = new Timer();
    private final double m_dwellTime = 1.0;

    // Assume the gripper is closed initially
    private  GripperState m_state = GripperState.Initial;

    public GripperPickUpCommand (GripperSubsystem gripperSubsystem) {
        m_gripperSubsystem = gripperSubsystem;
        addRequirements(m_gripperSubsystem);
    }

    @Override
     public void initialize() {
        m_timer.reset();
        m_state = GripperState.Initial;
     }
 
     // Called every time the scheduler runs while the command is scheduled.
     @Override
     public void execute() {
        switch (m_state)
        {
        case Initial:
            m_gripperSubsystem.openGripper();
            m_state = GripperState.Open;
            m_timer.reset();
            m_timer.start();
            System.out.println("Gripper Open");
            break;

        case Open:
            if (m_timer.get() > m_dwellTime) {
                m_gripperSubsystem.extendArm();
                m_state = GripperState.Extended;
                m_timer.reset();
                m_timer.start();
                System.out.println("Gripper Extended");
            }
            break;  

        case Extended:
            if (m_timer.get() > m_dwellTime) {
                m_gripperSubsystem.closeGripper();
                m_state = GripperState.Closed;
                m_timer.reset();
                m_timer.start();
                System.out.println("Gripper Closed");
            }
            break;

        case Closed:
            if (m_timer.get() > m_dwellTime) {
                m_gripperSubsystem.retractArm();
                m_state = GripperState.Retracted;
                m_timer.reset();
                m_timer.start();
                System.out.println("Gripper Retracted");
            }
            break;  

        default:    // Retracted
            break;  // do nothing
        }

        System.out.println("Timer = " + m_timer.get());

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
 
