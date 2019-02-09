
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class DriveSubsystem extends Subsystem {
  private WPI_TalonSRX frontLeft;
  private WPI_TalonSRX frontRight;
  private WPI_TalonSRX backLeft;
  private WPI_TalonSRX backRight;
  private NetworkTableInstance table;

  public DriveSubsystem() {
    table = NetworkTableInstance.getDefault();
    frontLeft = new WPI_TalonSRX(RobotMap.MOTOR_FL);
    frontRight = new WPI_TalonSRX(RobotMap.MOTOR_FR);
    backLeft = new WPI_TalonSRX(RobotMap.MOTOR_BL);
    backRight = new WPI_TalonSRX(RobotMap.MOTOR_BR);

    frontRight.setInverted(true);
    backRight.setInverted(true);
    
    backLeft.follow(frontLeft);
    backRight.follow(frontRight); 
  }

  @Override
  public void initDefaultCommand(){

  }
  

  /**
   * This method should drive the given distance at the given speed directly forward.
   * This is most useful for autonomous.
   */
  public void autoDrive(double distance, double spd){
    frontLeft.set(spd);
    frontRight.set(spd);

  }

  public void drive(double left, double right) {
    /*if(OI.getJoystickAxis(RobotMap.DRIVE_STICK, Axis.Z) == 0){

      if(OI.getJoystickAxis(RobotMap.DRIVE_STICK, Axis.Y) != 0){

        frontLeft.set(OI.getJoystickAxis(RobotMap.DRIVE_STICK, Axis.Y)*spd);
        frontRight.set(OI.getJoystickAxis(RobotMap.DRIVE_STICK, Axis.Y)*spd);
      }
    
    }else if(OI.getJoystickAxis(RobotMap.DRIVE_STICK, Axis.Z)>0){
      frontLeft.set(OI.getJoystickAxis(RobotMap.DRIVE_STICK,Axis.Z)* -spd);
      frontRight.set(OI.getJoystickAxis(RobotMap.DRIVE_STICK, Axis.Z)*spd);
    
    }else if(OI.getJoystickAxis(RobotMap.DRIVE_STICK, Axis.Z)<0){
      frontLeft.set(OI.getJoystickAxis(RobotMap.DRIVE_STICK, Axis.Z)*spd);
      frontRight.set(OI.getJoystickAxis(RobotMap.DRIVE_STICK, Axis.Z)*-spd);

    }else{
    frontLeft.set(0);
    frontRight.set(0);
    }*/
     frontLeft.set(left);
     frontRight.set(right);
  }




}
