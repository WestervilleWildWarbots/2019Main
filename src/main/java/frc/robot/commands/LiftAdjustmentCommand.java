package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Logger;
import frc.robot.RobotMap;

public class LiftAdjustmentCommand extends Command {

	int move;
	
    public LiftAdjustmentCommand(int move) {
        this.move = move;
        Logger.Log("Lift adjust constructed.");
    }

    protected void initialize() {
        Logger.Log("Lift adjust initialized.");
    }

    protected void execute() {
        if(move < 0 || RobotMap.setPoint < 0) {
    		RobotMap.setPoint += move;
    	} else {
    		RobotMap.setPoint = 0;
    	}
    	Logger.Log("Lift adjust executed.");
    }

    protected boolean isFinished() {
        Logger.Log("Lift adjust finished.");
        return true;
    }

    protected void end() {
        Logger.Log("Lift adjust ended.");
    }

    protected void interrupted() {
        Logger.Log("Lift adjust interrupted.");
    }
}