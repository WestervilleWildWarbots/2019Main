package frc.robot.commands;
import  frc.robot.OI;
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

public class LiftCommand extends Command {

DoubleSolenoid liftSol = new DoubleSolenoid(RobotMap.PNUM_LIFTUP,RobotMap.PNUM_LIFTDOWN);
  
public LiftCommand() {
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    if(OI.getJoystickAxis(RobotMap.XBOX_CONTROLLER, Axis.LeftY)>0){
        liftSol.set(Value.kForward);
    }

    else if(OI.getJoystickAxis(RobotMap.XBOX_CONTROLLER, Axis.LeftY)<0){
      liftSol.set(Value.kReverse);
      
    }else{liftSol.set(Value.kOff);}
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
