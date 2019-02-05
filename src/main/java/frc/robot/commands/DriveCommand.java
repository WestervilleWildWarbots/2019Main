package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.*;

public class DriveCommand extends Command {
  private DriveSubsystem drive = Robot.driveSubsystem;

  public DriveCommand() {
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    //if(OI.getJoystickAxis(RobotMap.DRIVE_STICK, Axis.Y){
      drive.drive(.2,.2);
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
    drive.drive(0,0);
  }

  @Override
  protected void interrupted() {
    drive.drive(0,0);
  }
}
