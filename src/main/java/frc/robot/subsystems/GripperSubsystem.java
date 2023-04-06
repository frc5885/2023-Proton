package frc.robot.subsystems;
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
    
        compressor = new Compressor(Constants.PneumaticsID, PneumaticsModuleType.CTREPCM);
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
    public void closeGripper() {
        //Gripper isn't closed
        if(gripSolenoid.get() != Value.kReverse){
            gripSolenoid.set(Value.kReverse);
            System.out.println("&&& gripper closed &&&");
        }
    }

    public void openGripper() {
        //Gripper isn't closed
        if(gripSolenoid.get() != Value.kForward){
            gripSolenoid.set(Value.kForward);
            System.out.println("&&& gripper opened &&&");
        }
    }

    public void retractArm() {
        //Gripper isn't closed
        if(armSolenoid.get() != Value.kForward){
            armSolenoid.set(Value.kForward);
            System.out.println("&&& arm retracted &&&");
        }
    }

    public void extendKicker() {
        retractArm();
    }
    
    public void extendArm() {
        //Gripper isn't closed
        if(armSolenoid.get() != Value.kReverse){
            armSolenoid.set(Value.kReverse);
            System.out.println("&&& arm extended &&&");

        }
    }

    public void retractKicker() {
        extendArm();
    }

    public void disableCompressor() {
        compressor.disable();
    }

    public void enableCompressor() {
        compressor.enableDigital();
    }
}