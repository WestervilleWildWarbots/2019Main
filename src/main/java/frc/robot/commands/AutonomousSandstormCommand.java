package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.DriveSubsystem;

/**
 * This class provides a Command that handles all autonomous (Sandstorm) scenarios.
 */

public class AutonomousSandstormCommand extends Command {
  private DriveSubsystem driveSubsystem;

  public enum StartLocation {
    leftTier1, rightTier1, middleTier1, leftTier2, rightTier2
  }

  public enum Task {
    cargo, rocket, crossline
  }

  public AutonomousSandstormCommand(StartLocation startLocation, Task task){
    switch(startLocation){
      case leftTier1:
      //TODO fix speed
      driveSubsystem.drive(.5);
      break;
      case rightTier1:
      break;
      case middleTier1:
      case leftTier2:
      case rightTier2:
    }
    
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
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
