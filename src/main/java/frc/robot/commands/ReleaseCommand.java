package frc.robot.commands;

import frc.robot.Logger;
import frc.robot.Robot;
import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.GrabSubsystem;

public class ReleaseCommand extends Command {
    public GrabSubsystem grab = Robot.grabSubsystem;
  public ReleaseCommand() {
    Logger.Log("Release constructed.");
  }

  @Override
  protected void initialize() {
    Logger.Log("Release initialized.");
  }

  @Override
  protected void execute() {
    grab.release();
    Logger.Log("Release executed.");
  }

 

  @Override
  protected boolean isFinished() {
    Logger.Log("Release finished.");
    return RobotMap.releaseDone;
  }

  @Override
  protected void end() {
    grab.grabOff();
    Logger.Log("Release ended.");
  
  }

  @Override
  protected void interrupted() {
    grab.grabOff();
    Logger.Log("Release interrupted.");
  }
}