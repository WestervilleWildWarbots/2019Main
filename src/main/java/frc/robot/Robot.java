package frc.robot;
	
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.cameraserver.*;

public class Robot extends TimedRobot {

  //subsystems
  public static DriveSubsystem driveSubsystem;
  public static ClimbSubsystem climbSubsystem;
  public static GrabSubsystem grabSubsystem;
  public static LiftSubsystem liftSubsystem;
  public static OI oi;

  public static LiftCommand liftCommand;
  public static GrabCommand grabCommand;
  public static ReleaseCommand releaseCommand;
  public static ExtendCommand extendCommand;
  public static DriveCommand driveCommand;
  public static MonitorCommand monitorCommand;

  Command autonomousCommand;
  SendableChooser<Command> autonomousCommandDropdown = new SendableChooser<>();

  @Override
  public void robotInit() {
    oi = new OI();
    autonomousCommandDropdown.setDefaultOption("Default Auto", new DriveCommand());
    SmartDashboard.putData("Auto mode", autonomousCommandDropdown);

    //set up subsystems
    driveSubsystem = new DriveSubsystem();
    climbSubsystem = new ClimbSubsystem();
    grabSubsystem = new GrabSubsystem();
    liftSubsystem = new LiftSubsystem();

    liftCommand = new LiftCommand();
    grabCommand = new GrabCommand();
    releaseCommand = new ReleaseCommand();
    extendCommand = new ExtendCommand();
    driveCommand = new DriveCommand();
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
    autonomousCommand = autonomousCommandDropdown.getSelected();
    monitorCommand.start();
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
    RobotMap.setPoint=0;
    liftSubsystem.resetEncoder();
    driveCommand.start();
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
}
