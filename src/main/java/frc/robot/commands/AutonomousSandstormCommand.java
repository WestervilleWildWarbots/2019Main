package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
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
  }

  @Override
  protected void initialize() {
    this.driveSubsystem = Robot.driveSubsystem;
  }

  @Override
  protected void execute() {
     switch(task){
      case crossline:
        switch(startLocation){
          case leftTier1:
          //TODO fix speed
          driveSubsystem.drive(.5, 0.5);
          break;
          case rightTier1:
          driveSubsystem.drive(.5, 0.5);
          break;
          case middleTier1:
          driveSubsystem.drive(.5, 0.5);
          break;
          case leftTier2:
          driveSubsystem.drive(.5, 0.5);
          break;
          case rightTier2:
          driveSubsystem.drive(.5, 0.5);
          break;
          default:
          System.out.println("That's not a starting location!");
        }
      break;
      case rocket:
      //TODO implement
      break;
      case cargo:
      //TODO implement
      break;
      default:
      System.out.println("That's not a task!");
    }
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
  }

  @Override
  protected void interrupted() {
  }
}
