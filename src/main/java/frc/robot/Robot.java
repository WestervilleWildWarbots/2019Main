package frc.robot;
	
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.cscore.CameraServerJNI;
import edu.wpi.first.cameraserver.*;

public class Robot extends IterativeRobot {

  //subsystems
  public static DriveSubsystem driveSubsystem;
  public static GrabSubsystem grabSubsystem;
  public static LiftSubsystem liftSubsystem;

  public static DriveCommand driveCommand;
  public static LiftCommand liftCommand;
  public static AutonomousSandstormCommand sandCommand;

  public static OI oi;


  @Override
  public void robotInit() {
    driveSubsystem = new DriveSubsystem();
    grabSubsystem = GrabSubsystem.getInstance();
    liftSubsystem = LiftSubsystem.getInstance();
    liftSubsystem = new LiftSubsystem();
    liftCommand = new LiftCommand();
    driveCommand = new DriveCommand();
    sandCommand = new AutonomousSandstormCommand();

    CameraServer.getInstance().startAutomaticCapture();
    CameraServer.getInstance().startAutomaticCapture();


      oi = new OI();
      
  }

  @Override
  public void robotPeriodic() {
  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void autonomousInit() {

    //liftCommand.start();
    driveCommand.start();
  }


  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {

    liftCommand.start();
    driveCommand.start();
  }

  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void testPeriodic() {
    //LiveWindow.run();
  }
}
