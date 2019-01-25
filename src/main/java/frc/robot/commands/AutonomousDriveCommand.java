package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class AutonomousDriveCommand extends Command {
  private long x = 2500; // How long to move for
	private boolean isDone = false; // After the time has passed
	private int amount; // The starting amount of time
  
  public AutonomousDriveCommand(int ticks) {
    amount = ticks;
      x = System.currentTimeMillis();
  }

 @Override
  protected void initialize() {
    x = System.currentTimeMillis();
  }

  @Override
  protected void execute() {
    if(x + amount > System.currentTimeMillis()) {
      Robot.d_subsystem.drive(.3, .3);
    } else {
      isDone = true;
    }
  }

  @Override
  protected boolean isFinished() {
    return isDone;
  }

   @Override
  protected void end() {
    x = 0;
    	Robot.d_subsystem.drive(0, 0);
  }

  @Override
  protected void interrupted() {
    Robot.d_subsystem.drive(0, 0);
  }
}
