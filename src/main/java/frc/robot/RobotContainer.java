// RobotBuilder Version: 5.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: RobotContainer.

package frc.robot;

import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command.InterruptionBehavior;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.*;
import frc.robot.commands.*;
import frc.robot.subsystems.GripperSubsystem;
import frc.robot.subsystems.ArmSubsystem;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  private static RobotContainer m_robotContainer = new RobotContainer();

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
// The robot's subsystems
public final CameraSubsystem m_cameraSubsystem = new CameraSubsystem();
public final GripperSubsystem m_gripperSubsystem = new GripperSubsystem();
public final ArmSubsystem m_armSubsystem = new ArmSubsystem();
public final DrivingSubsystem m_drivingSubsystem = new DrivingSubsystem();

// Joysticks
private final XboxController m_xboxController1 = new XboxController(0);
private final CommandXboxController m_xboxController2 = new CommandXboxController(1);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

  
  // A chooser for autonomous commands
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  /**
  * The container for the robot.  Contains subsystems, OI devices, and commands.
  */
  private RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    m_drivingSubsystem.setDefaultCommand(new TeleopDriveCommand (m_drivingSubsystem, m_xboxController1));
    m_gripperSubsystem.setDefaultCommand(new GripperOpenCommand(m_gripperSubsystem));
    m_armSubsystem.setDefaultCommand(new ArmExtendCommand(m_gripperSubsystem));

    // SmartDashboard Buttons
   // SmartDashboard.putData("Autonomous Command", new TankTurnCommand(m_drivingSubsystem));

   // m_chooser.setDefaultOption("Autonomous Command", new TankTurnCommand(m_drivingSubsystem));

    SmartDashboard.putData("Auto Mode", m_chooser);
  }

  public static RobotContainer getInstance() {
    return m_robotContainer;
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    Trigger armRetractTrigger = m_xboxController2.a();
    Trigger armExtendTrigger = m_xboxController2.b();
    Trigger gripperCloseTrigger = m_xboxController2.x();
    Trigger gripperOpenButton = m_xboxController2.y();
    armRetractTrigger.onTrue(new ArmRetractCommand(m_gripperSubsystem));
    armExtendTrigger.onTrue(new ArmExtendCommand(m_gripperSubsystem));
    gripperCloseTrigger.onTrue(new GripperCloseCommand(m_gripperSubsystem));
    gripperOpenButton.onTrue(new GripperOpenCommand(m_gripperSubsystem));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
  */
  public Command getAutonomousCommand() {
    // The selected command will be run in autonomous
    //return m_chooser.getSelected();
    TankTurnCommand cmd = new TankTurnCommand(m_drivingSubsystem, -45.0);
    //BalanceCommand cmd =  new BalanceCommand(m_drivingSubsystem);
    return cmd;
  }
}

