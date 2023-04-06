package frc.robot;

public class ChooserConstants {
    public static final ChooserConstants CubeLevelOne = new ChooserConstants("Level 1", 1);
    public static final ChooserConstants CubeLevelTwo = new ChooserConstants("Level 2", 2);
    public static final ChooserConstants CubeLevelThree = new ChooserConstants("Level 3", 3);

    public static final ChooserConstants DoNothing = new ChooserConstants("Do Nothing", 0);
    public static final ChooserConstants LeaveCommunity = new ChooserConstants("Leave", 10);
    public static final ChooserConstants Balance = new ChooserConstants("Balance", 20);

    public String m_string = "";
    public int m_value = 0;

    private ChooserConstants(String str, int value) {
        m_string = str;
        m_value = value;
    }
}
