package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.RobotMap;



public class SandStormCommandGroup extends Command{ 
  public static double startHeight = 1;
  public static double startPos = 1;
  public static double targetSide = 0;
  public static double targetDepth = 0;
  public static final double autoSpeed = 20;

  public double time = 0;
  public double startDistance = 354.125;

  public static double startOffsetY = 0;
  public static double startOffsetX = 0;

  private WPI_TalonSRX frontLeft;
  private WPI_TalonSRX frontRight;
  private WPI_TalonSRX backLeft;
  private WPI_TalonSRX backRight;

  WPI_TalonSRX[] talons = {frontLeft, frontRight, backLeft, backRight};

 

  public SandStormCommandGroup() {
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
      } else if(startPos == 2){
        startOffsetY = 0;
      } else if(startPos == 3){
        startOffsetY = 1;
      }

    }

    if(startHeight == 2){
      startOffsetX = 47.625;
      if(startPos == 1){
        startOffsetY = -1;
      } else if(startPos == 2){
        startOffsetY = 0;
      } else if(startPos == 3){
        startOffsetY = 1;
      }
    }
    startOffsetY*=64;
    startDistance+=startOffsetX;
    startDistance/=39.37;

    while(time<(startDistance*2)){
    frontLeft.set(.5);
    frontRight.set(.5);
    
    backLeft.follow(frontLeft);
    backRight.follow(frontRight);
    time++;
  }
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
