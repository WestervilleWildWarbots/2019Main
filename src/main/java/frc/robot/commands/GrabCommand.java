package frc.robot.commands;

import frc.robot.Logger;
import frc.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.GrabSubsystem;

public class GrabCommand extends Command {
  private GrabSubsystem grab = Robot.grabSubsystem;
  public GrabCommand() {
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    Logger.Log("GrabCommand Executed");
    grab.grab(false);
    grab.extend(false);
  
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
    grab.grab(true);
    grab.extend(true);
  
  }

  @Override
  protected void interrupted() {
    grab.grab(true);
    grab.extend(true);

  }
}
