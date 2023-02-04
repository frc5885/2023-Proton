package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.XboxController;
import java.util.function.*;
import frc.robot.subsystems.DrivingSubsystem;
import frc.robot.Constants;

public class TeleopDriveCommand extends CommandBase {

    private final DrivingSubsystem m_drivingSubsystem;
    private final Supplier<Double> m_leftSpeedFunction, m_rightSpeedFunction;
    
     // Called when the command is initially scheduled.
     public TeleopDriveCommand(DrivingSubsystem drivingSubsystem, Supplier<Double> leftSpeedFunction,
        Supplier<Double> rightSpeedFunction) {
        m_drivingSubsystem = drivingSubsystem;
        m_leftSpeedFunction = leftSpeedFunction;
        m_rightSpeedFunction = rightSpeedFunction;
        addRequirements(m_drivingSubsystem);
     }

     @Override
     public void initialize() {
     }
 
     // Called every time the scheduler runs while the command is scheduled.
     @Override
     public void execute() {
        XboxController controller = m_xboxController;

        boolean turboEngaged = controller.getLeftStickButton();
        double speedFactor = (turboEngaged) ? Constants.turboDriveSpeedFactor : Constants.slowDriveSpeedFactor;
        double leftJoystickPos = controller.getRawAxis(Constants.LeftYAxis);
        double rightJoystickPos = controller.getRawAxis(Constants.RightYAxis);
        m_drivingSubsystem.drive(leftJoystickPos, rightJoystickPos, speedFactor);
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
 

