package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.DrivingSubsystem;
import frc.robot.subsystems.GripperSubsystem;
import frc.robot.subsystems.FlapSubsystem;
import frc.robot.Constants;
import frc.robot.ArmAutoLevelConstants;

public class CubeAutoCmdGroup extends SequentialCommandGroup {
    
    public CubeAutoCmdGroup(ArmSubsystem armSubsystem, GripperSubsystem gripperSubsystem, DrivingSubsystem drivingSubsystem, ArmAutoLevelConstants armLevel) {
        addCommands(new MoveArmToLevelCommand(armSubsystem, armLevel.target),
            new DriveStraightCommand(drivingSubsystem, 0.5, armLevel.approachTime, false),
            new GripperDropCommand(gripperSubsystem));
    }
}