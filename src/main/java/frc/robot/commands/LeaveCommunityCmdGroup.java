package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.DrivingSubsystem;
import frc.robot.subsystems.GripperSubsystem;

public class LeaveCommunityCmdGroup extends SequentialCommandGroup {

    public LeaveCommunityCmdGroup(GripperSubsystem gripperSubsystem, ArmSubsystem armSubsystem, DrivingSubsystem drivingSubsystem){
        addCommands(new DriveStraightCommand(drivingSubsystem, 0.75, 6, false));
    }
}
