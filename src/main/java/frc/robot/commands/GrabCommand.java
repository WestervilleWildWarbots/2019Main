package frc.robot.commands;

import frc.robot.Logger;
import frc.robot.Robot;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.GrabSubsystem;

public class GrabCommand extends Command {
  public GrabSubsystem grab = Robot.grabSubsystem;
  public GrabCommand() {
    Logger.Log("Grab constructed.");
  }

  @Override
  protected void initialize() {
    RobotMap.grabDone = false;
    Logger.Log("Grab initialized.");
  }

  @Override
  protected void execute() {
    grab.grab();
    Logger.Log("Grab executed.");
  }

 

  @Override
  protected boolean isFinished() {
    Logger.Log("Grab finished.");
    return RobotMap.grabDone;
  }

  @Override
  protected void end() {
    grab.grabOff();
    grab.extendOff();
    Logger.Log("Grab ended.");
  }

  @Override
  protected void interrupted() {
    grab.grabOff();
    grab.extendOff();
    Logger.Log("Grab interrupted.");
  }
}
