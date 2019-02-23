package frc.robot;

import edu.wpi.first.wpilibj.Sendable;

public class RobotMap {
  //Autonomous
  public static final double AUTONOMOUS_SPEED = .25;

  public static final boolean ALLOW_LIFT_PID = true; // Enables / disables Lift PID
  public static boolean ALLOW_LIFT_MOVEMENT = true; // Enable / disable the lift from moving up and down

  // Cargo/hatch lifter
	public static final int LIFT_TALON = 31;
	public static double liftSetPoint = 0;

  //Posible drive methods
  public static final int DRIVE_STICK = 0;
  public static final int XBOX_CONTROLLER = 1;
  public static final int FRONT_DISTANCE_SENSOR = 7;
  public static final int REAR_DISTANCE_SENSOR = 8;
  public static final int LEFT_DISTANCE_SENSOR = 25;
  public static final int RIGHT_DISTANCE_SENSOR = 26;
  public static final int LINE_TRACKER = 6;
  public static final int ANALOG_GYRO = 9;


  //ids are wrong - written in as to prevent error
  public static final int PNUM_GRABL = 6;
  public static final int PNUM_RELEASEL = 1;
  public static final int PNUM_GRABR = 2;
  public static final int PNUM_RELEASER = 3;
  public static final int PNUM_OUT = 4;
  public static final int PNUM_IN = 5;
  
  public static final int MOTOR_FL = 11;
  public static final int MOTOR_FR = 12;
  public static final int MOTOR_BL = 21;
  public static final int MOTOR_BR = 22;
  //the default value to pass to getDouble() calls for NetworkTable
  public static final double DEFAULT_VALUE=0;
  
  // Arm buttons
  public static final int ARM_UP_BUTTON = 4; // Button Y
  public static final int ARM_DOWN_BUTTON = 3; // Button X

  public static int ENCODER_L = 20;
  public static int ENCODER_R = 21;
  public static int ENCODER_LIFT = 24;

public static double isAligned;

  //Sensors
  public static final int TOP_LIMIT_SWITCH_ID = 0;
	public static final int BOTTOM_LIMIT_SWITCH_ID = 1;
}
