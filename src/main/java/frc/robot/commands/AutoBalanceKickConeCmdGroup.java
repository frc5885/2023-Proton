package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj.Timer;
import java.util.function.*;

import frc.robot.subsystems.DrivingSubsystem;
import frc.robot.subsystems.GripperSubsystem;
import frc.robot.subsystems.FootSubsystem;

import frc.robot.Constants;

public class AutoBalanceKickConeCmdGroup extends SequentialCommandGroup {

    public AutoBalanceKickConeCmdGroup(GripperSubsystem gripperSubsystem, 
        DrivingSubsystem drivingSubsystem, FootSubsystem footSubsystem) {
        addCommands(new KickConeCommand(gripperSubsystem), 
            new BalanceCommand(drivingSubsystem, footSubsystem, null, false));
    }
}
