/*package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Logger;
import java.lang.System;
import frc.robot.subsystems.DriveSubsystem;

public class AutonomousDriveCommand extends Command {
  private long x = 2500; // How long to move for
  private boolean isDone = false; // After the time has passed
  private int amount; // The starting amount of time
  private DriveSubsystem drivesys;
  
  public AutonomousDriveCommand(int ticks) {
    amount = ticks;
    x = System.currentTimeMillis();
  }

  @Override
  protected void initialize() {
    x = System.currentTimeMillis();
  }

  @Override
  protected void execute() {
    Logger.Log("AutonomousDriveCommand Executed");
    if(x + amount > System.currentTimeMillis()) {
      drivesys.drive(.3,.3);
    } else {
      isDone = true;
    }
  }

  @Override
  protected boolean isFinished() {
    Logger.Log("AutonomousDriveCommand Finished");
    return isDone;
  }

  @Override
  protected void end() {
    Logger.Log("AutonomousDriveCommand Ended");
    x = 0;
    drivesys.drive(0,0);
  }

  @Override
  protected void interrupted() {
    Logger.Log("AutonomousDriveCommand INTERRUPTED");
    drivesys.drive(0,0);
  }
}*/
