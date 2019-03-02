package frc.robot.commands;

import frc.robot.Logger;
import frc.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.GrabSubsystem;

public class GrabCommand extends Command {
  private GrabSubsystem grabsys = Robot.grabSubsystem;

  String dirr;

  public GrabCommand(String dirr) {
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    Logger.Log("GrabCommand Executed");
    grabsys.grab(dirr);
    grabsys.extend(false);
  }

  @Override
  protected boolean isFinished() {
    Logger.Log("Grab Command Finished");
    return false;
  }

  @Override
  protected void end() {
    Logger.Log("Grab Command End");
    grabsys.grab("off");
    grabsys.extend(true);
  }

  @Override
  protected void interrupted() {
    Logger.Log("Grab Command INTERRUPTED");
    grabsys.grab("off");
    grabsys.extend(true);

  }
}
