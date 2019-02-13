package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.subsystems.ClimbSubsystem;

public class ClimbCommand extends Command {
  private ClimbSubsystem climb = Robot.climbSubsystem();
  public ClimbCommand() {
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    climb.climbVert("up");
    climb.climbOut("out");
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
  }

  @Override
  protected void interrupted() {
  }
}
