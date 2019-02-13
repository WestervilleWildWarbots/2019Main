package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class ClimbSubsystem extends Subsystem {
  DoubleSolenoid climbSol = new DoubleSolenoid(RobotMap.PNUM_CLIMB,RobotMap.PNUM_UNCLIMB);
  DoubleSolenoid climbSolR = new DoubleSolenoid(RobotMap.PNUM_CLIMBEXL,RobotMap.PNUM_UNCLIMBEXL);
  DoubleSolenoid climbSolL = new DoubleSolenoid(RobotMap.PNUM_CLIMBEXR,RobotMap.PNUM_UNCLIMBEXR);
  
  private NetworkTableInstance table;

  public ClimbSubsystem() {
    table = NetworkTableInstance.getDefault();
  }

  @Override
  public void initDefaultCommand() {
  }

  public void climbVert(String dir){
    if(dir == "up"){
    climbSol.set(Value.kForward);
  }

  if(dir == "down"){
    climbSol.set(Value.kReverse);
  }

  if(dir == "off" || dir == "undefined"){
      climbSol.set(Value.kOff);
  }
  }

  public void climbOut(String dir){

    if(dir == "out"){
      climbSolL.set(Value.kForward);
      climbSolR.set(Value.kForward);
    }
  
    if(dir == "in"){
      climbSolL.set(Value.kReverse);
      climbSolR.set(Value.kReverse);
    }
  
    if(dir == "off" || dir == "undefined"){
      climbSolL.set(Value.kOff);
      climbSolR.set(Value.kOff);
    }

  }
}
