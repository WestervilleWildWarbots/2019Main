package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Logger;

public class PositionAdjustCommandGroup extends Command {
  public PositionAdjustCommandGroup() {
    Logger.Log("Position adjustment constructed.");
  }

  @Override
  protected void initialize() {
    Logger.Log("Position adjustment initialized.");
  }

  @Override
  protected void execute() {
    Logger.Log("Position adjustment executed.");
  }

  @Override
  protected boolean isFinished() {
    Logger.Log("Position adjustment finished.");
    return false;
  }

  @Override
  protected void end() {
    Logger.Log("Position adjustment ended.");
  }

  @Override
  protected void interrupted() {
    Logger.Log("Position adjustment interrupted.");
  }
}
