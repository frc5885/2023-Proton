package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.GripperSubsystem;

public class GripperPickUpCmdGroup extends SequentialCommandGroup {
    public GripperPickUpCmdGroup(GripperSubsystem gripperSubsystem){
        addCommands(new ArmExtendCommand(gripperSubsystem),
            new DwellCommand(.25),
            new GripperCloseCommand(gripperSubsystem),
            new DwellCommand(.25),
            new ArmRetractCommand(gripperSubsystem));
    }
}
