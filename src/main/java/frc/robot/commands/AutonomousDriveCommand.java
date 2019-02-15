package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Logger;
import frc.robot.Robot;
import frc.robot.subsystems.DriveSubsystem;

public class AutonomousDriveCommand extends Command {
  private long x = 2500;
  private boolean isDone = false;
  private int amount;
  private DriveSubsystem driveSubsystem = Robot.driveSubsystem;
  
  public AutonomousDriveCommand(int ticks) {
    amount = ticks;
    x = System.currentTimeMillis();
    Logger.Log("Autonomous drive constructed.");
  }

  @Override
  protected void initialize() {
    x = System.currentTimeMillis();
    Logger.Log("Autonomous drive initialized.");
  }

  @Override
  protected void execute() {
    if(x + amount > System.currentTimeMillis()) {
      driveSubsystem.drive(.2,.2);
    } else {
      isDone = true;
    }
    Logger.Log("Autonomous drive executed.");
  }

  @Override
  protected boolean isFinished() {
    Logger.Log("Autonomous drive finished.");
    return isDone;
  }

  @Override
  protected void end() {
    x = 0;
    driveSubsystem.drive(0,0);
    Logger.Log("Autonomous drive ended.");
  }

  @Override
  protected void interrupted() {
    driveSubsystem.drive(0,0);
    Logger.Log("Autonomous drive interupted.");
  }
}
