package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI.Axis;
import frc.robot.Logger;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.subsystems.DriveSubsystem;

public class DriveCommand extends Command {
  public final double speedScale = 1.0;
  private final double deadzone = 0.07;

  public DriveCommand() {

    }

  // public DriveCommand(boolean driveDisabled) {
  //   RobotMap.Drivebool = false;
  // }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {

    double speedScale = 1.0;

    if(RobotMap.SAFETY_MODE){
       speedScale = 0.4;
    }

    // if (RobotMap.Drivebool) {
      double z = -1 * OI.driveStick.getY();
	      double y = -0.6* OI.driveStick.getZ();
	     z *= Math.abs(z);
	     Double leftPower = (y - z)* -speedScale;
	     Double rightPower = (y + z)* speedScale;

        Robot.driveSubsystem.drive(leftPower, rightPower);
    //}
  }
    
  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
    Robot.driveSubsystem.drive(0,0);
  }

  @Override
  protected void interrupted() {
    Robot.driveSubsystem.drive(0,0);
  }
}