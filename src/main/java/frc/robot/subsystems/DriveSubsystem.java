
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Logger;
import frc.robot.OI;
import frc.robot.OI.Axis;
import frc.robot.RobotMap;

public class DriveSubsystem extends Subsystem {
  private static WPI_TalonSRX frontLeft;
  private static WPI_TalonSRX frontRight;
  private static WPI_TalonSRX backLeft;
  private static WPI_TalonSRX backRight;
  
  /*
   * NOTICE: Using the NetworkTable
   * ==============================
   *
   * If you want to store data in the NetworkTable, you need to use a
   * NetworkTableEntry. These objects work like key-pair values. To get an
   * entry, call table.getEntry(String key).setValue(Object obj). The key
   * should be the name of the information being stored. The obj in setValue()
   * can be any object or primitive variable.
   *
   * Ex: table.getEntry("speed").setValue(42);
   *
   * To later retrieve this value (in any subsystem!), use
   * table.getEntry.getDouble() or the appropriate type method eg
   * getBoolean(). Note: you must pass a default value that will be returned
   * in case the key doesn't exist or other errors occur. I recommend passing
   * 0 when in doubt.
   *
   * Ex: double myVelocity = table.getDefault("speed").getDouble(0);
   *
   * The above gets the stored value and stores it into myVelocity.
   * If you want to use a custom data object (don't do this unless you know what
   * you're doing), call getValue().getValue() and cast to the appropriate type.
   */

  //initialize the NetworkTable and store a reference to it in table
  private NetworkTableInstance table;

  public DriveSubsystem() {
    table = NetworkTableInstance.getDefault();
    frontLeft = new WPI_TalonSRX(RobotMap.MOTOR_FL);
    frontRight = new WPI_TalonSRX(RobotMap.MOTOR_FR);
    backLeft = new WPI_TalonSRX(RobotMap.MOTOR_BL);
    backRight = new WPI_TalonSRX(RobotMap.MOTOR_BR);
    frontLeft.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
    frontRight.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
    frontLeft.setSelectedSensorPosition(0);
    frontRight.setSelectedSensorPosition(0);

    //frontDist = new AnalogInput();

    backLeft.follow(frontLeft);
    backRight.follow(frontRight);
  }

  @Override
  public void initDefaultCommand(){
    
  }
  
  public static int getLeftEnc() { //test method
    Logger.Log("DriveSubsystem got left encoder");
    return frontLeft.getSensorCollection().getQuadraturePosition();
  }

  public static int getRightEnc() { //test method
    Logger.Log("DriveSubsystem got right encoder");
    return frontRight.getSensorCollection().getQuadraturePosition();
  }

  public void drive(double leftSpeed, double rightSpeed) {
    Logger.Log("DriveSubsystem drived");
    frontLeft.set(leftSpeed);
    frontRight.set(-rightSpeed);
  }

/* I Don't know what this is or why its like this and frankly it is dead to me - Robert
  public void drive(double spd) {
    if(OI.getJoystickAxis(RobotMap.DRIVE_STICK, Axis.Z) == 0){

      if(OI.getJoystickAxis(RobotMap.DRIVE_STICK, Axis.X) != 0){

        frontLeft.set(OI.getJoystickAxis(RobotMap.DRIVE_STICK, Axis.X)*spd);
        frontRight.set(OI.getJoystickAxis(RobotMap.DRIVE_STICK, Axis.X)*-spd);
      }
    
    }else if(OI.getJoystickAxis(RobotMap.DRIVE_STICK, Axis.Z)>0){
      frontLeft.set(OI.getJoystickAxis(RobotMap.DRIVE_STICK,Axis.Z)* -spd);
      frontRight.set(OI.getJoystickAxis(RobotMap.DRIVE_STICK, Axis.Z)*-spd);
    
    }else if(OI.getJoystickAxis(RobotMap.DRIVE_STICK, Axis.Z)<0){
      frontLeft.set(OI.getJoystickAxis(RobotMap.DRIVE_STICK, Axis.Z)*spd);
      frontRight.set(OI.getJoystickAxis(RobotMap.DRIVE_STICK, Axis.Z)*spd);

    }else{
    frontLeft.set(0);
    frontRight.set(0);
    }
    backLeft.follow(frontLeft);
    backRight.follow(frontRight);  
  }
*/



}