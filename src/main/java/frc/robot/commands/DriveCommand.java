/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.OI.Axis;

public class DriveCommand extends Command {
  public DriveCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    //Defining the left/right motors to arbitrary numbers
    double left = 0;
    double right = 0;
    
    // Controlling the Robot with a single joystick
    double z = OI.getJoystickAxis(RobotMap.DRIVE_STICK, Axis.Z)*.6;
    double y = OI.getJoystickAxis(RobotMap.DRIVE_STICK, Axis.Y);
    z *= Math.abs(z);
    z *= -(OI.getJoystickAxis(RobotMap.DRIVE_STICK, Axis.THROTTLE) + 1) / 2;
    y *= -(OI.getJoystickAxis(RobotMap.DRIVE_STICK, Axis.THROTTLE) + 1) / 2;
    left = y - z;
    right = y + z;
    //Uses the previously defined variables to have to robot drive using the left and right side motors
    Robot.driveSubsystem.drive(left, right);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.driveSubsystem.drive(0, 0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.driveSubsystem.drive(0, 0);
  }
}
