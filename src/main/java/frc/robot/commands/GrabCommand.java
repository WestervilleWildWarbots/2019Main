package frc.robot.commands;

import frc.robot.Logger;
import frc.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.*;

public class GrabCommand extends Command {

  public GrabCommand() {
    requires(Robot.grabSubsystem);
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    Robot.grabSubsystem.openGrab();
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
