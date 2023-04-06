package frc.robot.commands;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.DrivingSubsystem;
import frc.robot.subsystems.FlapSubsystem;
import frc.robot.subsystems.FootSubsystem;
import frc.robot.subsystems.GripperSubsystem;
import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class LeaveCommunityBalanceAutoCmdGroup extends SequentialCommandGroup{
    public LeaveCommunityBalanceAutoCmdGroup(GripperSubsystem gripperSubsystem, DrivingSubsystem drivingSubsystem,
        ArmSubsystem armSubsystem, FlapSubsystem flapSubsystem, FootSubsystem footSubsystem){
            addCommands(new MoveArmToLevelCommand(armSubsystem, Constants.levelThreeTarget),
            new DriveStraightCommand(drivingSubsystem, 0.0, 0.0, false),
            new GripperDropCommand(gripperSubsystem),
            new DwellCommand(0.25),
            new DriveStraightCommand(drivingSubsystem, 0.75, 0.6, true),
            new ArmExtendCommand(gripperSubsystem),
            new DwellCommand(0.25),
            new GripperCloseCommand(gripperSubsystem),
            new DwellCommand(.25),
            new ArmRetractCommand(gripperSubsystem),
            new MoveArmToLevelCommand(armSubsystem, Constants.levelZeroTarget),
            new DriveStraightCommand(drivingSubsystem, 0.75, 2, true),
            new DriveStraightCommand(drivingSubsystem, 1.0, 3, true),
            new BalanceCommand(drivingSubsystem, footSubsystem, null, false)
            );
    }
}
