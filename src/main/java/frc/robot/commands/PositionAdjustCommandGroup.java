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
    return false;
  }

  @Override
  protected void end() {
  }

  @Override
  protected void interrupted() {
  }
}
