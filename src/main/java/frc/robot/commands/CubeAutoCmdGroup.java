package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.DrivingSubsystem;
import frc.robot.subsystems.FootSubsystem;
import frc.robot.subsystems.GripperSubsystem;
import frc.robot.ArmAutoLevelConstants;
import frc.robot.Constants;

public class CubeAutoCmdGroup extends SequentialCommandGroup {
    
    public CubeAutoCmdGroup(ArmSubsystem armSubsystem, GripperSubsystem gripperSubsystem, 
        DrivingSubsystem drivingSubsystem, FootSubsystem footSubsystem,
        ArmAutoLevelConstants armLevel,
        Constants.AutoMoveType moveType) {
        if (moveType == Constants.AutoMoveType.None) 
        {
            addCommands(new MoveArmToLevelCommand(armSubsystem, armLevel.m_target),
                new DriveStraightCommand(drivingSubsystem, armLevel.m_approachSpeed, 
                armLevel.m_approachTime, false),
                new GripperDropCommand(gripperSubsystem));
        }
        else if (moveType == Constants.AutoMoveType.LeaveCommunity)
        {
            addCommands(new MoveArmToLevelCommand(armSubsystem, armLevel.m_target),
                new DriveStraightCommand(drivingSubsystem, armLevel.m_approachSpeed, 
                armLevel.m_approachTime, false),
                new GripperDropCommand(gripperSubsystem),
                new DwellCommand(0.5),
                new DriveStraightCommand(drivingSubsystem, Constants.leaveCommunitySpeed, 1, true),
                new GripperCloseCommand(gripperSubsystem),
                new MoveArmToLevelCommand(armSubsystem, Constants.levelZeroTarget),
                new DwellCommand(1),
                new DriveStraightCommand(drivingSubsystem, Constants.leaveCommunitySpeed, Constants.leaveCommunityTime, 
                true));
        }
        else if (moveType == Constants.AutoMoveType.Balance)
        {
            addCommands(new MoveArmToLevelCommand(armSubsystem, armLevel.m_target),
                new DriveStraightCommand(drivingSubsystem, armLevel.m_approachSpeed, 
                armLevel.m_approachTime, false),
                new GripperDropCommand(gripperSubsystem),
                new DwellCommand(0.5),
                new DriveStraightCommand(drivingSubsystem, Constants.leaveCommunitySpeed, 1, true),
                new GripperCloseCommand(gripperSubsystem),
                new MoveArmToLevelCommand(armSubsystem, Constants.levelZeroTarget),
                new DwellCommand(1),
                new BalanceCommand(drivingSubsystem, footSubsystem, null, true));
        }
    


        
    }

}