package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Logger;
import frc.robot.OI;
import frc.robot.RobotMap;
import frc.robot.OI.Axis;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;


public class GrabSubsystem extends Subsystem {
  DoubleSolenoid grabSolR = new DoubleSolenoid(RobotMap.PNUM_RELEASER,RobotMap.PNUM_GRABR);
  DoubleSolenoid grabSolL = new DoubleSolenoid(RobotMap.PNUM_GRABL,RobotMap.PNUM_RELEASEL);
  DoubleSolenoid outSol = new DoubleSolenoid(RobotMap.PNUM_OUT, RobotMap.PNUM_IN);

  boolean gOffing = true;
  boolean rOffing = true;
  private NetworkTableInstance table;

  public GrabSubsystem() {
    table = NetworkTableInstance.getDefault();
  }

  @Override
  public void initDefaultCommand() {
  }
  
  public void grab( String dir) {
    Logger.Log("grab active");
    if(dir == "grabOff"){

      Logger.Log("grabOff");
      
      gOffing = true;
    }

    if(dir == "relOff"){
      Logger.Log("releaseOff");
      rOffing = true;
    }

  if(dir == "grab"){
    Logger.Log("grabbing");
    grabSolL.set(Value.kForward);
    grabSolR.set(Value.kReverse);

    gOffing = false;
}

if(dir == "release"){
  Logger.Log("releasing");
  grabSolL.set(Value.kReverse);
  grabSolR.set(Value.kForward);

  rOffing = false;
}

if(dir == "off"){
  Logger.Log("grab set off");
  gOffing = true;
  rOffing = true;
}

if(gOffing && rOffing){
  Logger.Log("grab off");
  grabSolL.set(Value.kOff);
  grabSolR.set(Value.kOff);
}
  }
  public void extend(boolean extendOff) {
    Logger.Log("extend active");
    if(OI.getJoystickAxis(RobotMap.XBOX_CONTROLLER, Axis.RightY)<0){
      Logger.Log("extending");
      outSol.set(Value.kForward);

}else if(OI.getJoystickAxis(RobotMap.XBOX_CONTROLLER, Axis.RightY)>0){
  Logger.Log("extend in");  
    outSol.set(Value.kReverse);

}else{
  Logger.Log("INVALID INPUT");
  outSol.set(Value.kOff);

} 

if(extendOff= true){
  Logger.Log("extend off");
  outSol.set(Value.kOff);
}
  }
}
