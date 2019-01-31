package frc.robot;
	
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.LiftCommand;
import frc.robot.subsystems.ClimbSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.GrabSubsystem;
import frc.robot.subsystems.LiftSubsystem;
import edu.wpi.first.cameraserver.*;

public class Robot extends TimedRobot {

  //subsystems
  public static DriveSubsystem driveSubsystem;
  public static ClimbSubsystem climbSubsystem;
  public static GrabSubsystem grabSubsystem;
  public static LiftSubsystem liftSubsystem;
  public static OI oi;

  public static LiftCommand liftCommand;
  Command m_autonomousCommand;
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  @Override
  public void robotInit() {
    oi = new OI();
    m_chooser.setDefaultOption("Default Auto", new DriveCommand());
    CameraServer.getInstance().startAutomaticCapture();
    // chooser.addOption("My Auto", new MyAutoCommand());
    SmartDashboard.putData("Auto mode", m_chooser);

    //set up subsystems
    driveSubsystem = new DriveSubsystem();
    climbSubsystem = new ClimbSubsystem();
    grabSubsystem = new GrabSubsystem();
    liftSubsystem = new LiftSubsystem();

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
    m_autonomousCommand = m_chooser.getSelected();

    liftCommand.start();

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
    m_autonomousCommand.start();
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
      if (m_autonomousCommand != null) {
    m_autonomousCommand.cancel();
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
