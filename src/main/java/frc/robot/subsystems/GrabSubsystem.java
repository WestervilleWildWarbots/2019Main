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
    grabSolenoid.set(false);
    grabSolenoid.set(true);
  }

  public void closeGrab(){
    grabSolenoid.set(false);
  }

  public void extend(){
    extendSolenoid.set(true);
  }

  public void retract(){
    extendSolenoid.set(false);
  }

  public void Break(){
    breakSolenoid.set(true);
  }

  public void stopBreak(){
    breakSolenoid.set(false);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new CloseValve());
  }
}
