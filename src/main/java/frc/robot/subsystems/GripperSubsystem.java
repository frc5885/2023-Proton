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

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import frc.robot.Constants;

public class GripperSubsystem extends SubsystemBase {

    private DoubleSolenoid gripSolenoid;    //open and closing gripper solenoid which controls valve
    private DoubleSolenoid armSolenoid;     //extend and retract arm solenoid which controls valve
    private Compressor compressor;

    public GripperSubsystem() {
        armSolenoid = new DoubleSolenoid(Constants.PneumaticsID, PneumaticsModuleType.CTREPCM, 2, 3);
        addChild("ArmSolenoid", armSolenoid);

        gripSolenoid = new DoubleSolenoid(Constants.PneumaticsID, PneumaticsModuleType.CTREPCM, 0, 1);
        addChild("ArmSolenoid", gripSolenoid);
    
        compressor = new Compressor(0, PneumaticsModuleType.CTREPCM);
        addChild("Compressor",compressor);
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
        //Gripper isn't closed
        if(gripSolenoid.get() != Value.kReverse){
            gripSolenoid.set(Value.kReverse);
        }
    }

    public void openGripper(){
        //Gripper isn't closed
        if(gripSolenoid.get() != Value.kForward){
            gripSolenoid.set(Value.kForward);
        }
    }

    public void retractArm(){
        //Gripper isn't closed
        if(armSolenoid.get() != Value.kForward){
            armSolenoid.set(Value.kForward);
        }
    }

    public void extendKicker(){
        retractArm();
    }
    
    public void extendArm(){
        //Gripper isn't closed
        if(armSolenoid.get() != Value.kReverse){
            armSolenoid.set(Value.kReverse);
        }
    }

    public void retractKicker(){
        extendArm();
    }


}