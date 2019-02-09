package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.subsystems.DriveSubsystem;

public class AutonomousDriveCommand extends Command {
  private long x = 10000;
  private boolean isDone = false;
  private int amount;
  private DriveSubsystem driveSubsystem = Robot.driveSubsystem;
  
  public AutonomousDriveCommand(int ticks) {
    amount = ticks;
  }

  @Override
  protected void initialize() {
 
  }

  @Override
  protected void execute() {
    RobotMap.isAligned = false;
    if(x + amount > System.currentTimeMillis()) {
      driveSubsystem.drive(.2,.2);
    } else {
      isDone = true;
    }
  }

  @Override
  protected boolean isFinished() {
    return isDone;
  }

  @Override
  protected void end() {
    RobotMap.isAligned = true;
    driveSubsystem.drive(0,0);
  }

  @Override
  protected void interrupted() {
    RobotMap.isAligned = true;
    driveSubsystem.drive(0,0);
  }
}
