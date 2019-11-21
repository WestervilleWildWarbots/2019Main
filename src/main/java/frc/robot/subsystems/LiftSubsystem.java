package frc.robot.subsystems;
import frc.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Logger;

public class LiftSubsystem extends Subsystem implements PIDOutput{

	private static WPI_TalonSRX liftTalon;
	private static WPI_TalonSRX liftFollowTalon;

	private static DigitalInput  LimitTop = new DigitalInput(RobotMap.TOP_LIMIT_SWITCH_ID);
	private static DigitalInput  LimitBase = new DigitalInput(RobotMap.BOTTOM_LIMIT_SWITCH_ID);
	private static LiftSubsystem instance;
	private NetworkTableInstance table;

	private Encoder liftEncoder; 
	
	public final PIDController armController;

	private final double p = 0;
	private final double i = 0;
	private final double d = 0;

	//private DigitalInput limitBase;	
	//private DigitalInput limitTop;

	public LiftSubsystem(){
		
		
		//table.getEntry("toplimit").setValue(LimitBase.get());
		liftTalon = new WPI_TalonSRX(RobotMap.LIFT_TALON);
		liftFollowTalon = new WPI_TalonSRX(RobotMap.LIFT_TALON_II);
		liftEncoder = new Encoder();
		liftFollowTalon.follow(liftTalon);

		armController = new PIDController(p, i, d, , this);

		/*
		resetEncoder();
		*/
		//limitBase = new DigitalInput(6);
		//limitTop = new DigitalInput(5);
		/*
		liftTalon.setSafetyEnabled(false);
		liftTalon.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
		liftTalon.disable();
		liftTalon.config_kP(slot, p, timeoutMs);
		liftTalon.config_kI(slot, i, timeoutMs);
		liftTalon.config_kD(slot, d, timeoutMs);
		liftTalon.config_kF(slot, f, timeoutMs);
		liftTalon.config_IntegralZone(slot, iZone, timeoutMs);
		liftTalon.configClosedloopRamp(rampRate, timeoutMs);
		//liftTalon.configNominalOutputForward(0,  timeoutMs);
		//liftTalon.configNominalOutputReverse(0,  timeoutMs);
		liftTalon.configPeakOutputForward(1,  timeoutMs);
		liftTalon.configPeakOutputReverse(-1,  timeoutMs);
		
		liftTalon.setSensorPhase(true);
		
		liftTalon.set(ControlMode.Position, 0);*/
	}
	
	public static LiftSubsystem getInstance(){
		if (instance == null){
		  instance = new LiftSubsystem();
		}
		return instance;
	  }

	public static int getLiftEnc(){
		return liftTalon.getSensorCollection().getQuadraturePosition();
	}

	/*public static boolean getBaseLimit() {
		return LimitBase.get();
	}

	public static boolean getTopLimit() {
		return LimitTop.get();
	}

	public boolean getLimits(int id) {
		Logger.Log("LiftSubsystem got limits");
		if (id == 1) {
			return limitBase.get();
		} else if (id == 2) {
			return limitTop.get();
		} else {
			Logger.Log("INVALID LIMIT SWITCH");
			return false;
		}
	}*/

	public void setPos(double goTo) {
		Logger.Log("LiftSubsystem set position");
		if(getLiftEnc() >= 0){
			liftTalon.set(0);
		}else{
		liftTalon.set(ControlMode.Position, goTo);
		}
	}

	public void moveArm(double speed) {
		Logger.Log("LiftSubsystem moved arm");
		liftTalon.set(speed);
	}
	
	public void set(double speed){
		Logger.Log("LiftSubsystem set motor speed");
		if(RobotMap.ALLOW_LIFT_MOVEMENT){
			//liftTalon.set(speed);
		}
	}
	
	public double getEncoderVelocity(){
		Logger.Log("LiftSubsystem got encoder velocity");
		return liftTalon.getSensorCollection().getQuadratureVelocity();
	}

	public void resetEncoder(){
		Logger.Log("LiftSubsystem reset encoder");
		liftTalon.getSensorCollection().setQuadraturePosition(0, 0);
	}

	public double getCurrent(){
		Logger.Log("LiftSubsystem got current");
		return liftTalon.getOutputCurrent();
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

	@Override
	public void pidWrite(double output) {

	}

}