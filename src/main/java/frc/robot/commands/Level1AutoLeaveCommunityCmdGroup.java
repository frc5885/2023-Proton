package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.DrivingSubsystem;
import frc.robot.subsystems.GripperSubsystem;

public class Level1AutoLeaveCommunityCmdGroup extends SequentialCommandGroup {

    public Level1AutoLeaveCommunityCmdGroup(GripperSubsystem gripperSubsystem, ArmSubsystem armSubsystem, DrivingSubsystem drivingSubsystem){
        addCommands(new MoveArmToLevelCommand(armSubsystem, Constants.levelOneTarget),
            new DriveStraightCommand(drivingSubsystem, 0.6, 3, false),
            new GripperOpenCommand(gripperSubsystem),
            new DwellCommand(0.4),
            new DriveStraightCommand(drivingSubsystem, 0.75 , 1.25, true),
            new GripperCloseCommand(gripperSubsystem),
            new MoveArmToLevelCommand(armSubsystem, Constants.levelZeroTarget),
            new DriveStraightCommand(drivingSubsystem, 0.75 , 3, true));
    }
}
