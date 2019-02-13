package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.subsystems.ClimbSubsystem;

public class ClimbCommand extends Command {
  private ClimbSubsystem climb = Robot.climbSubsystem();
  public static int climbTime = 0;
  private boolean climbDone = false;
  public ClimbCommand() {
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    if(climbTime < 3001){
    climb.climbVert("up");
    climb.climbOut("out");
    }else if(climbTime < 5001){
      climb.climbOut("in");
    }else if (climbTime < 8001){
      climb.climbVert("down");
    }else{
      climb.climbVert("off");
      climb.climbOut("off");
      climbDone = true;
    }
    climbTime++;
  }

  @Override
  protected boolean isFinished() {
    return climbDone;
  }

  @Override
  protected void end() {
    climb.climbVert("off");
    climb.climbOut("off");
  }

  @Override
  protected void interrupted() {
    climb.climbVert("off");
    climb.climbOut("off");
  }
}
