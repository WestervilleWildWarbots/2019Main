package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.*;

public class DriveCommand extends Command {
  private DriveSubsystem drive = Robot.driveSubsystem;

  public DriveCommand() {
    Logger.Log("Drive constructed.");
  }

  @Override
  protected void initialize() {
    Logger.Log("Drive initialized.");
  }

  @Override
  protected void execute() {
    double left = 0;
    double right = 0;

    double yVal = OI.getJoystickAxis(RobotMap.DRIVE_STICK, OI.Axis.Y); 
    double zVal = OI.getJoystickAxis(RobotMap.DRIVE_STICK, OI.Axis.Z); 

   
    if(zVal < 0){zVal = -1;}
    if(zVal > 0){zVal = 1;}

    left = yVal/4;
    if(zVal !=0){
      left*=zVal;
    
      if(yVal != 0){left +=yVal/2;}else{left +=zVal/2;}
    }
    
    right = yVal/4;
    if(zVal !=0){
      right*=-zVal;
      if(yVal != 0){right +=yVal/2;}else{right +=zVal/2;}
    }

    drive.drive(left, right);
    Logger.Log("Drive executed.");
  }

  @Override
  protected boolean isFinished() {
    Logger.Log("Drive finished.");
    return false;
  }

  @Override
  protected void end() {
    drive.drive(0,0);
    Logger.Log("Drive ended.");
  }

  @Override
  protected void interrupted() {
    drive.drive(0,0);
    Logger.Log("Drive interrupted.");
  }
}
