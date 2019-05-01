package frc.robot;
	
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.cameraserver.*;
import frc.robot.AutonomousModeChooser;

public class Robot extends TimedRobot {

  //subsystems
  public static DriveSubsystem driveSubsystem;

  public static GrabSubsystem grabSubsystem;
  //public static LiftSubsystem liftSubsystem;
  public static OI oi;

  //public static LiftCommand liftCommand;
  Command driveCommand;
  Command monitorCommand;
  Command autonomousCommand;
  Command grabCommand;
  SendableChooser<Command> autonomousCommandDropdown;
  private AutonomousModeChooser autonomousModeChooser;

  @Override
  public void robotInit() {
    CameraServer.getInstance().startAutomaticCapture(0);
    oi = new OI();

    //set up subsystems
    driveSubsystem = new DriveSubsystem();
    grabSubsystem = GrabSubsystem.GetInstance();
    //liftSubsystem = new LiftSubsystem();
    driveCommand = new DriveCommand();
    //monitorCommand = new MonitorCommand();
    //liftCommand = new LiftCommand();
    autonomousCommandDropdown = new SendableChooser<>();
    autonomousModeChooser = new AutonomousModeChooser(autonomousCommandDropdown);
    autonomousModeChooser.setup();

    SmartDashboard.putData("Auto mode", autonomousCommandDropdown);
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

    //liftCommand.start();

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
    //monitorCommand.start();
    //liftSubsystem.resetEncoder();

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
