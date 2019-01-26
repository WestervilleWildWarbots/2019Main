/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.Map;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import frc.robot.RobotMap;

public class MonitorCommand extends Command {

  AnalogInput distf = new AnalogInput(RobotMap.REAR_DISTANCE_SENSOR);
  AnalogInput distr = new AnalogInput(RobotMap.FRONT_DISTANCE_SENSOR);

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
    Shuffleboard.getTab("Tab 1").add("Dist 1", distf.getValue()).withWidget(BuiltInWidgets.kDial).withProperties(Map.of("min", 0, "max", 62));
    Shuffleboard.getTab("Tab 1").add("Dist 2", distr.getValue()).withWidget(BuiltInWidgets.kDial).withProperties(Map.of("min", 0, "max", 62));
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
