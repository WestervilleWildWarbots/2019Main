package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI.Axis;
import frc.robot.Logger;
import frc.robot.OI;
import frc.robot.RobotMap;
import frc.robot.subsystems.DriveSubsystem;

public class DriveCommand extends Command {
  private DriveSubsystem drivesys;
  private final double speedScale = 1.0;
  public DriveCommand() {
    if(drivesys == null){
      drivesys = new DriveSubsystem();
    }
  }
  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    Logger.Log("DriveCommand Executed");
    double z = OI.driveStick.getZ();
	    double y = OI.driveStick.getY();
	    z *= Math.abs(z);
	    Double leftPower = (y - z)* -speedScale;
	    Double rightPower = (y + z)* speedScale;

      drivesys.drive(leftPower, rightPower);
  }
    
//    Robot.liftSubsystem.moveArm(-OI.getJoystickAxis(RobotMap.XBOX_CONTROLLER, Axis.LeftY));
  @Override
  protected boolean isFinished() {
    Logger.Log("DriveCommand Finished");
    return false;
  }

  @Override
  protected void end() {
    Logger.Log("DriveCommand Ended");
    drivesys.drive(0,0);
  }

  @Override
  protected void interrupted() {
    Logger.Log("DriveCommand INTERRUPTED");
    drivesys.drive(0,0);
  }
}