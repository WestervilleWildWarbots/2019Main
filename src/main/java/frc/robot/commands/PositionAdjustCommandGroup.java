package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Logger;

public class PositionAdjustCommandGroup extends Command {
  public PositionAdjustCommandGroup() {
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    Logger.Log("PositionAdjustCommandGroup Executed");
  }

  @Override
  protected boolean isFinished() {
    Logger.Log("PositionAdjustCommandGroup Finished");
    return false;
  }

  @Override
  protected void end() {
    Logger.Log("PositionAdjustCommandGroup Ended");
  }

  @Override
  protected void interrupted() {
    Logger.Log("PositionAdjustCommandGroup Interrupted");
  }
}
