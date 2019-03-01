package frc.robot.commands;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import frc.robot.Logger;
import frc.robot.RobotMap;
import frc.robot.subsystems.*;

import edu.wpi.first.networktables.NetworkTableInstance;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class MonitorCommand extends Command {
  private NetworkTableInstance table;

  DigitalInput TapeRead = new DigitalInput(RobotMap.LINE_TRACKER);
  
  public static double DEFAULT_VALUE=0;

  public MonitorCommand() {
    ShuffleboardTab tab1 = Shuffleboard.getTab("Tab 1");
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
        Logger.Log("monitoring");
        //Encoders to SmartDashboard
        table.getEntry("encoder_valueLift").setValue(LiftSubsystem.getLiftEnc());
        SmartDashboard.putNumber("Lift Encoder", LiftSubsystem.getLiftEnc());

        table.getEntry("encoder_valueLeft").setValue(DriveSubsystem.getLeftEnc());
        SmartDashboard.putNumber("Lift Encoder", DriveSubsystem.getLeftEnc());

        table.getEntry("encoder_valueRight").setValue(DriveSubsystem.getRightEnc());
        SmartDashboard.putNumber("Lift Encoder", DriveSubsystem.getRightEnc());

        //Distance Sensors to SmartDashboard

        table.getEntry("distFront").setValue(DriveSubsystem.getFrontDist());
        SmartDashboard.putNumber("Front Distance", DriveSubsystem.getFrontDist());

        table.getEntry("distRear").setValue(DriveSubsystem.getRearDist());
        SmartDashboard.putNumber("Rear Distance", DriveSubsystem.getRearDist());

        table.getEntry("distLeft").setValue(DriveSubsystem.getLeftDist());
        SmartDashboard.putNumber("Port Distance", DriveSubsystem.getLeftDist());

        table.getEntry("distRight").setValue(DriveSubsystem.getRightDist());
        SmartDashboard.putNumber("Starboard Distance", DriveSubsystem.getRightDist());

        //Limit Switches to SmartDashboard
        table.getEntry("limitBase").setValue(LiftSubsystem.getBaseLimit());
        SmartDashboard.putBoolean("Base Limit", LiftSubsystem.getBaseLimit());

        table.getEntry("limitTop").setValue(LiftSubsystem.getTopLimit());
        SmartDashboard.putBoolean("Top Limit", LiftSubsystem.getTopLimit());

        //Gyro to SmartDashboard
        table.getEntry("gyroAngle").setValue(DriveSubsystem.getGyro());
        SmartDashboard.putNumber("Gyro Angle", DriveSubsystem.getGyro());
  }
  @Override
  protected boolean isFinished() {
    Logger.Log("Monitor Command Finished");
    return false;
  }
  
  @Override
  protected void end() {
    Logger.Log("Monitor Command Ended");
  }
  
  @Override
  protected void interrupted() {
    Logger.Log("Monitor Command INTERRUPTED");
  }
}