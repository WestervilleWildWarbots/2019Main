package frc.robot.commands;

import frc.robot.Logger;
import frc.robot.Robot;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.GrabSubsystem;

public class ExtendCommand extends Command {
    public GrabSubsystem grab = Robot.grabSubsystem;
    private String extendir = "out";
    private String Direction;
  public ExtendCommand(String Direction) {
    extendir=this.Direction;
    Logger.Log("Extend constructed.");
  }

  @Override
  protected void initialize() {
    Logger.Log("Extend initialized.");
  }

  @Override
  protected void execute() {
    if(extendir=="out"){
      RobotMap.extendDone = false;
      grab.extend();
    }else{RobotMap.extendDone = true;}
    Logger.Log("Extend executed.");
  }

 

  @Override
  protected boolean isFinished() {
    Logger.Log("Extend finished.");
    return RobotMap.extendDone;
  }

  @Override
  protected void end() {
    grab.extendOff();
    Logger.Log("Extend ended.");
  }

  @Override
  protected void interrupted() {
    grab.extendOff();
    Logger.Log("Extend interrupted.");
  }
}