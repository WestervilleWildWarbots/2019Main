package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Logger;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.AutoDrivable;
import frc.robot.subsystems.DriveSubsystem;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
/*
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.PathfinderFRC;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.followers.EncoderFollower;
*/
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

/**
 * This class provides a Command that handles all autonomous (Sandstorm) scenarios.
 */

public class AutonomousSandstormCommand extends Command {
  private StartLocation startLocation;
  private Task task;

  private WPI_TalonSRX leftMotor;
  private WPI_TalonSRX rightMotor;

  /*
  //for Pathfinder library
  private static final String path = "test";

  private EncoderFollower leftFollower;
  private EncoderFollower rightFollower;

  private Encoder leftEncoder;
  private Encoder rightEncoder;

  private AnalogGyro gyro;

  private Trajectory leftTrajectory;
  private Trajectory rightTrajectory;
  */

  //for manually coded autonomous
  private AutoDrivable drive;

  public enum StartLocation {
    leftTier1, rightTier1, middleTier1, leftTier2, rightTier2
  }

  public enum Task {
    cargo, rocket, crossline
  }

  public AutonomousSandstormCommand(StartLocation startLocation, Task task){
    this.startLocation = startLocation;
    this.task = task;
    Logger.Log("Autonomous sandstorm cunstructed.");
  }

  @Override
  protected void initialize() {
    drive = new DriveSubsystem();
    
    Logger.Log("Autonomous sandstorm initialized.");
  }

  /*
  private void followPath(){
      double leftSpeed = leftFollower.calculate(leftEncoder.get());
      double rightSpeed = rightFollower.calculate(rightEncoder.get());
      double heading = gyro.getAngle();
      double desiredHeading = Pathfinder.r2d(leftFollower.getHeading());
      double headingDifference = Pathfinder.boundHalfDegrees(desiredHeading - heading);
      double turn =  0.8 * (-1.0/80.0) * headingDifference;
      leftMotor.set(leftSpeed + turn);
      rightMotor.set(rightSpeed - turn);
  }
  */

  private void manualDrive(){
    switch(task){
      case cargo:
        switch(startLocation){
          case leftTier1:
            driveOffTier1();
            drive.turnToHeading(-90.0);
            drive.autoDrive(9.61666666667);
            drive.turnToHeading(0);
            drive.autoDrive(1.91666666667);
            break;
          case leftTier2:
            driveOffTier2();            
            drive.turnToHeading(-90.0);
            drive.autoDrive(9.61666666667);
            drive.turnToHeading(0);
            drive.autoDrive(1.91666666667);
            break;
          case rightTier1:
            driveOffTier1();
            drive.turnToHeading(90.0);
            drive.autoDrive(9.61666666667);
            drive.turnToHeading(0);
            drive.autoDrive(1.91666666667);
            break;
          case rightTier2:
            driveOffTier2();
            drive.turnToHeading(90.0);
            drive.autoDrive(9.61666666667);
            drive.turnToHeading(0);
            drive.autoDrive(1.91666666667);
            break;
          case middleTier1:
            driveOffTier1();
            drive.turnToHeading(90.0);
            drive.autoDrive(9.61666666667);
            drive.turnToHeading(0);
            drive.autoDrive(0.95833333333);
            break;
        }
        break;
      case rocket:
        switch(startLocation){
          case leftTier1:
            driveOffTier1();
            drive.turnToHeading(-90);
            drive.autoDrive(5.5625);
            drive.turnToHeading(0);
            drive.autoDrive(11.1541666667);
            break;
          case leftTier2:
            driveOffTier2();
            drive.turnToHeading(-90);
            drive.autoDrive(5.5625);
            drive.turnToHeading(0);
            drive.autoDrive(11.1541666667);
            break;
          case rightTier1:
            driveOffTier1();
            drive.turnToHeading(90);
            drive.autoDrive(5.5625);
            drive.turnToHeading(0);
            drive.autoDrive(11.1541666667);
            break;
          case rightTier2:
            driveOffTier2();
            drive.turnToHeading(90);
            drive.autoDrive(5.5625);
            drive.turnToHeading(0);
            drive.autoDrive(11.1541666667);
            break;
          case middleTier1:
            driveOffTier1();
            drive.turnToHeading(90);
            drive.autoDrive(8.22916666667);
            drive.turnToHeading(0);
            drive.autoDrive(11.1541666667);
            break;
        }
        break;
      case crossline:
        switch(startLocation){
          case leftTier1:
            driveOffTier1();
            //drive.turnToHeading(-90);
            //drive.autoDrive(5.5625);
            //drive.turnToHeading(0);
            //drive.autoDrive(19.6541666667);
            break;
          case leftTier2:
            driveOffTier2();
            drive.turnToHeading(-90);
            drive.autoDrive(5.5625);
            drive.turnToHeading(0);
            drive.autoDrive(19.6541666667);
            break;
          case rightTier1:
            driveOffTier1();
            drive.turnToHeading(90);
            drive.autoDrive(5.5625);
            drive.turnToHeading(0);
            drive.autoDrive(19.6541666667);
            break;
          case rightTier2:
            driveOffTier2();
            drive.turnToHeading(90);
            drive.autoDrive(5.5625);
            drive.turnToHeading(0);
            drive.autoDrive(19.6541666667);
            break;
          case middleTier1:
            driveOffTier1();
            drive.turnToHeading(90);
            drive.autoDrive(8.22916666667);
            drive.turnToHeading(0);
            drive.autoDrive(19.6541666667);
        }
        driveOffTier1();
    }
  }

  private void driveOffTier1(){
    drive.autoDrive(1.96875);
  }

  private void driveOffTier2(){
    drive.autoDrive(3.96875);
    driveOffTier1();

  }

  @Override
  protected void execute() {
    manualDrive();
    Logger.Log("Autonomous sandstorm executed.");
  }

  @Override
  protected boolean isFinished() {
    Logger.Log("Autonomous sandstorm finished.");
    return false;
  }

  @Override
  protected void end() {
    if(RobotMap.USE_PATHFINDER_LIB){
      leftMotor.set(0);
      rightMotor.set(0);
    } else{
      drive.stop();
    }
    Logger.Log("Autonomous sandstorm ended.");
  }

  @Override
  protected void interrupted() {
    if(RobotMap.USE_PATHFINDER_LIB){
      leftMotor.set(0);
      rightMotor.set(0);
    } else{
      drive.stop();
    }
    Logger.Log("Autonomous sandstorm ended.");
  }
}
