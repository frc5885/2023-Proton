// RobotBuilder Version: 5.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: Subsystem.

package frc.robot.subsystems;


import frc.robot.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class GripperSubsystem extends SubsystemBase {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
private DoubleSolenoid gripSolenoid;    //open and closing gripper solenoid which controls valve
private DoubleSolenoid armSolenoid;     //extend and retract arm solenoid which controls valve
private Compressor compressor;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    /**
    *
    */
    public GripperSubsystem() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
armSolenoid = new DoubleSolenoid(0, PneumaticsModuleType.CTREPCM, 0, 0);
 addChild("ArmSolenoid", armSolenoid);

gripSolenoid = new DoubleSolenoid(0, PneumaticsModuleType.CTREPCM, 0, 0);
 addChild("ArmSolenoid", gripSolenoid);
 
//TODO figure out what to do with compressor
compressor = new Compressor(0, PneumaticsModuleType.CTREPCM);
 addChild("Compressor",compressor);
 


        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run

    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run when in simulation

    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.


    //TODO Make close, open, extend, retratc functions and then make them interact
    public void closeGripper(){
        //If gripper is already closed, it does nothing
        if (gripSolenoid.isFwdSolenoidDisabled() == false && gripSolenoid.isRevSolenoidDisabled() == true){
            return;
        }
        //Gripper isn't closed
        gripSolenoid.toggle();
        return;
    }

    public void OpenGripper(){
        //If gripper is already open, it does nothing
        if (gripSolenoid.isRevSolenoidDisabled() == false && gripSolenoid.isFwdSolenoidDisabled() == true){
            return;
        }
        //Gripper isn't open
        gripSolenoid.toggle();
        return; 
    }

    public void retractArm(){
        //If arm is already closed, it does nothing
        if (armSolenoid.isFwdSolenoidDisabled() == false && armSolenoid.isRevSolenoidDisabled() == true){
            return;
        }
        //Arm isn't closed
        armSolenoid.toggle();
        return;
    }

    public void extendArm(){
        //If arm is already open, it does nothing
        if (armSolenoid.isRevSolenoidDisabled() == false && armSolenoid.isFwdSolenoidDisabled() == true){
            return;
        }
        //Arm isn't open
        armSolenoid.toggle();
        return;

    
    }

    
    //deployGamePieceRoutine
}

