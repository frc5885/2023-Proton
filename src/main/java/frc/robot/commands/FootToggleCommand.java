package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import java.util.function.*;

import frc.robot.subsystems.FootSubsystem;
import frc.robot.subsystems.GripperSubsystem;
import frc.robot.Constants;

public class FootToggleCommand extends CommandBase {
    private final FootSubsystem m_footSubsystem;
    public FootToggleCommand (FootSubsystem footSubsystem) {
        m_footSubsystem = footSubsystem;
        addRequirements(m_footSubsystem);
    }

    @Override
     public void initialize() {
     }
 
     // Called every time the scheduler runs while the command is scheduled.
     @Override
     public void execute() {
        if (m_footSubsystem.isExtended()){
            m_footSubsystem.retractFoot();
            return;
        }
        
        m_footSubsystem.extendFoot();    
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
 
