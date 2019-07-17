package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.CloseValve;

import edu.wpi.first.wpilibj.Solenoid;

public class GrabSubsystem extends Subsystem {
  private static GrabSubsystem instance;
  private Solenoid grabSolenoid;
  private Solenoid extendSolenoid;
  private Solenoid breakSolenoid;

  public GrabSubsystem() {
     grabSolenoid = new Solenoid(1, RobotMap.PNUM_GRAB);
     extendSolenoid = new Solenoid(1, RobotMap.PNUM_OUT);
     breakSolenoid = new Solenoid(1, RobotMap.PNUM_BREAK);
  }

  public static GrabSubsystem getInstance(){
    if (instance == null){
      instance = new GrabSubsystem();
    }
    return instance;
  }

  public void openGrab(){
    if(RobotMap.SAFETY_MODE == false){
    grabSolenoid.set(false);
    grabSolenoid.set(true);
    }
  }

  public void closeGrab(){
    if(RobotMap.SAFETY_MODE == false){
    grabSolenoid.set(false);
    }
  }

  public void extend(){
    if(RobotMap.SAFETY_MODE == false){
    extendSolenoid.set(true);
    }
  }

  public void retract(){
    if(RobotMap.SAFETY_MODE == false){
    extendSolenoid.set(false);
    }
  }

  public void Break(){
    if(RobotMap.SAFETY_MODE == false){
    breakSolenoid.set(true);
    }
  }

  public void stopBreak(){
    if(RobotMap.SAFETY_MODE == false){
    breakSolenoid.set(false);
    }
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new CloseValve());
  }
}
