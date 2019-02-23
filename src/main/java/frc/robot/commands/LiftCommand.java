package frc.robot.commands;
import frc.robot.OI;
import frc.robot.OI.Axis;
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
    	double leftY = OI.getJoystickAxis(RobotMap.XBOX_CONTROLLER, Axis.LeftY);
    	if (leftY != 0) {
    		if(RobotMap.liftSetPoint <0 || (RobotMap.liftSetPoint >= 0 && leftY < 0)) {
    			RobotMap.liftSetPoint += (int) leftY * 80;
    			Robot.liftSubsystem.setPos(RobotMap.liftSetPoint);
    	} else {
    		RobotMap.liftSetPoint = 0;
    		Robot.liftSubsystem.setPos(RobotMap.liftSetPoint);
    	}
    } else {
    	Robot.liftSubsystem.setPos(RobotMap.liftSetPoint);
    	}
    }
    

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.liftSubsystem.set(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.liftSubsystem.set(0);
    }
}
