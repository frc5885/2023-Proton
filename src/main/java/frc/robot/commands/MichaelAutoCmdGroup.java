package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.ADIS16470_IMU.IMUAxis;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.DrivingSubsystem;
import frc.robot.subsystems.FlapSubsystem;
import frc.robot.subsystems.FootSubsystem;
import frc.robot.subsystems.GripperSubsystem;
import frc.robot.SwitchController;
import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class MichaelAutoCmdGroup extends SequentialCommandGroup{
    public MichaelAutoCmdGroup(GripperSubsystem gripperSubsystem, DrivingSubsystem drivingSubsystem,
        ArmSubsystem armSubsystem, FlapSubsystem flapSubsystem){
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
            new DriveStraightCommand(drivingSubsystem, 1.0, 4, true),
            new TankTurnCommand(drivingSubsystem, 180),
            new FlapCommand(flapSubsystem),
            new GripperOpenCommand(gripperSubsystem),
            new DriveStraightCommand(drivingSubsystem, 0.75, 1, false),
            new ArmExtendCommand(gripperSubsystem),
            new DwellCommand(0.25),
            new GripperCloseCommand(gripperSubsystem),
            new DwellCommand(.25),
            new ArmRetractCommand(gripperSubsystem),
            new FlapCommand(flapSubsystem),
            new TankTurnCommand(drivingSubsystem, 180),
            new DriveStraightCommand(drivingSubsystem, 1, 4, false),
            new MoveArmToLevelCommand(armSubsystem, 0),
            new DriveStraightCommand(drivingSubsystem, 0.75, 1, false),
            new GripperOpenCommand(gripperSubsystem)
            );
    }
}
