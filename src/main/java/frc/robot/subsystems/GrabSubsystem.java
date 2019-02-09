package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;


public class GrabSubsystem extends Subsystem {
  DoubleSolenoid grabSolR = new DoubleSolenoid(RobotMap.PNUM_RELEASER,RobotMap.PNUM_GRABR);
  DoubleSolenoid grabSolL = new DoubleSolenoid(RobotMap.PNUM_GRABL,RobotMap.PNUM_RELEASEL);
  DoubleSolenoid outSol = new DoubleSolenoid(RobotMap.PNUM_OUT, RobotMap.PNUM_IN);
  private NetworkTableInstance table;

  public GrabSubsystem() {
	  table = NetworkTableInstance.getDefault();
  }

  @Override
  public void initDefaultCommand() {
  }
  
  public void grab() {
    grabSolL.set(Value.kForward);
    grabSolR.set(Value.kReverse);

  }

  public void release() {
  grabSolL.set(Value.kReverse);
  grabSolR.set(Value.kForward);
}

  public void grabOff() {
    grabSolL.set(Value.kOff);
    grabSolR.set(Value.kOff);
  }

  
  public void extend() {

outSol.set(Value.kForward);
}
public void extendOff(){
  outSol.set(Value.kReverse);
}
}
