package frc.robot.commands;

import java.util.Map;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import frc.robot.RobotMap;
import edu.wpi.first.cameraserver.*;

import edu.wpi.first.networktables.NetworkTableInstance;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class MonitorCommand extends Command {
  private NetworkTableInstance table;

  AnalogInput  FrontDist = new AnalogInput(RobotMap.FRONT_DISTANCE_SENSOR);
  AnalogInput  RearDist = new AnalogInput(RobotMap.REAR_DISTANCE_SENSOR);
  AnalogInput  LeftDist = new AnalogInput(RobotMap.LEFT_DISTANCE_SENSOR);
  AnalogInput  RightDist = new AnalogInput(RobotMap.RIGHT_DISTANCE_SENSOR);

  DigitalInput  EncFl = new DigitalInput(RobotMap.ENCODER_FL);
  DigitalInput  EncFr = new DigitalInput(RobotMap.ENCODER_FR);
  DigitalInput  EncBl = new DigitalInput(RobotMap.ENCODER_BL);
  DigitalInput  EncBr = new DigitalInput(RobotMap.ENCODER_BR);
  DigitalInput  EncLift = new DigitalInput(RobotMap.ENCODER_LIFT);

  DigitalInput  LimitTop = new DigitalInput(RobotMap.TOP_LIMIT_SWITCH_ID);
  DigitalInput  LimitBase = new DigitalInput(RobotMap.BOTTOM_LIMIT_SWITCH_ID);

  AnalogGyro Gyro = new AnalogGyro(RobotMap.ANALOG_GYRO);
  DigitalInput TapeRead = new DigitalInput(RobotMap.LINE_TRACKER);
  
  public static double DEFAULT_VALUE=0;

  public MonitorCommand() {
    ShuffleboardTab tab1 = Shuffleboard.getTab("Tab 1");
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {

        //update Gyro number
        table.getEntry("gyro_angle").setValue(Gyro.getAngle());
        SmartDashboard.getEntry("gyro_angle").getDouble(DEFAULT_VALUE);
    
        
        //encoder updates
        table.getEntry("encoder_valueFL").setValue(EncFl.get());
        SmartDashboard.getEntry("encoder_valueFL").getDouble(DEFAULT_VALUE);
    
        table.getEntry("encoder_valueFR").setValue(EncFr.get());
        SmartDashboard.getEntry("encoder_valueFR").getDouble(DEFAULT_VALUE);
    
        table.getEntry("encoder_valueBL").setValue(EncBl.get());
        SmartDashboard.getEntry("encoder_valueBL").getDouble(DEFAULT_VALUE);
    
        table.getEntry("encoder_valueBR").setValue(EncBr.get());
        SmartDashboard.getEntry("encoder_valueBR").getDouble(DEFAULT_VALUE);
    
        table.getEntry("encoder_valueLift").setValue(EncLift.get());
        SmartDashboard.getEntry("encoder_valueLift").getDouble(DEFAULT_VALUE);
    
    
        //distance sensor updates
        table.getEntry("frontDist_value").setValue(FrontDist.getValue());
        SmartDashboard.getEntry("frontDist_value").getDouble(DEFAULT_VALUE);
    
        table.getEntry("rearDist_value").setValue(RearDist.getValue());
        SmartDashboard.getEntry("rearDist_value").getDouble(DEFAULT_VALUE);
    
        table.getEntry("leftDist_value").setValue(LeftDist.getValue());
        SmartDashboard.getEntry("leftDist_value").getDouble(DEFAULT_VALUE);
    
        table.getEntry("rightDist_value").setValue(RightDist.getValue());
        SmartDashboard.getEntry("rightDist_value").getDouble(DEFAULT_VALUE);
    
    
        //limit switch updates
        table.getEntry("top_limit").setBoolean(LimitTop.get());
        SmartDashboard.getEntry("top_limit").getDouble(DEFAULT_VALUE);
    
        table.getEntry("base_limit").setBoolean(LimitBase.get());
        SmartDashboard.getEntry("base_limit").getDouble(DEFAULT_VALUE);
    
    
        //line tracker updates
        table.getEntry("tape_read").setValue(TapeRead.get());
        SmartDashboard.getEntry("tape_read").getDouble(DEFAULT_VALUE);


    //Shuffleboard.getTab("Tab 1").add("Camera 1", 14).withWidget(BuiltInWidgets.kCameraStream).withProperties(Map.of("min", 0, "max", 62));

    //distance sensors to shuffleboard
    Shuffleboard.getTab("Tab 1").add("Dist Front", FrontDist.getValue()).withWidget(BuiltInWidgets.kDial).withProperties(Map.of("min", 0, "max", 62));
    Shuffleboard.getTab("Tab 1").add("Dist Rear", RearDist.getValue()).withWidget(BuiltInWidgets.kDial).withProperties(Map.of("min", 0, "max", 62));
    Shuffleboard.getTab("Tab 1").add("Left Front", LeftDist.getValue()).withWidget(BuiltInWidgets.kDial).withProperties(Map.of("min", 0, "max", 62));
    Shuffleboard.getTab("Tab 1").add("Right Rear", RightDist.getValue()).withWidget(BuiltInWidgets.kDial).withProperties(Map.of("min", 0, "max", 62));

    //encoders to shuffleboard
    Shuffleboard.getTab("Tab 1").add("Encoder FL", EncFl.get()).withWidget(BuiltInWidgets.kEncoder).withProperties(Map.of("min", 0, "max", 360));
    Shuffleboard.getTab("Tab 1").add("Encoder FR", EncFr.get()).withWidget(BuiltInWidgets.kEncoder).withProperties(Map.of("min", 0, "max", 360));
    Shuffleboard.getTab("Tab 1").add("Encoder BL", EncBl.get()).withWidget(BuiltInWidgets.kEncoder).withProperties(Map.of("min", 0, "max", 360));
    Shuffleboard.getTab("Tab 1").add("Encoder BR", EncBr.get()).withWidget(BuiltInWidgets.kEncoder).withProperties(Map.of("min", 0, "max", 360));

    //Gyro to shuffleboard
    Shuffleboard.getTab("Tab 1").add("Gyro Angle", Gyro.getAngle()).withWidget(BuiltInWidgets.kGyro);

    //limit switches to shuffleboard
    Shuffleboard.getTab("Tab 1").add("Top Limit", LimitTop.get()).withWidget(BuiltInWidgets.kTextView);
    Shuffleboard.getTab("Tab 1").add("Base Limit", LimitBase.get()).withWidget(BuiltInWidgets.kTextView);

    //Cameras to shuffleboard
    Shuffleboard.getTab("Tab 1").add("Front Camera", CameraServer.getInstance().getVideo()).withWidget(BuiltInWidgets.kCameraStream);
    
    //Line Tracker to Shuffleboard
    Shuffleboard.getTab("Tab 1").add("Tape Read", TapeRead.get()).withWidget(BuiltInWidgets.kTextView);

    //Alignment Notification
      Shuffleboard.getTab("Tab 1").add("Alignment",RobotMap.isAligned).withWidget(BuiltInWidgets.kBooleanBox);
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
  }

  @Override
  protected void interrupted() {
  }
}
