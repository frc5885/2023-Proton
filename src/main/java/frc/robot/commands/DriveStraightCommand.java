package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivingSubsystem;
import edu.wpi.first.wpilibj.Timer;

public class DriveStraightCommand extends CommandBase {
    private final DrivingSubsystem m_drivingSubsystem;
    double m_direction = 1; //1 is forward -1 is reversed
    private double m_speed;
    private final Timer m_timer = new Timer(); 
    private double m_time;  
    
    public DriveStraightCommand(DrivingSubsystem drivingSubsystem, double speed, double time, boolean isReversed) {
        m_drivingSubsystem = drivingSubsystem;
        m_time = time;
        m_speed = speed;
        m_direction = isReversed ? -1.0 : 1.0;
        addRequirements(m_drivingSubsystem);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {

    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        double speed = -m_speed * m_direction;
        m_drivingSubsystem.drive(speed, speed, 1);
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        m_drivingSubsystem.drive(0, 0, 0);
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        boolean isFinished = (m_timer.get() > m_time);
        return isFinished;
    }

    @Override
    public boolean runsWhenDisabled() {
        return false;
    }
}
