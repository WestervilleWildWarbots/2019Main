package frc.robot.commands;

import frc.robot.Logger;
import frc.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.GrabSubsystem;

public class GrabCommand extends Command {
  private GrabSubsystem grab = Robot.grabSubsystem;

  String dirr;

  public GrabCommand(String dirr) {
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    Logger.Log("GrabCommand Executed");
    grab.grab(dirr);
    grab.extend(false);
  }

  @Override
  protected boolean isFinished() {
    Logger.Log("Grab Command Finished");
    return false;
  }

  @Override
  protected void end() {
    Logger.Log("Grab Command End");
    grab.grab("off");
    grab.extend(true);
  }

  @Override
  protected void interrupted() {
    Logger.Log("Grab Command INTERRUPTED");
    grab.grab("off");
    grab.extend(true);

  }
}
