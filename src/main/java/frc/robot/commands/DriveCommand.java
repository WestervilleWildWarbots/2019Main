package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.Robot;

public class DriveCommand extends Command {
  private DriveSubsystem drive = Robot.driveSubsystem;

  public DriveCommand() {
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    drive.drive(.3);
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
    drive.drive(0);
  }

  @Override
  protected void interrupted() {
    drive.drive(0);
  }
}
