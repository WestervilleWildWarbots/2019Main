package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Logger;
import frc.robot.Robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

/**
 * This class provides a Command that handles all autonomous (Sandstorm) scenarios.
 */

public class AutonomousSandstormCommand extends Command {

  private WPI_TalonSRX leftMotor;
  private WPI_TalonSRX rightMotor;

  public AutonomousSandstormCommand(){
    Logger.Log("Autonomous sandstorm cunstructed.");
  }

  @Override
  protected void initialize() {    
    Logger.Log("Autonomous sandstorm initialized.");
  }

  @Override
  protected void execute() {
    if(System.currentTimeMillis() <= 2500){

    Robot.driveSubsystem.drive(0.5, 0.5);
  }
    Logger.Log("Autonomous sandstorm executed.");
  }

  @Override
  protected boolean isFinished() {
    Logger.Log("Autonomous sandstorm finished.");
    return false;
  }

  @Override
  protected void end() {
      leftMotor.set(0);
      rightMotor.set(0);
    Logger.Log("Autonomous sandstorm ended.");
  }

  @Override
  protected void interrupted() {
      leftMotor.set(0);
      rightMotor.set(0);
    Logger.Log("Autonomous sandstorm ended.");
  }
}
