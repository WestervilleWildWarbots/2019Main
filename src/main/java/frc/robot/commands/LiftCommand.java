package frc.robot.commands;

import frc.robot.Logger;
import frc.robot.OI;
import frc.robot.OI.Axis;
import frc.robot.Robot;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;
public class LiftCommand extends Command {
	
    private double Position;

    public LiftCommand(int Position) {
         RobotMap.setPoint=this.Position;
         Logger.Log("Lift constructed.");
    }

    protected void initialize() {
        Logger.Log("Lift initialized.");
    }

    protected void execute() {
    	double leftY = OI.getJoystickAxis(RobotMap.XBOX_CONTROLLER, Axis.LeftY);
    	if (leftY != 0) {
    		if(RobotMap.setPoint <0 || (RobotMap.setPoint >= 0 && leftY < 0)) {
    			RobotMap.setPoint += (int) leftY * 80;
    			Robot.liftSubsystem.setPos(RobotMap.setPoint);
    	    } else {
    		    RobotMap.setPoint = 0;
    		    Robot.liftSubsystem.setPos(RobotMap.setPoint);
    	    }
        } else {
    	    Robot.liftSubsystem.setPos(RobotMap.setPoint);
        }
        Logger.Log("Lift executed.");
    }
    
    protected boolean isFinished() {
        Logger.Log("Lift finished.");
        return false;
    }

    protected void end() {
        Robot.liftSubsystem.setArm(0);
        Logger.Log("Lift ended.");
    }

    protected void interrupted() {
        Robot.liftSubsystem.setArm(0);
        Logger.Log("Lift interrupted.");
    }
}
