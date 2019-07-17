package frc.robot.commands;

import frc.robot.Logger;
import frc.robot.Robot;
import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.*;

public class SafeCommand extends Command {

  public SafeCommand() {

  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    RobotMap.SAFETY_MODE = !RobotMap.SAFETY_MODE;
  }

  @Override
  protected boolean isFinished() {
    return true;
  }

  @Override
  protected void end() {
  }

  @Override
  protected void interrupted() {
  }
}
