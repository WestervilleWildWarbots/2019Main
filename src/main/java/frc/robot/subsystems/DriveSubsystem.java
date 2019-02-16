package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;

public class DriveSubsystem extends Subsystem {
  private WPI_TalonSRX frontLeft;
	private WPI_TalonSRX frontRight;
	private WPI_TalonSRX backLeft;
  private WPI_TalonSRX backRight;
  private SpeedControllerGroup left = new SpeedControllerGroup(frontLeft, backLeft);
  private SpeedControllerGroup right = new SpeedControllerGroup(frontRight, backRight);
  private DifferentialDrive drive = new DifferentialDrive(left, right);

  public DriveSubsystem(){
    frontLeft = new WPI_TalonSRX(RobotMap.MOTOR_FL);
		frontRight = new WPI_TalonSRX(RobotMap.MOTOR_FR);
		backLeft = new WPI_TalonSRX(RobotMap.MOTOR_BL);
		backRight = new WPI_TalonSRX(RobotMap.MOTOR_BR);
  }

  public void drive(double leftSpeed, double rightSpeed) {
		drive.tankDrive(leftSpeed, rightSpeed);
	}

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
