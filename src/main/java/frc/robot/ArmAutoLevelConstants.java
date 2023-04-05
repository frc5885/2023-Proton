package frc.robot;

import frc.robot.Constants;

public class ArmAutoLevelConstants {
    public static ArmAutoLevelConstants LEVEL_1 = new ArmAutoLevelConstants(Constants.levelOneTarget, 0.0, 0.5);
    public static ArmAutoLevelConstants LEVEL_2 = new ArmAutoLevelConstants(Constants.levelTwoTarget, 0.5, 0.5);
    public static ArmAutoLevelConstants LEVEL_3 = new ArmAutoLevelConstants(Constants.levelThreeTarget, 0.5, 0.5);
    
    public double target;
    public double approachTime;
    public double approachSpeed = 0.0;

    private ArmAutoLevelConstants(double target, double approachTime, double approachSpeed) {
        this.target = target;
        this.approachTime = approachTime;
        this.approachSpeed = approachSpeed;
    }
}
