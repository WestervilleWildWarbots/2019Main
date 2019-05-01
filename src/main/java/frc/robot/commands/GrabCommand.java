package frc.robot.commands;

import frc.robot.Logger;
import frc.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.*;

public class GrabCommand extends Command {
  public GrabSubsystem solsys = Robot.grabSubsystem;

  public GrabCommand(boolean isopen) {
    
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
  }

  @Override
  protected boolean isFinished() {
    Logger.Log("Grab Command Finished");
    return false;
  }

  @Override
  protected void end() {
    Logger.Log("Grab Command End");
  }

  @Override
  protected void interrupted() {
    Logger.Log("Grab Command INTERRUPTED");

  }
}
