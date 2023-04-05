package frc.robot;

import frc.robot.Constants;

public class ArmAutoLevelConstants {
    public static ArmAutoLevelConstants LEVEL_1 = new ArmAutoLevelConstants(Constants.levelOneTarget,
        Constants.levelOneApproachTime, Constants.approachSpeed);
    public static ArmAutoLevelConstants LEVEL_2 = new ArmAutoLevelConstants(Constants.levelTwoTarget,
        Constants.levelTwoApproachTime, Constants.approachSpeed);
    public static ArmAutoLevelConstants LEVEL_3 = new ArmAutoLevelConstants(Constants.levelThreeTarget,
        Constants.levelThreeApproachTime, Constants.approachSpeed);
    
    public double m_target;
    public double m_approachTime;
    //TODO set correct speed
    public double m_approachSpeed;

    private ArmAutoLevelConstants(double target, double approachTime, double approachSpeed) {
        m_target = target;
        m_approachTime = approachTime;
        m_approachSpeed = approachSpeed;
    }
}
