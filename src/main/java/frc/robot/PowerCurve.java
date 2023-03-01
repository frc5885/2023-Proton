package frc.robot;

public class PowerCurve {
    public static double getPoint(double input, double exp) {
        boolean isNegative = input < 0.0;
        double powdSpeed = Math.pow(Math.abs(input), exp);
        if (isNegative) {
            powdSpeed = -powdSpeed;
        }
        return powdSpeed;
    }
}
