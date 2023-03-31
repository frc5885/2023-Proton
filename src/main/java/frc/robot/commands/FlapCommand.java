package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import frc.robot.subsystems.DrivingSubsystem;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.GripperSubsystem;
import frc.robot.subsystems.FlapSubsystem;

public class FlapCommand extends CommandBase {
    private final FlapSubsystem m_flapSubsystem;
    private boolean m_finished = false;
    
    public FlapCommand(FlapSubsystem flapSubsystem) {
        m_flapSubsystem = flapSubsystem;
        addRequirements(m_flapSubsystem);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        m_finished = false;

    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        if (!m_finished) {
            if (m_flapSubsystem.isLowered()) {
                m_flapSubsystem.raiseFlaps();
                System.out.println("\n\n\n***FLAP Raised****\n\n\n");
            }
            else {
                m_flapSubsystem.lowerFlaps();
                System.out.println("***FLAP Lowered****");
            }
            m_finished = true;
        }
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return m_finished;
    }


    @Override
    public boolean runsWhenDisabled() {
        return false;
    }
}
