package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.RobotMap;

public class LiftAdjustmentCommand extends Command {

	int move;
	
    public LiftAdjustmentCommand(int move) {
    	this.move = move;
    }

    protected void initialize() {
    }

    protected void execute() {
    	if(move < 0 || RobotMap.setPoint < 0) {
    		RobotMap.setPoint += move;
    	} else {
    		RobotMap.setPoint = 0;
    	}
    	
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}