package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Logger;
import frc.robot.Robot;
import frc.robot.subsystems.DriveSubsystem;

/**
 * This class provides a Command that handles all autonomous (Sandstorm) scenarios.
 */

public class AutonomousSandstormCommand extends Command {
  private DriveSubsystem driveSubsystem;
  private StartLocation startLocation;
  private Task task;

  public enum StartLocation {
    leftTier1, rightTier1, middleTier1, leftTier2, rightTier2
  }

  public enum Task {
    cargo, rocket, crossline
  }

  public AutonomousSandstormCommand(StartLocation startLocation, Task task){
    this.startLocation = startLocation;
    this.task = task;
    Logger.Log("Autonomous sandstorm cunstructed.");
  }

  @Override
  protected void initialize() {
    this.driveSubsystem = Robot.driveSubsystem;
    Logger.Log("Autonomous sandstorm initialized.");
  }

  @Override
  protected void execute() {
     switch(task){
      case crossline:
        switch(startLocation){
          case leftTier1:

          driveSubsystem.drive(0.5, 0.5);
          break;
          case rightTier1:
          driveSubsystem.drive(0.5, 0.5);
          break;
          case middleTier1:
          driveSubsystem.drive(0.5, 0.5);
          break;
          case leftTier2:
          driveSubsystem.drive(0.5, 0.5);
          break;
          case rightTier2:
          driveSubsystem.drive(0.5, 0.5);
          break;
          default:
          System.out.println("That's not a starting location!");
        }
      break;
      case rocket:
      break;
      case cargo:
      break;
      default:
      System.out.println("That's not a task!");
      Logger.Log("Autonomous sandstorm executed.");
    }
  }

  @Override
  protected boolean isFinished() {
    Logger.Log("Autonomous sandstorm finished.");
    return false;
  }

  @Override
  protected void end() {
    Logger.Log("Autonomous sandstorm ended.");
  }

  @Override
  protected void interrupted() {
    Logger.Log("Autonomous sandstorm interupted.");
  }
}
