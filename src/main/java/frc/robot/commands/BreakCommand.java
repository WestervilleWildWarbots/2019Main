package frc.robot.commands;

import frc.robot.Logger;
import frc.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.*;

public class BreakCommand extends Command {

  public BreakCommand() {
    requires(Robot.grabSubsystem);
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    Robot.grabSubsystem.Break();
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
