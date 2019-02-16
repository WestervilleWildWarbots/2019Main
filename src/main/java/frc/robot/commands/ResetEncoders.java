package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Logger;
import frc.robot.Robot;

public class ResetEncoders extends Command {
    public ResetEncoders() {
        Logger.Log("Release encoders constructed");
    }

    protected void initialize() {
        Logger.Log("Release encoders initialized.");
    }

    protected void execute() {
        Robot.liftSubsystem.resetEncoder();
        Logger.Log("Release encoders executed.");
    }

    protected boolean isFinished() {
        Logger.Log("Release encoders finished.");
        return true;
    }

    protected void end() {
        Logger.Log("Release encoders ended.");
    }

    protected void interrupted() {
        Logger.Log("Release encoders interrupted.");
    }
}