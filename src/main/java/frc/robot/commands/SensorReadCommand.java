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
  private AnalogInput leftDist;
  private AnalogInput rightDist;

  private DigitalInput encFl;
  private DigitalInput encFr;
  private DigitalInput encBl;
  private DigitalInput encBr;
  private DigitalInput encLift;

  private DigitalInput limitTop;
  private DigitalInput limitBase;

  private AnalogGyro gyro;
  
  private DigitalInput tapeRead;

  public SensorReadCommand() {
    table = NetworkTableInstance.getDefault();

    frontDist = new AnalogInput(RobotMap.FRONT_DISTANCE_SENSOR);
    rearDist = new AnalogInput(RobotMap.REAR_DISTANCE_SENSOR);
    leftDist = new AnalogInput(RobotMap.LEFT_DISTANCE_SENSOR);
    rightDist = new AnalogInput(RobotMap.RIGHT_DISTANCE_SENSOR);

    encFl = new DigitalInput(RobotMap.ENCODER_FL);
    encFr = new DigitalInput(RobotMap.ENCODER_FR);
    encBl = new DigitalInput(RobotMap.ENCODER_BL);
    encBr = new DigitalInput(RobotMap.ENCODER_BR);
    encLift = new DigitalInput(RobotMap.ENCODER_LIFT);

    limitTop = new DigitalInput(RobotMap.TOP_LIMIT_SWITCH_ID);
    limitBase = new DigitalInput(RobotMap.BOTTOM_LIMIT_SWITCH_ID);

    gyro = new AnalogGyro(RobotMap.ANALOG_GYRO);
    gyro.initGyro();
    gyro.calibrate();
    
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

    
    //encoder updates
    table.getEntry("encoder_valueFL").setValue(encFl.get());
    SmartDashboard.getEntry("encoder_valueFL").getDouble(RobotMap.DEFAULT_VALUE);

    table.getEntry("encoder_valueFR").setValue(encFr.get());
    SmartDashboard.getEntry("encoder_valueFR").getDouble(RobotMap.DEFAULT_VALUE);

    table.getEntry("encoder_valueBL").setValue(encBl.get());
    SmartDashboard.getEntry("encoder_valueBL").getDouble(RobotMap.DEFAULT_VALUE);

    table.getEntry("encoder_valueBR").setValue(encBr.get());
    SmartDashboard.getEntry("encoder_valueBR").getDouble(RobotMap.DEFAULT_VALUE);

    table.getEntry("encoder_valueLift").setValue(encLift.get());
    SmartDashboard.getEntry("encoder_valueLift").getDouble(RobotMap.DEFAULT_VALUE);


    //distance sensor updates
    table.getEntry("frontDist_value").setValue(frontDist.getValue());
    SmartDashboard.getEntry("frontDist_value").getDouble(RobotMap.DEFAULT_VALUE);

    table.getEntry("rearDist_value").setValue(rearDist.getValue());
    SmartDashboard.getEntry("rearDist_value").getDouble(RobotMap.DEFAULT_VALUE);

    table.getEntry("leftDist_value").setValue(leftDist.getValue());
    SmartDashboard.getEntry("leftDist_value").getDouble(RobotMap.DEFAULT_VALUE);

    table.getEntry("rightDist_value").setValue(rightDist.getValue());
    SmartDashboard.getEntry("rightDist_value").getDouble(RobotMap.DEFAULT_VALUE);


    //limit switch updates
    table.getEntry("top_limit").setBoolean(limitTop.get());
    SmartDashboard.getEntry("top_limit").getDouble(RobotMap.DEFAULT_VALUE);

    table.getEntry("base_limit").setBoolean(limitBase.get());
    SmartDashboard.getEntry("base_limit").getDouble(RobotMap.DEFAULT_VALUE);


    //line tracker updates
    table.getEntry("tape_read").setValue(tapeRead.get());
    SmartDashboard.getEntry("tape_read").getDouble(RobotMap.DEFAULT_VALUE);
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
