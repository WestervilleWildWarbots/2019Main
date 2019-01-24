package frc.robot.commands;

import com.sun.source.tree.LineMap;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalSource;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;

public class SensorReadCommand extends Command {

  //reference to NetworkTable
  private NetworkTableInstance table;
  
  //Initializing sensors relating to driving
  private AnalogInput frontDist;
  private AnalogInput rearDist;
  private AnalogGyro gyro;
  private DigitalInput tapeRead;

  public SensorReadCommand() {
    table = NetworkTableInstance.getDefault();
    frontDist = new AnalogInput(RobotMap.FRONT_DISTANCE_SENSOR);
    rearDist = new AnalogInput(RobotMap.REAR_DISTANCE_SENSOR);
    gyro = new AnalogGyro(RobotMap.ANALOG_GYRO);
    tapeRead = new DigitalInput(RobotMap.LINE_TRACKER);
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    //update gyro number
    table.getEntry("gyro_angle").setValue(gyro.getAngle());
    SmartDashboard.getEntry("gyro_angle").getDouble(RobotMap.DEFAULT_VALUE);
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
