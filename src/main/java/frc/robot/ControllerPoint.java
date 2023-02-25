package frc.robot;

public class ControllerPoint {
    public double m_angle = 0.0;  // angle in deg. (x axis of graph)
    public double m_power = 0.0;  // power to motor (0-1) (y axis of graph)

    public ControllerPoint(double angle, double power)
    {
        m_angle = angle;
        m_power = power;
    }
}
