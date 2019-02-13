package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.command.Command;

public class SuicideCommand extends Command {
    private DriveSubsystem  driveSub = Robot.driveSubsystem;
    public GrabSubsystem grab = Robot.grabSubsystem;

  public SuicideCommand() {
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
      driveSub.drive(0,0);
      grab.grabOff();
      grab.extendOff();
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