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
    if(dir == "grabOff"){
      gOffing = true;
    }

    if(dir == "relOff"){
      rOffing = true;
    }

  if(dir == "grab"){
    grabSolL.set(Value.kForward);
    grabSolR.set(Value.kReverse);

    gOffing = false;
}

if(dir == "release"){
  grabSolL.set(Value.kReverse);
  grabSolR.set(Value.kForward);

  rOffing = false;
}

if(dir == "off"){
  gOffing = true;
  rOffing = true;
}

if(gOffing && rOffing){
  grabSolL.set(Value.kOff);
  grabSolR.set(Value.kOff);
}
  }
  public void extend(boolean extendOff) {
if(OI.getJoystickAxis(RobotMap.XBOX_CONTROLLER, Axis.RightY)<0){
outSol.set(Value.kForward);

}else if(OI.getJoystickAxis(RobotMap.XBOX_CONTROLLER, Axis.RightY)>0){
outSol.set(Value.kReverse);

}else{
  outSol.set(Value.kOff);

} 

if(extendOff= true){
  outSol.set(Value.kOff);
}
  }
}
