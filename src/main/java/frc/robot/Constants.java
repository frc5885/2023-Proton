// RobotBuilder Version: 5.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public class Constants {
    // CAN bus IDs (Proton) 
    public static final int PneumaticsID = 1; 
    public static final int ArmMotorID = 2;
    public static final int LeftRearMotorID =  6;
    public static final int LeftFrontMotorID = 5;
    public static final int RightRearMotorID = 3;
    public static final int RightFrontMotorID = 4;

    // CAN bus IDs (Pedro) 
    // public static final int PneumaticsID = 1; 
    // public static final int ArmMotorID = 2;
    // public static final int LeftRearMotorID =  3;
    // public static final int LeftFrontMotorID = 4;
    // public static final int RightRearMotorID = 2;
    // public static final int RightFrontMotorID = 1;

    public static final int GyroPort = 0;
    public static final int LeftWheelEncoderID = -1;
    public static final int RightWheelEncoder = -1;
    public static final int GraberSolenoidID = -1;
    public static final int Camera1USBPortID = 0;
    public static final int Camera2USBPortID = 1;
    public static final int LeftYAxis = 1;
    public static final int RightYAxis = 5;
    public static final double slowDriveSpeedFactor = .6;   // turbo NOT engaged (0 < speed < turbo)
    public static final double turboDriveSpeedFactor = 1.0; // turbo engaged, make < 1 for beginner driver
    public static final double joystickMatchTolerance = 0.9;
    public static final int armEncoderAChannel = 1;
    public static final int armEncoderBChannel = 2;
    public static final int armEncoderPIDLoopIndex = 0;
    public static final int armEncoderTimeoutMs = 30;
    public static final int armEncoderCountsPerInch = 123345; // todo - set this properly

    
    public static final double armSpeedFactor = 1;

    public static final String kBalance = "Charging Station";
    public static final String kCrossLine = "Leave Community";
    public static final String kConekick = "Kick Cone";
    public static final String Level3 = "Put cube level 3";

    public static final double levelZeroTarget = 0.0;
    public static final double levelOneTarget = -42000.0;
    public static final double levelTwoTarget = -98000.0;
    public static final double levelThreeTarget = -118000.0;

    public static final int gripperOpenButton = 2; //X Button
    public static final int gripperCloseButton = 3; //Y Button
    public static final int armExtendButton = 1; //B Button
    public static final int armRetractButton = 0; // A Button
}

