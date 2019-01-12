package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogGyro;

public class DriveSubsystem extends Subsystem {
  
  //Initializing sensors relating to driving
  private AnalogInput frontDist;
  private AnalogInput rearDist;
  private AnalogGyro gyro;

  public DriveSubsystem (){
    frontDist = new AnalogInput(RobotMap.FRONT_DISTANCE_SENSOR);
    rearDist = new AnalogInput(RobotMap.REAR_DISTANCE_SENSOR);
    gyro = new AnalogGyro(RobotMap.ANALOG_GYRO);
  }

  @Override
  public void initDefaultCommand() {
  }
}
