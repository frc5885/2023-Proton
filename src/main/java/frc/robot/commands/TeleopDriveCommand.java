package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;

import java.util.function.*;
import frc.robot.subsystems.DrivingSubsystem;
import frc.robot.subsystems.FlapSubsystem;
import frc.robot.Constants;

public class TeleopDriveCommand extends CommandBase {

    private final DrivingSubsystem m_drivingSubsystem;
    private final XboxController m_xboxContoller; 
    private final FlapSubsystem m_flapSubsystem;

     // Called when the command is initially scheduled.
    public TeleopDriveCommand(FlapSubsystem flapSubsystem, DrivingSubsystem drivingSubsystem, 
        XboxController controller) {
        m_flapSubsystem = flapSubsystem;
        m_drivingSubsystem = drivingSubsystem;
        m_xboxContoller = controller;
        addRequirements(m_flapSubsystem);
        addRequirements(m_drivingSubsystem);
     }

     @Override
     public void initialize() {
     }
 
     // Called every time the scheduler runs while the command is scheduled.
     @Override
     public void execute() {
        boolean turboEngaged = m_xboxContoller.getRightBumper();
        double speedFactor = (turboEngaged) ? Constants.turboDriveSpeedFactor : Constants.slowDriveSpeedFactor;
        double leftJoystickPos = m_xboxContoller.getRawAxis(Constants.LeftYAxis);
        double rightJoystickPos = m_xboxContoller.getRawAxis(Constants.RightYAxis);
        double rightTriggerPos = m_xboxContoller.getRightTriggerAxis();
        double leftTriggerPos = m_xboxContoller.getLeftTriggerAxis();

        // Initialize speeds to joystick positions
        double leftSpeed = leftJoystickPos;
        double rightSpeed = rightJoystickPos;
        
        // if the right trigger is pressed, drive the robot straight
        if (rightTriggerPos > 0.05) 
        {
            leftSpeed = -rightTriggerPos;
            rightSpeed = -rightTriggerPos;
        }
        else if (leftTriggerPos > 0.05)
        {
            leftSpeed = leftTriggerPos;
            rightSpeed = leftTriggerPos;
        }

        m_drivingSubsystem.drive(leftSpeed, rightSpeed, speedFactor);
        if (m_flapSubsystem.isLowered()){
            m_xboxContoller.setRumble(RumbleType.kBothRumble, 1);
        }
        else{
            m_xboxContoller.setRumble(RumbleType.kBothRumble, 0);
        }

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
 

