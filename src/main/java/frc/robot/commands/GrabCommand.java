package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.OI;
import java.awt.Button;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.GrabSubsystem;

public class GrabCommand extends Command {
  public GrabSubsystem grab = Robot.grabSubsystem;
  public GrabCommand() {
  }

  @Override
  protected void initialize() {
    RobotMap.grabDone = false;
  }

  @Override
  protected void execute() {
    grab.grab();
  }

 

  @Override
  protected boolean isFinished() {
    return RobotMap.grabDone;
  }

  @Override
  protected void end() {
    grab.grabOff();
    grab.extendOff();
  
  }

  @Override
  protected void interrupted() {
    grab.grabOff();
    grab.extendOff();

  }
}
