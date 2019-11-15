package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import frc.robot.RobotMap;

public class DriveSubsystem extends Subsystem {
  private static WPI_TalonSRX frontLeft;
  private static WPI_TalonSRX frontRight;
  private static WPI_TalonSRX backLeft;
  private static WPI_TalonSRX backRight;
  private static double pFL = 1;
  private static double iFL = 1;
  private static double dFL = 1;
  public PIDSource inputFL;
  private PIDOutput outputFL;

  private static AnalogGyro Gyro = new AnalogGyro(RobotMap.ANALOG_GYRO);

  public DriveSubsystem() {
    frontLeft = new WPI_TalonSRX(RobotMap.MOTOR_FL);
    frontRight = new WPI_TalonSRX(RobotMap.MOTOR_FR);
    backLeft = new WPI_TalonSRX(RobotMap.MOTOR_BL);
    backRight = new WPI_TalonSRX(RobotMap.MOTOR_BR);

    frontRight.setInverted(true);

    backLeft.follow(frontLeft);
    backRight.follow(frontRight);

    inputFL = getEncoderFL();

  new PIDController(pFL, iFL, dFL, inputFL, outputFL);

  }

  @Override
  public void initDefaultCommand(){

  }


  public static double getGyro(){
      return Gyro.getAngle();
  }

  public PIDSource getEncoderFL() {
    return frontLeft.getSensorCollection().getQuadraturePosition();
  }

  public void getEncoderFR(){
    frontRight.getSensorCollection().getQuadraturePosition();
  }

  public void getEncoderBL(){
    backLeft.getSensorCollection().getQuadraturePosition();
  }

  public void getEncoderBR(){
    backRight.getSensorCollection().getQuadraturePosition();
  }

  public void drive(double leftSpeed, double rightSpeed) {
    frontLeft.set(leftSpeed);
    frontRight.set(rightSpeed);
  }


}