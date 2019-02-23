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

  DigitalInput  EncL = new DigitalInput(RobotMap.ENCODER_L);
  DigitalInput  EncR = new DigitalInput(RobotMap.ENCODER_R);

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
        table.getEntry("encoder_valueLift").setValue(EncLift.get());
        SmartDashboard.getEntry("encoder_valueLift").getDouble(DEFAULT_VALUE);
    
    Shuffleboard.getTab("Tab 1").add("Encoder Lift", EncLift.get()).withWidget(BuiltInWidgets.kEncoder).withProperties(Map.of("min", 0, "max", 360));
  }
  //anus
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