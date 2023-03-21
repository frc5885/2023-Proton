package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.subsystems.DrivingSubsystem;
import frc.robot.subsystems.CubeKickSubsystem;

public class LeaveCommunityCommand extends CommandBase {
    private final DrivingSubsystem m_drivingSubsystem;
    private final CubeKickSubsystem m_kickSubsystem;

    // Does the power calculation for a given ramp angle
    private final Timer m_delay = new Timer();
    boolean m_timerStarted = false;
    private boolean m_kickCube = false;    
    
    public LeaveCommunityCommand(CubeKickSubsystem kickSubsystem, boolean kickCube, DrivingSubsystem drivingSubsystem) {
        m_kickSubsystem = kickSubsystem;
        m_drivingSubsystem = drivingSubsystem;
        m_kickCube = kickCube;
        addRequirements(m_drivingSubsystem);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        m_delay.reset();
        m_delay.start();
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        if (m_kickCube)
        {
            // kick the cube at the start of autonomous
            m_kickSubsystem.extendKicker();
            m_kickCube = false;
        }

        if (m_delay.get() > 1 ){
            m_drivingSubsystem.drive(-.75, -.75, 1.0);
        }
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        if (!interrupted) {
            m_drivingSubsystem.drive(0, 0, 1);
            System.out.println("End!!!");
        }
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        boolean finished = (m_delay.get() > 5.25);
        return finished;
    }


    @Override
    public boolean runsWhenDisabled() {
        return false;
    }
}