package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import frc.robot.Logger;


public class GrabSubsystem extends Subsystem {
  DoubleSolenoid grabSolR = new DoubleSolenoid(RobotMap.PNUM_RELEASER,RobotMap.PNUM_GRABR);
  DoubleSolenoid grabSolL = new DoubleSolenoid(RobotMap.PNUM_GRABL,RobotMap.PNUM_RELEASEL);
  DoubleSolenoid outSol = new DoubleSolenoid(RobotMap.PNUM_OUT, RobotMap.PNUM_IN);
  private NetworkTableInstance table;

  public GrabSubsystem() {
    table = NetworkTableInstance.getDefault();
    Logger.Log("Grab Sybsystem constructed");
  }

  @Override
  public void initDefaultCommand() {
  }
  
  public void grab() {
    grabSolL.set(Value.kForward);
    grabSolR.set(Value.kReverse);
    Logger.Log("Grab Sybsystem grabed");
  }

  public void release() {
  grabSolL.set(Value.kReverse);
  grabSolR.set(Value.kForward);
  Logger.Log("Grab Sybsystem released");
}

  public void grabOff() {
    grabSolL.set(Value.kOff);
    grabSolR.set(Value.kOff);
    Logger.Log("Grab Sybsystem grab turned off");
  }

  
  public void extend() {

outSol.set(Value.kForward);
Logger.Log("Grab Sybsystem extended");
}
public void extendOff(){
  outSol.set(Value.kReverse);
  Logger.Log("Grab Sybsystem extend turned off");
}
}
