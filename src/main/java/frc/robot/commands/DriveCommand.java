package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI.Axis;
import frc.robot.Logger;
import frc.robot.OI;
import frc.robot.RobotMap;
import frc.robot.subsystems.DriveSubsystem;

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
    double y = OI.getJoystickAxis(RobotMap.DRIVE_STICK, Axis.Y);
    double z = OI.getJoystickAxis(RobotMap.DRIVE_STICK, Axis.Z);
    if (z < 0) {
      z = -z*z;
    } else {
      z = z*z;
    }
    double throttle = ((OI.getJoystickAxis(RobotMap.DRIVE_STICK, Axis.THROTTLE) + 1))/2;

    double leftSpeed = (y-z)*throttle;
    double rightSpeed= (y+z)*throttle;

    DriveSubsystem.drive(leftSpeed, rightSpeed);
    
//    Robot.liftSubsystem.moveArm(-OI.getJoystickAxis(RobotMap.XBOX_CONTROLLER, Axis.LeftY));

  }

  @Override
  protected boolean isFinished() {
    Logger.Log("DriveCommand Finished");
    return false;
  }

  @Override
  protected void end() {
    Logger.Log("DriveCommand Ended");
   DriveSubsystem.drive(0,0);
  }

  @Override
  protected void interrupted() {
    Logger.Log("DriveCommand INTERRUPTED");
    DriveSubsystem.drive(0,0);
  }
}
