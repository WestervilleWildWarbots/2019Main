package frc.robot.subsystems;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.LiftCommand;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LiftSubsystem extends Subsystem {

    WPI_TalonSRX liftTalon;
    
    //Sets PID variables for arm
    private int slot = 0;
    private double p = .5;
    private double i = 0;
    private double d = 0;
    private double f = 0;
    private int iZone = 1000;
    private double rampRate = 0;
    private int timeoutMs = 100;
    
	
	public LiftSubsystem(){
		liftTalon = new WPI_TalonSRX(RobotMap.LIFT_TALON);
		resetEncoder();
		
		liftTalon.setSafetyEnabled(false);
		liftTalon.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
		
		liftTalon.config_kP(slot, p, timeoutMs);
		liftTalon.config_kI(slot, i, timeoutMs);
		liftTalon.config_kD(slot, d, timeoutMs);
		liftTalon.config_kF(slot, 0, timeoutMs);
		liftTalon.config_IntegralZone(slot, iZone, timeoutMs);
		liftTalon.configClosedloopRamp(rampRate, timeoutMs);
		//liftTalon.configNominalOutputForward(0,  timeoutMs);
		//liftTalon.configNominalOutputReverse(0,  timeoutMs);
		liftTalon.configPeakOutputForward(1,  timeoutMs);
		liftTalon.configPeakOutputReverse(-1,  timeoutMs);
		
		liftTalon.setSensorPhase(true);
		
		liftTalon.set(ControlMode.Position, 0);
	}
	
	public void setPos(double goTo) {
		if(RobotMap.armPos > RobotMap.setPoint){
            liftTalon.set(.1);
        }

        if(RobotMap.armPos < RobotMap.setPoint){
            liftTalon.set(-.1);
        }
	}
	
	public void moveArm(double speed) {
		liftTalon.set(speed);
	}
	
	public void setArm(double speed){
		if(RobotMap.ALLOW_LIFT_MOVEMENT){
			//liftTalon.set(speed);
		}
	}
	
	public double getEncoderVelocity(){
		return liftTalon.getSensorCollection().getQuadratureVelocity();
	}
	
	public double getEncoderPosition(){
		return liftTalon.getSensorCollection().getQuadraturePosition();
	}
	
	public void resetEncoder(){
		liftTalon.getSensorCollection().setQuadraturePosition(0, 0);
	}
	
	public double getCurrent(){
		return liftTalon.getOutputCurrent();
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
