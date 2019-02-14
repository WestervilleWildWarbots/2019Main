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
    Logger.Log("Climb INIT");
  }

  @Override
  protected void execute() {
    Logger.Log("Climb EXECUTING");

    if(climbTime < 3001){
    Logger.Log("Climb Phase 1 INITIATED");
    climb.climbVert("up");
    climb.climbOut("out");
    }else if(climbTime < 5001){
      Logger.Log("Climb Phase 2 INITIATED");
      climb.climbOut("in");
    }else if (climbTime < 8001){
      Logger.Log("Climb Phase 3 INITIATED");
      climb.climbVert("down");
    }else{
      Logger.Log("Climb OFF");
      climb.climbVert("off");
      climb.climbOut("off");
      climbDone = true;
    }
    climbTime++;
  }

  @Override
  protected boolean isFinished() {
    Logger.Log("Climb FINISHED");
    return climbDone;
  }

  @Override
  protected void end() {
    Logger.Log("Climb END");
    climb.climbVert("off");
    climb.climbOut("off");
  }

  @Override
  protected void interrupted() {
    Logger.Log("Climb INTERRUPT");
    climb.climbVert("off");
    climb.climbOut("off");
  }
}
