package frc.robot;
import java.util.*; 
import frc.robot.ControllerPoint;

public class SwitchController {
    private final double m_maxPower = .5;     // maximum power that we want to supply
    private List<ControllerPoint> m_points = new ArrayList<ControllerPoint>();

    public SwitchController() {
        m_points.add(new ControllerPoint(0.0, 0.0));
        m_points.add(new ControllerPoint(1.0, 0.2));
        m_points.add(new ControllerPoint(2.0, 0.2));
        m_points.add(new ControllerPoint(3.0, 0.2));
        m_points.add(new ControllerPoint(4.0, 0.3));
        m_points.add(new ControllerPoint(5.0, 0.3));
        m_points.add(new ControllerPoint(6.0, 0.35));
        m_points.add(new ControllerPoint(7.0, 0.4));
        m_points.add(new ControllerPoint(8.0, 0.45));
        m_points.add(new ControllerPoint(9.0, 0.47));
        m_points.add(new ControllerPoint(10.0, 0.55));
        m_points.add(new ControllerPoint(11.0, 0.57));
        m_points.add(new ControllerPoint(12.0, 0.58));
        m_points.add(new ControllerPoint(13.0, 0.6));
        m_points.add(new ControllerPoint(14.0, 0.62));
        m_points.add(new ControllerPoint(15.0, 0.65));//0.63));
        m_points.add(new ControllerPoint(16.0, 0.7));
        m_points.add(new ControllerPoint(17.0, 0.8));
    };

    public double GetPower(double angle) {
        int index1 = LowerIndex(angle);
        int index2  = UpperIndex(angle);
        
        //check to avoid division by 0
        if (index1 == index2){
            return m_points.get(index1).m_power;
        }

        // Sets points based off the indices in our list
        // (a1, p1) is the point of the index that is the greatest and lower than the angle
        // (a2, p2) is the point of the index that is the lowest and larger than the angle

        double a1 = m_points.get(index1).m_angle;
        double a2 = m_points.get(index2).m_angle;
        double p1 = m_points.get(index1).m_power;
        double p2 = m_points.get(index2).m_power;

        //prevent divide by almost 0 errors
        if (angle - a1 < 0.01 ){
            return p1;
        }

        if (a2 - angle < 0.01){
            return p2; 
        }

         // Similar triangles between (a1, p1) and (a2, p2) to interpolate

        double power = (((angle - a1) * (p2 - p1)) / (a2 - a1)) + p1;
        return power;        
    }

    // Returns the index for the greatest angle less than angle
    // I: angle - input angle from gyroscope
    int LowerIndex(double angle) {
        int index = 0;
        while (index < m_points.size() && angle >= m_points.get(index).m_angle) {
            ++index;
        }

        if (index > 0)
        {
            --index;
        }

        return index;
    }

    // Returns the index for the lowest angle greater than the angle
    // I: angle - input angle from gyroscope

    int UpperIndex(double angle) {
        int index = m_points.size() - 1;
        while (index >= 0 && angle <= m_points.get(index).m_angle) {
            --index;
        }
        
        if (index < m_points.size() - 1) {
            ++index;
        }

        return index;
    }
}
