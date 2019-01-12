package frc.robot.commands;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Command;

public class MonitorCommand extends Command {

  private NetworkTableInstance table;
  
  public MonitorCommand() {
	table = NetworkTableInstance.getDefault();
  }

  @Override
  protected void initialize() {
	  table = NetworkTableInstance.getDefault();
  }

  @Override
  protected void execute() {
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
