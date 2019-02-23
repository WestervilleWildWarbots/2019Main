package frc.robot;
	
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.*;
<<<<<<< HEAD
import frc.robot.subsystems.*;
import edu.wpi.first.cameraserver.*;
=======
import frc.robot.commands.DriveCommand;
import frc.robot.commands.LiftCommand;

import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.GrabSubsystem;
import frc.robot.subsystems.LiftSubsystem;
import frc.robot.subsystems.NotDriveSubsystem;
import frc.robot.Logger;
>>>>>>> master

public class Robot extends TimedRobot {

  //subsystems
  public static DriveSubsystem driveSubsystem;
<<<<<<< HEAD
  public static ClimbSubsystem climbSubsystem;
=======
  public static NotDriveSubsystem notDriveSubsystem;

>>>>>>> master
  public static GrabSubsystem grabSubsystem;
  public static LiftSubsystem liftSubsystem;
  public static OI oi;

  public static LiftCommand liftCommand;
<<<<<<< HEAD
  Command driveCommand;
  Command monitorCommand;
  Command autonomousCommand;
  SendableChooser<Command> autonomousCommandDropdown = new SendableChooser<>();
=======
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
>>>>>>> master

  @Override
  public void robotInit() {
    CameraServer.getInstance().startAutomaticCapture(0);
    oi = new OI();
    autonomousCommandDropdown.setDefaultOption("Default Auto", new DriveCommand());
    SmartDashboard.putData("Auto mode", autonomousCommandDropdown);

    //set up subsystems
    driveSubsystem = new DriveSubsystem();
<<<<<<< HEAD
    climbSubsystem = new ClimbSubsystem();
=======
    notDriveSubsystem = new NotDriveSubsystem();

>>>>>>> master
    grabSubsystem = new GrabSubsystem();
    liftSubsystem = new LiftSubsystem();
    driveCommand = new DriveCommand();
<<<<<<< HEAD
=======


    autonomousCommandDropdown = new SendableChooser<>();
    autonomousModeChooser = new AutonomousModeChooser(autonomousCommandDropdown);
    autonomousModeChooser.setup();

    SmartDashboard.putData("Auto mode", autonomousCommandDropdown);
>>>>>>> master
    monitorCommand = new MonitorCommand();
    liftCommand = new LiftCommand();
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
    autonomousCommand = autonomousCommandDropdown.getSelected();

    liftCommand.start();

    // schedule the autonomous command (example)
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
    RobotMap.liftSetPoint=0;
    driveCommand.start();
<<<<<<< HEAD
    monitorCommand.start();
    liftSubsystem.resetEncoder();
=======
    Logger.Log("driveComm activated");
    
   
    
>>>>>>> master
    if (autonomousCommand != null) {
    autonomousCommand.cancel();
    }
  }

  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void testPeriodic() {
  }
<<<<<<< HEAD
=======


>>>>>>> master
}
