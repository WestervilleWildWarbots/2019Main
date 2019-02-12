package frc.robot;

public class RobotMap {
  //Autonomous
  public static final double AUTONOMOUS_SPEED = .25;

  public static boolean releaseDone = false;
  public static boolean extendDone = false;
  public static boolean grabDone = false;

  public static final boolean ALLOW_LIFT_PID = true; // Enables / disables Lift PID
  public static final boolean ALLOW_LIFT_MOVEMENT = true; // Enable / disable the lift from moving up and down

  // Cargo/hatch lifter
	public static final int LIFT_TALON = 41;
  public static double setPoint = 0;
  public static double armPos = 0;
  public static boolean isAligned = false;

  //Posible drive methods
  public static final int DRIVE_STICK = 0; 
  public static final int XBOX_CONTROLLER = 1;
  
  public static final int FRONT_DISTANCE_SENSOR = 7;
  public static final int REAR_DISTANCE_SENSOR = 8;
  public static final int LEFT_DISTANCE_SENSOR = 25;
  public static final int RIGHT_DISTANCE_SENSOR = 26;
  
  public static final int LINE_TRACKER = 10;
  public static final int ANALOG_GYRO = 9;

  public static final int PNUM_GRABL = 8;
  public static final int PNUM_RELEASEL = 8;
  public static final int PNUM_GRABR = 8;
  public static final int PNUM_RELEASER = 8;
  public static final int PNUM_OUT = 8;
  public static final int PNUM_IN = 8;
  
  public static final int MOTOR_FL = 11;
  public static final int MOTOR_FR = 12;
  public static final int MOTOR_BL = 21;
  public static final int MOTOR_BR = 22;
  public static final int MOTOR_LIFT = 32;

  public static int ENCODER_FL = 20;
  public static int ENCODER_FR = 21;
  public static int ENCODER_BL = 22;
  public static int ENCODER_BR = 23;
  public static int ENCODER_LIFT = 24;

  //Sensors
  public static final int TOP_LIMIT_SWITCH_ID = 0;
	public static final int BOTTOM_LIMIT_SWITCH_ID = 1;
}
