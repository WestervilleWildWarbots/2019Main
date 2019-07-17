package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class DriveSubsystem extends Subsystem {
  private static WPI_TalonSRX frontLeft;
  private static WPI_TalonSRX frontRight;
  private static WPI_TalonSRX backLeft;
  private static WPI_TalonSRX backRight;

  private static AnalogGyro Gyro = new AnalogGyro(RobotMap.ANALOG_GYRO);

  public DriveSubsystem() {
    frontLeft = new WPI_TalonSRX(RobotMap.MOTOR_FL);
    frontRight = new WPI_TalonSRX(RobotMap.MOTOR_FR);
    backLeft = new WPI_TalonSRX(RobotMap.MOTOR_BL);
    backRight = new WPI_TalonSRX(RobotMap.MOTOR_BR);

    frontRight.setInverted(true);

    backLeft.follow(frontLeft);
    backRight.follow(frontRight);
  }

  @Override
  public void initDefaultCommand(){

  }


  public static double getGyro(){
      return Gyro.getAngle();
  }


  public void drive(double leftSpeed, double rightSpeed) {
    frontLeft.set(leftSpeed);
    frontRight.set(rightSpeed);
  }

  
}
