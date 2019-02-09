package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.RobotMap;

// Sets the arm to the very top

public class LiftToTopCommand extends Command {

    public LiftToTopCommand() {
    }

    protected void initialize() {
    }

    protected void execute() {
    	RobotMap.setPoint = -3600;
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}