package frc.robot;

public class RobotMap {
  //Autonomous
  public static final double AUTONOMOUS_SPEED = .25;
  
  //Posible drive methods
  public static final int DRIVE_STICK = 0;
  public static final int XBOX_CONTROLLER = 1;

  public static final int FRONT_DISTANCE_SENSOR = 7;
  public static final int REAR_DISTANCE_SENSOR = 8;
  
  public static final int LINE_TRACKER = 6;
  public static final int ANALOG_GYRO = 9;
  
  public static final int PNUM_LIFTUP = 10;
  public static final int PNUM_LIFTDOWN = 11;
  public static final int PNUM_GRABL = 12;
  public static final int PNUM_RELEASEL = 14;
  public static final int PNUM_GRABR = 13;
  public static final int PNUM_RELEASER = 15;
  
  public static final int MOTOR_FL = 2;
  public static final int MOTOR_FR = 3;
  public static final int MOTOR_BL = 4;
  public static final int MOTOR_BR = 5;
  //the default value to pass to getDouble() calls for NetworkTable
  public static final double DEFAULT_VALUE=0;
}
