package frc.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Sendable;

public class RobotMap {
  //set to true to use the pathfinder library, false for manual autonomous
  public static final boolean USE_PATHFINDER_LIB = false;
  //Autonomous
  public static final double AUTONOMOUS_SPEED = .25;

  public static final boolean ALLOW_LIFT_PID = true; // Enables / disables Lift PID
  public static boolean ALLOW_LIFT_MOVEMENT = true; // Enable / disable the lift from moving up and down

  //Limit Switches
  //public static DigitalInput MAXIMUM_LIM = new DigitalInput(1);
  //public static DigitalInput MINIMUM_LIM = new DigitalInput(2);

  //Drive controler
  // public static boolean Drivebool = true;

  //Cargohatch lifter
  public static final int LIFT_TALON = 31;
  public static final int LIFT_TALON_II = 32;
  public static double liftSetPoint = 0;
  public static double armPos = 0;
  public static boolean isAligned = false;

  //Posible drive methods
  public static final int DRIVE_STICK = 0;
  public static final int ARM_STICK = 1;
  public static final int FRONT_DISTANCE_SENSOR = 7;
  public static final int REAR_DISTANCE_SENSOR = 8;
  public static final int LEFT_DISTANCE_SENSOR = 25;
  public static final int RIGHT_DISTANCE_SENSOR = 26;
  public static final int LINE_TRACKER = 6;
  public static final int ANALOG_GYRO = 1;


  //ids are wrong - written in as to prevent error
  public static final int PNUM_GRAB = 2;
  public static final int PNUM_OUT = 3;
  public static final int PNUM_BREAK = 4;
  
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

  //Sensors
  public static final int TOP_LIMIT_SWITCH_ID = 0;
  public static final int BOTTOM_LIMIT_SWITCH_ID = 1;

  //Autonomous drive constants
  //TODO these must be assigned for things to work right
  public static final int TICKS_PER_REVOLUTION = 0;
  public static final double WHEEL_DIAMETER = 0;
  public static final double MAX_VELOCITY = 0;
  public static final boolean USE_ENCODERS = false;
}
