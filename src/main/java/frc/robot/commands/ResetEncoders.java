package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ResetEncoders extends Command {
    public ResetEncoders() {
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.liftSubsystem.resetEncoder();
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}