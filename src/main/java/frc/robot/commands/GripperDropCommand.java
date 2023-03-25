package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Timer;
import java.util.function.*;
import frc.robot.subsystems.GripperSubsystem;
import frc.robot.Constants;

public class GripperDropCommand extends CommandBase {
    private final GripperSubsystem m_gripperSubsystem;
    private final Timer m_timer = new Timer();
    public GripperDropCommand (GripperSubsystem gripperSubsystem) {
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
        if (m_timer.get() == 0){
            m_timer.start();
        }
        else{
            m_gripperSubsystem.retractArm();
            if (m_timer.get() > 0.5){
                m_gripperSubsystem.openGripper();
        }
        }
        
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
 
