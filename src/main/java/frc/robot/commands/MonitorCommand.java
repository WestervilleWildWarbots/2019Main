/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.Map;
import java.util.Random;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import frc.robot.RobotMap;
import edu.wpi.first.cameraserver.*;

public class MonitorCommand extends Command {

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
  public MonitorCommand() {
    ShuffleboardTab tab1 = Shuffleboard.getTab("Tab 1");
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    //Shuffleboard.getTab("Tab 1").add("Camera 1", 14).withWidget(BuiltInWidgets.kCameraStream).withProperties(Map.of("min", 0, "max", 62));

    //distance sensors to shuffleboard
    Shuffleboard.getTab("Tab 1").add("Dist Front", FrontDist.getValue()).withWidget(BuiltInWidgets.kDial).withProperties(Map.of("min", 0, "max", 62));
    Shuffleboard.getTab("Tab 1").add("Dist Rear", RearDist.getValue()).withWidget(BuiltInWidgets.kDial).withProperties(Map.of("min", 0, "max", 62));
    Shuffleboard.getTab("Tab 1").add("Left Front", LeftDist.getValue()).withWidget(BuiltInWidgets.kDial).withProperties(Map.of("min", 0, "max", 62));
    Shuffleboard.getTab("Tab 1").add("Right Rear", RightDist.getValue()).withWidget(BuiltInWidgets.kDial).withProperties(Map.of("min", 0, "max", 62));

    //encoders to shuffleboard
    Shuffleboard.getTab("Tab 1").add("Encoder FL", EncFl.get()).withWidget(BuiltInWidgets.kDial).withProperties(Map.of("min", 0, "max", 360));
    Shuffleboard.getTab("Tab 1").add("Encoder FR", EncFr.get()).withWidget(BuiltInWidgets.kDial).withProperties(Map.of("min", 0, "max", 360));
    Shuffleboard.getTab("Tab 1").add("Encoder BL", EncBl.get()).withWidget(BuiltInWidgets.kDial).withProperties(Map.of("min", 0, "max", 360));
    Shuffleboard.getTab("Tab 1").add("Encoder BR", EncBr.get()).withWidget(BuiltInWidgets.kDial).withProperties(Map.of("min", 0, "max", 360));

    //gyro to shuffleboard
    Shuffleboard.getTab("Tab 1").add("Gyro Angle", Gyro.getAngle()).withWidget(BuiltInWidgets.kDial).withProperties(Map.of("min", 0, "max", 360));

    //limit switches to shuffleboard
    Shuffleboard.getTab("Tab 1").add("Top Limit", LimitTop.get()).withWidget(BuiltInWidgets.kDial).withProperties(Map.of("min", 0, "max", 1));
    Shuffleboard.getTab("Tab 1").add("Base Limit", LimitBase.get()).withWidget(BuiltInWidgets.kDial).withProperties(Map.of("min", 0, "max", 1));

    //Cameras to shuffleboard
    Shuffleboard.getTab("Tab 1").add("Front Camera", CameraServer.getInstance().getVideo()).withWidget(BuiltInWidgets.kDial).withProperties(Map.of("min", 0, "max", 256));

    //Line Tracker to Shuffleboard
    Shuffleboard.getTab("Tab 1").add("Tape Read", TapeRead.get()).withWidget(BuiltInWidgets.kDial).withProperties(Map.of("min", 0, "max", 1));

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
