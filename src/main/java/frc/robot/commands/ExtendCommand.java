package frc.robot.commands;

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
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    if(extendir=="out"){
    RobotMap.extendDone = false;
    grab.extend();
  }else{RobotMap.extendDone = true;}
  }

 

  @Override
  protected boolean isFinished() {
    return RobotMap.extendDone;
  }

  @Override
  protected void end() {
    grab.extendOff();
  
  }

  @Override
  protected void interrupted() {
    grab.extendOff();
  }
}