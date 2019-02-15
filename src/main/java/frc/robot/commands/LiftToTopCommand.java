package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Logger;
import frc.robot.RobotMap;

// Sets the arm to the very top

public class LiftToTopCommand extends Command {

    public LiftToTopCommand() {
        Logger.Log("Lift to top constructed.");
    }

    protected void initialize() {
        Logger.Log("Lift to top initialized.");
    }

    protected void execute() {
        RobotMap.setPoint = -3600;
        Logger.Log("Lift to top executed.");
    }

    protected boolean isFinished() {
        Logger.Log("Lift to top finished.");
        return true;
    }

    protected void end() {
        Logger.Log("Lift to top ended.");
    }

    protected void interrupted() {
        Logger.Log("Lift to top interrupted.");
    }
}