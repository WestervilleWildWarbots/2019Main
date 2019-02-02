package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Subsystem;

import frc.robot.OI;
import frc.robot.RobotMap;
import frc.robot.OI.Axis;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;


public class GrabSubsystem extends Subsystem {
  DoubleSolenoid grabSolR = new DoubleSolenoid(RobotMap.PNUM_RELEASER,RobotMap.PNUM_GRABR);
  DoubleSolenoid grabSolL = new DoubleSolenoid(RobotMap.PNUM_GRABL,RobotMap.PNUM_RELEASEL);
  DoubleSolenoid outSol = new DoubleSolenoid(RobotMap.PNUM_OUT, RobotMap.PNUM_IN);

  /* 
   * NOTICE: Using the NetworkTable
   * ==============================
   *
   * If you want to store data in the NetworkTable, you need to use a
   * NetworkTableEntry. These objects work like key-pair values. To get an
   * entry, call table.getEntry(String key).setValue(Object obj). The key
   * should be the name of the information being stored. The obj in setValue()
   * can be any object or primitive variable.
   *
   * Ex: table.getEntry("speed").setValue(42);
   *
   * To later retrieve this value (in any subsystem!), use
   * table.getEntry.getDouble() or the appropriate type method eg
   * getBoolean(). Note: you must pass a default value that will be returned
   * in case the key doesn't exist or other errors occur. I recommend passing
   * 0 when in doubt.
   *
   * Ex: double myVelocity = table.getDefault("speed").getDouble(0);
   *
   * The above gets the stored value and stores it into myVelocity.
   * If you want to use a custom data object (don't do this unless you know what
   * you're doing), call getValue().getValue() and cast to the appropriate type.
   */

  //initialize the NetworkTable and store a reference to it in table
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
