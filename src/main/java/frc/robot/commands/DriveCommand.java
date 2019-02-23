package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI.Axis;
import frc.robot.Logger;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class DriveCommand extends Command {
  //private DriveSubsystem drive = Robot.driveSubsystem;

  public DriveCommand() {
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    Logger.Log("DriveCommand Executed");
    double y = Robot.oi.getJoystickAxis(RobotMap.DRIVE_STICK, Axis.Y);
    double z = Robot.oi.getJoystickAxis(RobotMap.DRIVE_STICK, Axis.Z);
    if (z < 0) {
      z = -z*z;
    } else {
      z = z*z;
    }
    double throttle = ((Robot.oi.getJoystickAxis(RobotMap.DRIVE_STICK, Axis.THROTTLE) + 1))/2;

    double leftSpeed = (y-z)*throttle;
    double rightSpeed= (y+z)*throttle;

    Robot.driveSubsystem.drive(leftSpeed, rightSpeed);
    
    Robot.liftSubsystem.moveArm(-Robot.oi.getJoystickAxis(RobotMap.XBOX_CONTROLLER, Axis.LeftY));

  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
    Robot.driveSubsystem.drive(0,0);
  }

  @Override
  protected void interrupted() {
    Robot.driveSubsystem.drive(0,0);
  }
}
