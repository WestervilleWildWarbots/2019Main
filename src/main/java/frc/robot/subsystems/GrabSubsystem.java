package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Logger;
import frc.robot.OI;
import frc.robot.RobotMap;
import frc.robot.OI.Axis;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;


public class GrabSubsystem extends Subsystem {
 // Solenoid grabSolL = new Solenoid(1,RobotMap.PNUM_GRABL);
  //Solenoid grabSolR = new Solenoid(1,RobotMap.PNUM_GRABR);
  public static GrabSubsystem instance;
  public Solenoid left, right, middle;

  public GrabSubsystem() {
    left = new Solenoid(0);
    left = new Solenoid(2);
    left = new Solenoid(3);
  }

  public static GrabSubsystem GetInstance()
  {
    if (instance == null)
    {
      instance = new GrabSubsystem();
    }
    return instance;
  }

  @Override
  public void initDefaultCommand() {
  }
  
  public void grab( String dir) {
    Logger.Log("grab active");

  if(dir == "grab"){
    Logger.Log("grabbing");
  //  grabSolL.set(true);
//    grabSolR.set(true);


}

if(dir == "release"){
  Logger.Log("releasing");
  //grabSolL.set(false);
 // grabSolR.set(false);

}
  }
  public void extend() {
    Logger.Log("extend");
      left.set(true);
  }
}
