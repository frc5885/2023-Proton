// RobotBuilder Version: 5.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: Subsystem.

package frc.robot.subsystems;

import frc.robot.Constants;
import frc.robot.commands.*;

import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.PWMTalonSRX;

public class DrivingSubsystem extends SubsystemBase {
    private WPI_TalonSRX leftFrontMotor;
    private WPI_TalonSRX leftRearMotor;
    private MotorControllerGroup leftMotorController;
    private WPI_TalonSRX rightFrontMotor;
    private WPI_TalonSRX rightRearMotor;
    private MotorControllerGroup rightMotorController;
    public DifferentialDrive differentialDrive;
    public AnalogGyro gyroscope;
  
    public DrivingSubsystem() {
        leftFrontMotor = new WPI_TalonSRX(Constants.LeftFrontMotorID);
        addChild("LeftFrontMotor",leftFrontMotor);
        leftFrontMotor.setInverted(true);


        // just guessing which motor we will be using the encoder from
        // todo: update!
        leftFrontMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative,
            Constants.wheelEncoderPIDLoopIndex, Constants.wheelEncoderTimeoutMs);
        leftFrontMotor.setSensorPhase(true);

        // todo: set F,K,P,I,D!
        leftFrontMotor.config_kF(Constants.wheelEncoderPIDLoopIndex,0.0, Constants.wheelEncoderTimeoutMs);
        leftFrontMotor.config_kP(Constants.wheelEncoderPIDLoopIndex,0.0, Constants.wheelEncoderTimeoutMs);
        leftFrontMotor.config_kI(Constants.wheelEncoderPIDLoopIndex,0.0, Constants.wheelEncoderTimeoutMs);
        leftFrontMotor.config_kD(Constants.wheelEncoderPIDLoopIndex,0.0, Constants.wheelEncoderTimeoutMs);



        leftRearMotor = new WPI_TalonSRX(Constants.LeftRearMotorID);
        addChild("LeftRearMotor",leftRearMotor);
        leftRearMotor.setInverted(true);

        leftMotorController = new MotorControllerGroup(leftFrontMotor, leftRearMotor);
        addChild("LeftMotorController",leftMotorController);

        rightFrontMotor = new WPI_TalonSRX(Constants.RightFrontMotorID);
        addChild("RightFrontMotor",rightFrontMotor);
        rightFrontMotor.setInverted(false);

        rightRearMotor = new WPI_TalonSRX(Constants.RightRearMotorID);
        addChild("RightRearMotor",rightRearMotor);
        rightRearMotor.setInverted(false);

        rightMotorController = new MotorControllerGroup(rightFrontMotor, rightRearMotor);
        addChild("RightMotorController",rightMotorController);

        differentialDrive = new DifferentialDrive(leftMotorController, rightMotorController);
        addChild("DifferentialDrive",differentialDrive);
        differentialDrive.setSafetyEnabled(false);
        differentialDrive.setExpiration(0.1);
        differentialDrive.setMaxOutput(1.0);

        gyroscope = new AnalogGyro(1);
        addChild("Gyroscope",gyroscope);
        gyroscope.setSensitivity(0.007);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
     
    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run when in simulation

    }

    public void drive(double LeftMotorSpeed, double RightMotorSpeed, double speedFactor) {
        differentialDrive.setMaxOutput(speedFactor);
        differentialDrive.tankDrive(LeftMotorSpeed, RightMotorSpeed);
    }

    public double getAngle() {
        return gyroscope.getAngle();
    }
}

