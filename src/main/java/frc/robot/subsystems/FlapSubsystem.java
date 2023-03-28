package frc.robot.subsystems;

import frc.robot.commands.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import frc.robot.Constants;



public class FlapSubsystem extends SubsystemBase {

    public DoubleSolenoid m_flapSolenoid;  //raise and lower flaps


    public FlapSubsystem() {
        m_flapSolenoid = new DoubleSolenoid(Constants.PneumaticsID, PneumaticsModuleType.CTREPCM, 6, 7);
        addChild("m_flapSolenoid", m_flapSolenoid);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run when in simulation
    }

    public void raiseFlaps() {
        m_flapSolenoid.set(Value.kReverse);

    }

    public void lowerFlaps() {
        m_flapSolenoid.set(Value.kForward);

    }

    public boolean isLowered(){
        return m_flapSolenoid.get() == Value.kForward;
    }
}