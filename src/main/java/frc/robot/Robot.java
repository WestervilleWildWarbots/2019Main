package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.*;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.LiftCommand;

import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.GrabSubsystem;
import frc.robot.subsystems.LiftSubsystem;
import frc.robot.subsystems.NotDriveSubsystem;
import frc.robot.Logger;

public class Robot extends TimedRobot {
  public static DriveSubsystem driveSubsystem;
  public static NotDriveSubsystem notDriveSubsystem;

  public static GrabSubsystem grabSubsystem;
  public static LiftSubsystem liftSubsystem;

  public static OI oi;

  public static LiftCommand liftCommand;
  public static GrabCommand grabCommand;
  public static ReleaseCommand releaseCommand;
  public static ExtendCommand extendCommand;
  public static DriveCommand driveCommand;
  public static NotDriveCommand notDriveCommand;
  public static MonitorCommand monitorCommand;
  public static AutonomousSandstormCommand sandstormCommand;


  private static Command autonomousCommand;
  private static SendableChooser<Command> autonomousCommandDropdown;

  private static AutonomousModeChooser autonomousModeChooser;

  @Override
  public void robotInit() {
    oi = new OI();

    driveSubsystem = new DriveSubsystem();
    notDriveSubsystem = new NotDriveSubsystem();

    grabSubsystem = new GrabSubsystem();
    liftSubsystem = new LiftSubsystem();

    liftCommand = new LiftCommand(0);
    grabCommand = new GrabCommand();
    releaseCommand = new ReleaseCommand();
    extendCommand = new ExtendCommand("in");
    driveCommand = new DriveCommand();


    autonomousCommandDropdown = new SendableChooser<>();
    autonomousModeChooser = new AutonomousModeChooser(autonomousCommandDropdown);
    autonomousModeChooser.setup();

    SmartDashboard.putData("Auto mode", autonomousCommandDropdown);
    monitorCommand = new MonitorCommand();
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
    Logger.Log("autonomous initiated");
    autonomousCommand = autonomousCommandDropdown.getSelected();
    Logger.Log("command selected");

    liftSubsystem.resetEncoder();
    Logger.Log("encoders reset");

    liftCommand.start();
    Logger.Log("liftComm activated");

    grabCommand.start();
    releaseCommand.start();
    Logger.Log("grabComms activated");

    extendCommand.start();
    Logger.Log("exComm activated");

    monitorCommand.start();
    Logger.Log("monitorComm activated");

    if (autonomousCommand != null) {
    autonomousCommand.start();
    }
  }

  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    Logger.Log("teleop initiated");
    RobotMap.setPoint=0;
    
    liftSubsystem.resetEncoder();
    Logger.Log("encoders reset");

    driveCommand.start();
    Logger.Log("driveComm activated");
    
   
    
    if (autonomousCommand != null) {
    autonomousCommand.cancel();
    Logger.Log("Auton nULL");
    }
  }

  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void testPeriodic() {
  }


}
