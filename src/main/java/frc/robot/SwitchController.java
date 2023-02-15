package frc.robot;
import java.util.*; 
import frc.ControllerPoint;

public class SwitchController {
    private final double m_maxPower = .5;     // maximum power that we want to supply
    private final double m_powerScale = 1.0;  // scale output up/down quickly
    private List<ControllerPoint> m_points = new ArrayList<ControllerPoint>();

    public SwitchController() {
        m_points.add(new ControllerPoint(0.0, 0.0));
        m_points.add(new ControllerPoint(1.0, 0.0));
        m_points.add(new ControllerPoint(2.0, 0.0));
        m_points.add(new ControllerPoint(3.0, 0.0));
        m_points.add(new ControllerPoint(4.0, 0.0));
        m_points.add(new ControllerPoint(5.0, 0.0));
        m_points.add(new ControllerPoint(6.0, 0.0));
        m_points.add(new ControllerPoint(7.0, 0.0));
        m_points.add(new ControllerPoint(8.0, 0.0));
        m_points.add(new ControllerPoint(9.0, 0.0));
        m_points.add(new ControllerPoint(10.0, 0.0));
    };

    public double GetPower(double angle) {
        int index1 = LowerIndex(angle);
        int index2  = UpperIndex(angle);
        
        //check to avoid division by 0
        if (index1 == index2){
            return m_points.get(index1).m_power;
        }
        // Similar triangles between p and a to interpolate

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
        
        double power = (((angle - a1) * (p2 - p1)) / (a2 - a1)) + p1;
        return power;        
    }

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
