package frc.robot.commands;

import frc.robot.Logger;
import frc.robot.OI;
import frc.robot.OI.Axis;
import frc.robot.subsystems.LiftSubsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;
// Changes the arm position based on the XBox Controller
public class LiftCommand extends Command {
	
    public LiftCommand() {
      
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    // Changes the position of the Arm based on the Joystick's left joystick
    protected void execute() {
        Logger.Log("LiftCommand Executed");
      //  double v = 0;
    
           double v = 1  * OI.armStick.getY();
       /* }else if(LiftSubsystem.getBaseLimit()){
            v = -20;
        }else if(LiftSubsystem.getTopLimit()){
            v = 20;
        }*/

        Robot.liftSubsystem.moveArm(v);     

    }
    

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        Logger.Log("LiftCommand Finished"); 
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        Logger.Log("LiftCommand Ended");
    	//Robot.liftSubsystem.moveArm(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        Logger.Log("LiftCommand INTERRUPTED");
    	//Robot.liftSubsystem.moveArm(0);
    }
}