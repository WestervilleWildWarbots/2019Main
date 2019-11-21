package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDBase;
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

  private int slot = 0;
	private int timeoutMs = 100;
	private double p = 1;
	private double i = 1;
	private double d = 1;
	private double f = 1;
  private double rampRate = 2;
  
  private static AnalogGyro Gyro = new AnalogGyro(RobotMap.ANALOG_GYRO);

  public DriveSubsystem() {
    frontLeft = new WPI_TalonSRX(RobotMap.MOTOR_FL);
    frontRight = new WPI_TalonSRX(RobotMap.MOTOR_FR);
    backLeft = new WPI_TalonSRX(RobotMap.MOTOR_BL);
    backRight = new WPI_TalonSRX(RobotMap.MOTOR_BR);

    frontRight.setInverted(true);

    backLeft.follow(frontLeft);
    backRight.follow(frontRight);

    frontLeft.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);

    frontLeft.setSensorPhase(true);
		frontLeft.config_kP(slot, p, timeoutMs);
		frontLeft.config_kI(slot, i, timeoutMs);
		frontLeft.config_kD(slot, d, timeoutMs);
		frontLeft.configClosedloopRamp(rampRate, timeoutMs);
		frontLeft.configNominalOutputForward(0,  timeoutMs);
		frontLeft.configNominalOutputReverse(0,  timeoutMs);
		frontLeft.configPeakOutputForward(1,  timeoutMs);
    frontLeft.configPeakOutputReverse(-1,  timeoutMs);
      
    frontRight.setSensorPhase(true);
		frontRight.config_kP(slot, p, timeoutMs);
		frontRight.config_kI(slot, i, timeoutMs);
		frontRight.config_kD(slot, d, timeoutMs);
		frontRight.configClosedloopRamp(rampRate, timeoutMs);
		frontRight.configNominalOutputForward(0,  timeoutMs);
		frontRight.configNominalOutputReverse(0,  timeoutMs);
		frontRight.configPeakOutputForward(1,  timeoutMs);
		frontRight.configPeakOutputReverse(-1,  timeoutMs);



  }

  @Override
  public void initDefaultCommand(){

  }


  public static double getGyro(){
      return Gyro.getAngle();
  }

  public double getEncoderFL() {
    return frontLeft.getSensorCollection().getQuadraturePosition();
  }

  public double getEncoderFR(){
    return frontRight.getSensorCollection().getQuadraturePosition();
  }

  public void drive(double leftSpeed, double rightSpeed) {

    if(RobotMap.TESTING_PID_VALUES){
      p = 1;
      i = 1;
      d = 1;
      f = 1;
      
    frontLeft.config_kP(slot, p, timeoutMs);
    frontLeft.config_kI(slot, i, timeoutMs);
    frontLeft.config_kD(slot, d, timeoutMs);

    frontRight.config_kP(slot, p, timeoutMs);
    frontRight.config_kI(slot, i, timeoutMs);
    frontRight.config_kD(slot, d, timeoutMs);
    }

    double targetLeftVelocity_UnitsPer100ms = leftSpeed * 12000;//12000;
    double targetRightVelocity_UnitsPer100ms = rightSpeed * 12000;//xxx
    frontLeft.set(ControlMode.Velocity, targetLeftVelocity_UnitsPer100ms);
    frontRight.set(ControlMode.Velocity, targetRightVelocity_UnitsPer100ms);
  }


}