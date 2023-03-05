package frc.robot.subsystems;

import frc.robot.commands.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import frc.robot.Constants;

public class CubeKickSubsystem extends SubsystemBase {

    private DoubleSolenoid m_kickSolenoid;    //open and closing gripper solenoid which controls valve

    public CubeKickSubsystem() {
        m_kickSolenoid = new DoubleSolenoid(Constants.PneumaticsID, PneumaticsModuleType.CTREPCM, 6, 7);
        addChild("m_kickSolenoid", m_kickSolenoid);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run when in simulation
    }

    public void extendKicker() {
        m_kickSolenoid.set(Value.kForward);
    }
}