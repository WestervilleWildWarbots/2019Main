package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;

public class DriveSubsystem extends Subsystem {
  
  //Sets PID variables for drive train
	private int slot = 0;
	private int timeoutMs = 100;
	private double p = RobotMap.p;
	private double i = RobotMap.i;
	private double d = RobotMap.d;
	private double f = RobotMap.f;
	private double rampRate = RobotMap.RAMP_RATE;
  
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
    
    resetEncoders();
		
		if(RobotMap.ALLOW_PID){
			frontLeft.setSensorPhase(true);
			frontLeft.config_kP(slot, p, timeoutMs);
			frontLeft.config_kI(slot, i, timeoutMs);
			frontLeft.config_kD(slot, d, timeoutMs);
			frontLeft.configClosedloopRamp(rampRate, timeoutMs);
			frontLeft.configNominalOutputForward(0,  timeoutMs);
			frontLeft.configNominalOutputReverse(0,  timeoutMs);
			frontLeft.configPeakOutputForward(1,  timeoutMs);
			frontLeft.configPeakOutputReverse(-1,  timeoutMs);
			
			frontRight.setInverted(true);
			backRight.setInverted(true);
			
			frontRight.setSensorPhase(true);
			frontRight.config_kP(slot, p, timeoutMs);
			frontRight.config_kI(slot, i, timeoutMs);
			frontRight.config_kD(slot, d, timeoutMs);
			frontRight.configClosedloopRamp(rampRate, timeoutMs);
			frontRight.configNominalOutputForward(0,  timeoutMs);
			frontRight.configNominalOutputReverse(0,  timeoutMs);
			frontRight.configPeakOutputForward(1,  timeoutMs);
			frontRight.configPeakOutputReverse(-1,  timeoutMs);
		}
  }

  public void driveWithoutPid (double leftSpeed, double rightSpeed) {
		drive.tankDrive(leftSpeed, rightSpeed);
	}
	
  public void drive(double leftSpeed, double rightSpeed) {
    if(RobotMap.TESTING_PID_VALUES){
	    p = SmartDashboard.getNumber("PID: p", p);
	    i = SmartDashboard.getNumber("PID: i", i);
	    d = SmartDashboard.getNumber("PID: d", d);
	    f = SmartDashboard.getNumber("PID: f", f);
	    	
		  frontLeft.config_kP(slot, p, timeoutMs);
			frontLeft.config_kI(slot, i, timeoutMs);
			frontLeft.config_kD(slot, d, timeoutMs);

			frontRight.config_kP(slot, p, timeoutMs);
			frontRight.config_kI(slot, i, timeoutMs);
			frontRight.config_kD(slot, d, timeoutMs);
    	}
    }
  private void resetEncoders() {
    frontLeft.getSensorCollection().setQuadraturePosition(0, 0);
    frontRight.getSensorCollection().setQuadraturePosition(0, 0);
}

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
