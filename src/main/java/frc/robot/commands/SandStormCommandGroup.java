package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.RobotMap;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.OI.Axis;
import frc.robot.Robot;
import frc.robot.OI;



public class SandstormCommandGroup extends Command {
  public static final double startHeight = 1;
  public static final double startPos = 1;
  public static final double target = 0;
  public static final double autoSpeed = 20;

  public static double startOffsetY = 0;
  public static double startOffsetX = 0;
  
  public static final double startDistance = 354.125;

  private WPI_TalonSRX frontLeft;
  private WPI_TalonSRX frontRight;
  private WPI_TalonSRX backLeft;
  private WPI_TalonSRX backRight;

   WPI_TalonSRX[] talons = {frontLeft, frontRight, backLeft, backRight};

 

  public SandstormCommandGroup() {
    frontLeft = new WPI_TalonSRX(RobotMap.MOTOR_FL);
  frontRight = new WPI_TalonSRX(RobotMap.MOTOR_FR);
  backLeft = new WPI_TalonSRX(RobotMap.MOTOR_BL);
  backRight = new WPI_TalonSRX(RobotMap.MOTOR_BR);
  }

  @Override
  protected void initialize() {
    if(startHeight == 1){
      startOffsetX = 0;
      if(startPos == 1){
        startOffsetY = -1;
      }

      if(startPos == 2){
        startOffsetY = 0;
      }

      if(startPos == 3){
        startOffsetY = 1;
      }
    }

    if(startHeight == 2){
      startOffsetX = 47.625;
      if(startPos == 1){
        startOffsetY = -1;
      }

      if(startPos == 2){
        startOffsetY = 0;
      }

      if(startPos == 3){
        startOffsetY = 1;
      }
    }

    startOffsetY*=64;
    startDistance+=startOffsetX;

    frontLeft.set(0,100);
    frontRight.set(0);
    

    backLeft.follow(frontLeft);
    backRight.follow(frontRight);

    
  }

  @Override
  protected void execute() {
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
  }

  @Override
  protected void interrupted() {
  }
}