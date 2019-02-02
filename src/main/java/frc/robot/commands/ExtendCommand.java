package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.OI;
import java.awt.Button;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.GrabSubsystem;

public class ExtendCommand extends Command {
    public GrabSubsystem grab = Robot.grabSubsystem;
  public ExtendCommand() {
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    grab.extend();
  }

 

  @Override
  protected boolean isFinished() {
    return false;
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