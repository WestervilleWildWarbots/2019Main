package frc.robot.commands;

import frc.robot.OI;
import frc.robot.RobotMap;
import frc.robot.OI.Axis;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.util.WPILibVersion;
import edu.wpi.first.hal.can.*;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;

public class GrabCommand extends Command {
  DoubleSolenoid grabSolR = new DoubleSolenoid(RobotMap.PNUM_RELEASER,RobotMap.PNUM_GRABR);
  DoubleSolenoid grabSolL = new DoubleSolenoid(RobotMap.PNUM_GRABL,RobotMap.PNUM_RELEASEL);

  public GrabCommand() {
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    if(OI.getJoystickAxis(RobotMap.XBOX_CONTROLLER, Axis.RightY) != 0){
      grabSolL.set(Value.kForward);
      grabSolR.set(Value.kReverse);
  }

  else{
    grabSolR.set(Value.kForward);
    grabSolL.set(Value.kReverse);
    
}
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
  }

  @Override
  protected void interrupted() {
  }
}
