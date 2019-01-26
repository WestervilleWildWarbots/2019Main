package frc.robot;

public class RobotMap {
  //Autonomous
  public static final double AUTONOMOUS_SPEED = .25;

  public static final boolean ALLOW_LIFT_PID = true; // Enables / disables Lift PID
  public static final boolean ALLOW_LIFT_MOVEMENT = true; // Enable / disable the lift from moving up and down

  // Cargo/hatch lifter
	public static final int LIFT_TALON = 41;
	public static double setPoint = 0;

  //Posible drive methods
  public static final int DRIVE_STICK = 0;
  public static final int XBOX_CONTROLLER = 1;
  public static final int FRONT_DISTANCE_SENSOR = 7;
  public static final int REAR_DISTANCE_SENSOR = 8;
  public static final int LINE_TRACKER = 6;
  public static final int ANALOG_GYRO = 9;
  public static final int MOTOR_FL = 2;
  public static final int MOTOR_FR = 3;
  public static final int MOTOR_BL = 4;
  public static final int MOTOR_BR = 5;
  //the default value to pass to getDouble() calls for NetworkTable
  public static final double DEFAULT_VALUE=0;
  
  // Arm buttons
  public static final int ARM_UP_BUTTON = 4; // Button Y
  public static final int ARM_DOWN_BUTTON = 2; // Button X

  //Sensors
  public static final int TOP_LIMIT_SWITCH_ID = 0;
	public static final int BOTTOM_LIMIT_SWITCH_ID = 1;
}
