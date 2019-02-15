package frc.robot.subsystems;
import frc.robot.RobotMap;
import frc.robot.commands.LiftCommand;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Logger;

public class LiftSubsystem extends Subsystem {

    WPI_TalonSRX liftTalon;
    
    private int slot = 0;
    private double p = .5;
    private double i = 0;
    private double d = 0;
    private int iZone = 1000;
    private double rampRate = 0;
    private int timeoutMs = 100;
    
	
	public LiftSubsystem(){
		Logger.Log("Lift Subsystem constructed");
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
		Logger.Log("Lift Subsystem set lift position");
		liftTalon.set(ControlMode.Position, goTo);
	}
	
	public void moveArm(double speed) {
		Logger.Log("Lift Subsystem move lift");
		liftTalon.set(speed);
	}
	
	public void setArm(double speed){
		Logger.Log("Lift Subsystem set lift speed");
		if(RobotMap.ALLOW_LIFT_MOVEMENT){
			//liftTalon.set(speed);
		}
	}
	
	public double getEncoderVelocity(){
		Logger.Log("Lift Subsystem got encoder velocity");
		return liftTalon.getSensorCollection().getQuadratureVelocity();
	}
	
	public double getEncoderPosition(){
		Logger.Log("Lift Subsystem got encoder position");
		return liftTalon.getSensorCollection().getQuadraturePosition();
	}
	
	public void resetEncoder(){
		Logger.Log("Lift Subsystem reset encoder");
		liftTalon.getSensorCollection().setQuadraturePosition(0, 0);
	}
	
	public double getCurrent(){
		Logger.Log("Lift Subsystem got current");
		return liftTalon.getOutputCurrent();
	}

    public void initDefaultCommand() {
    }
}
