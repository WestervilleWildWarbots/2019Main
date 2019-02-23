package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.RobotMap;

public class LiftAdjustmentCommand extends Command {

	int move; // How many encoder positions to move the arm
	
    public LiftAdjustmentCommand(int move) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.move = move;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    // Changes the position the arm stays at and makes it so the liftSetPoint can't be below the bottom limit
    protected void execute() {
    	if(move < 0 || RobotMap.liftSetPoint < 0) {
    		RobotMap.liftSetPoint += move;
    	} else {
    		RobotMap.liftSetPoint = 0;
    	}
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true; // Causes execute() to run a single time
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}