package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Logger;
import frc.robot.RobotMap;

import frc.robot.AutoDrivable;

public class DriveSubsystem extends Subsystem implements AutoDrivable {
  private static WPI_TalonSRX frontLeft;
  private static WPI_TalonSRX frontRight;
  private static WPI_TalonSRX backLeft;
  private static WPI_TalonSRX backRight;

  //private static AnalogInput FrontDist = new AnalogInput(RobotMap.FRONT_DISTANCE_SENSOR);
  //private static AnalogInput RearDist = new AnalogInput(RobotMap.REAR_DISTANCE_SENSOR);
  //private static AnalogInput LeftDist = new AnalogInput(RobotMap.LEFT_DISTANCE_SENSOR);
  //private static AnalogInput RightDist = new AnalogInput(RobotMap.RIGHT_DISTANCE_SENSOR);

  private static AnalogGyro Gyro = new AnalogGyro(RobotMap.ANALOG_GYRO);

  //initialize the NetworkTable and store a reference to it in table
  private NetworkTableInstance table;

  public DriveSubsystem() {
    table = NetworkTableInstance.getDefault();
    frontLeft = new WPI_TalonSRX(RobotMap.MOTOR_FL);
    frontRight = new WPI_TalonSRX(RobotMap.MOTOR_FR);
    backLeft = new WPI_TalonSRX(RobotMap.MOTOR_BL);
    backRight = new WPI_TalonSRX(RobotMap.MOTOR_BR);
    //frontLeft.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
    //frontRight.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
    //frontLeft.setSelectedSensorPosition(0);
    //frontRight.setSelectedSensorPosition(0);

    frontRight.setInverted(true);
    //frontDist = new AnalogInput();

    backLeft.follow(frontLeft);
    backRight.follow(frontRight);
  }
/*
  private void resetEncoders() {
    frontLeft.getSensorCollection().setQuadraturePosition(0, 0);
    frontRight.getSensorCollection().setQuadraturePosition(0, 0);

  }
*/
  @Override
  public void initDefaultCommand(){

  }
  /*
  public static int getLeftTicks() {
    Logger.Log("DriveSubsystem got left encoder");
    return frontLeft.getSensorCollection().getQuadraturePosition();
  }
*/
  /*
  public static int getRightTicks() {
    Logger.Log("DriveSubsystem got right encoder");
    return frontRight.getSensorCollection().getQuadraturePosition();
  }
*/
  public static int feetToTicks(double distanceInFeet){
    double ticksPerFoot = RobotMap.TICKS_PER_REVOLUTION/RobotMap.WHEEL_DIAMETER;
    int ticks = (int)(distanceInFeet * ticksPerFoot);
    return ticks;
  }
  /*
  public static int getFrontDist() {
    return FrontDist.getValue();
  }

  public static int getRearDist() {
    return RearDist.getValue();
  }

  public static int getLeftDist() {
    return LeftDist.getValue();
  }

  public static int getRightDist() {
    return RightDist.getValue();
  }
*/
  public static double getGyro(){
      return Gyro.getAngle();
  }

  public double normalizeAngle(double angle){
    if(angle < 0){
      return angle + 360;
    } else{
      return angle;
    }
  }

  public void drive(double leftSpeed, double rightSpeed) {
    Logger.Log("DriveSubsystem drived");
    frontLeft.set(leftSpeed);
    frontRight.set(rightSpeed);
  }

  /* Begin AutoDrivable implementation */
  @Override
  public void stop(){
    frontLeft.set(0);
    frontRight.set(0);
  }

 
  public void turnToHeading(double angleInDegrees){
    //This should turn the the specified heading and then stop
    double normalizedAngle = normalizeAngle(angleInDegrees);

    double initialHeading = getGyro();
    double deltaAngle = normalizedAngle - initialHeading;

    if(deltaAngle <= 180){
      while(deltaAngle > 0){
        frontLeft.set(.5);
        frontRight.set(-.5);
        deltaAngle = normalizedAngle - getGyro();
      }
    } else{
      while(deltaAngle > 0){
        frontLeft.set(-.5);
        frontRight.set(.5);
        deltaAngle = normalizedAngle - getGyro();
      }
    }
    stop();
  }

  @Override
  public void autoDrive(double feet){
    /*
    //This should drive $feet feet forward and then stop
    int ticksToGo = feetToTicks(feet);
    int initialLeftTicks = getLeftTicks();
    //int initialRightTicks = getRightTicks();

    //start motors
    frontLeft.set(.5);
    frontRight.set(.5);

    while(ticksToGo > 0){
      ticksToGo -= (getLeftTicks() - initialLeftTicks);
      //environment checks (eg other robots, other emergency conditions)
    }
    stop();
    */
    frontLeft.set(.5);
    frontRight.set(-.5);
    try{
      wait((long)(100 * feet));
    } catch(Exception e){

    }
    stop();
  }

  /* End AutoDrivable implementation */
}
