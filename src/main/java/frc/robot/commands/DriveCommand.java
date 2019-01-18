package frc.robot.commands;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.RobotMap;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.OI.Axis;
import frc.robot.Robot;
import frc.robot.OI;

public class DriveCommand extends Command {
 public static double speed = 20;
  public DriveCommand() {
     
  }

  @Override
  protected void initialize() {
    speed = 20;
  }

  @Override
  protected void execute() {
    speed = 20;
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
     speed = 0;
  }

  @Override
  protected void interrupted() {
     speed = 0;
  }
}
