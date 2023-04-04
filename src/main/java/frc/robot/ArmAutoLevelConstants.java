package frc;

import frc.robot.Constants;

public class ArmAutoLevelConstants {
    public static ArmAutoLevelConstants LEVEL_1 = new ArmAutoLevelConstants(Constants.levelOneTarget, 0.5);
    
    public double target;
    public double approachTime;

    private ArmAutoLevelConstants(double target, double approachTime) {
        this.target = target;
        this.approachTime = approachTime;
    }
}
