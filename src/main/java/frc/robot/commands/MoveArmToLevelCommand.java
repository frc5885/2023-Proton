package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.FlapSubsystem;

public class MoveArmToLevelCommand extends CommandBase {
    private final FlapSubsystem  m_flapSubsystem;
    private final ArmSubsystem m_armSubsystem;
    private final double m_targetPos;
    private final Timer m_timer = new Timer();

    public MoveArmToLevelCommand(FlapSubsystem flapSubsystem, ArmSubsystem armSubsystem, double targetPos) {
        m_flapSubsystem = flapSubsystem;
        m_armSubsystem = armSubsystem;
        m_targetPos = targetPos;
        // addRequirements(m_flapSubsystem);
        addRequirements(m_armSubsystem);
    }

    @Override
    public void initialize() {
        m_timer.reset();
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        m_timer.start();

        //before the arm moves, flaps have to be lowered or they will interfere with arm
        // if (!m_flapSubsystem.isLowered()){
        //     System.out.println("\n\n\n!!!!!! The Arm lowered the Flaps!!!!!!\n\n\n");
        //     m_flapSubsystem.lowerFlaps();
        // }
        // if (m_timer.get() >= 0.1){
            m_armSubsystem.goToClosedLoopPosition(m_targetPos);
        // }
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {   
        System.out.println("Move arm to level command has been interupted *****");
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        if (m_armSubsystem.motorOutput() == 0 && m_timer.get() > 0.2) {
            System.out.println("\n\n%%%% Arm has reached position %%%%\n\n");
            return true;
        }

        return false;
    }

    @Override
    public boolean runsWhenDisabled() {
        return false;
    }
}
