package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.XboxController;
import java.util.function.*;
import frc.robot.subsystems.FlapSubsystem;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.Constants;

public class MoveArmCommand extends CommandBase {
    
    private final ArmSubsystem m_armSubsystem;
    private final FlapSubsystem m_flapSubsystem;
    private final XboxController m_xboxContoller; 

    public MoveArmCommand(FlapSubsystem flapSubsystem, ArmSubsystem armSubsystem, XboxController xboxController){
        m_flapSubsystem = flapSubsystem;
        m_armSubsystem = armSubsystem;
        m_xboxContoller = xboxController;
        addRequirements(m_armSubsystem);
    }

    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
       double speedFactor = Constants.armSpeedFactor;
       double leftJoystickPos = m_xboxContoller.getRawAxis(Constants.LeftYAxis);

       //before the arm moves, flaps have to be lowered or they will interfere with arm
       if (!m_flapSubsystem.isLowered() && Math.abs(leftJoystickPos) >= 0.05){
        m_flapSubsystem.lowerFlaps();
       }
       m_armSubsystem.drive(leftJoystickPos, speedFactor);
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
