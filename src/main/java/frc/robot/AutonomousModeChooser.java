package frc.robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import frc.robot.commands.AutonomousSandstormCommand;

public class AutonomousModeChooser {

  private SendableChooser<Command> autonomousCommandDropdown;

  public AutonomousModeChooser(SendableChooser<Command> dropdown){
    this.autonomousCommandDropdown = dropdown;
  }

  public void setup() {
    //do we need this?
    autonomousCommandDropdown.setDefaultOption("Cross Line: Tier 1", new AutonomousSandstormCommand(AutonomousSandstormCommand.StartLocation.leftTier1, AutonomousSandstormCommand.Task.crossline));


    autonomousCommandDropdown.addOption("Left Cargo: Tier 1", new AutonomousSandstormCommand(AutonomousSandstormCommand.StartLocation.leftTier1, AutonomousSandstormCommand.Task.cargo));
    autonomousCommandDropdown.addOption("Left Cargo: Tier 2", new AutonomousSandstormCommand(AutonomousSandstormCommand.StartLocation.leftTier2, AutonomousSandstormCommand.Task.cargo));
    autonomousCommandDropdown.addOption("Middle Cargo",  new AutonomousSandstormCommand(AutonomousSandstormCommand.StartLocation.leftTier2, AutonomousSandstormCommand.Task.cargo));
    autonomousCommandDropdown.addOption("Right Cargo: Tier 1",  new AutonomousSandstormCommand(AutonomousSandstormCommand.StartLocation.rightTier1, AutonomousSandstormCommand.Task.cargo));
    autonomousCommandDropdown.addOption("Right Cargo: Tier 2", new AutonomousSandstormCommand(AutonomousSandstormCommand.StartLocation.rightTier2, AutonomousSandstormCommand.Task.cargo));

    autonomousCommandDropdown.addOption("Left Rocket: Tier 1", new AutonomousSandstormCommand(AutonomousSandstormCommand.StartLocation.leftTier1, AutonomousSandstormCommand.Task.rocket));
    autonomousCommandDropdown.addOption("Left Rocket: Tier 2", new AutonomousSandstormCommand(AutonomousSandstormCommand.StartLocation.leftTier2, AutonomousSandstormCommand.Task.rocket));
    autonomousCommandDropdown.addOption("Middle Rocket",  new AutonomousSandstormCommand(AutonomousSandstormCommand.StartLocation.middleTier1, AutonomousSandstormCommand.Task.rocket));
    autonomousCommandDropdown.addOption("Right Rocket: Tier 1", new AutonomousSandstormCommand(AutonomousSandstormCommand.StartLocation.rightTier1, AutonomousSandstormCommand.Task.rocket));
    autonomousCommandDropdown.addOption("Right Rocket: Tier 2", new AutonomousSandstormCommand(AutonomousSandstormCommand.StartLocation.rightTier2, AutonomousSandstormCommand.Task.rocket));

    autonomousCommandDropdown.addOption("Cross Line: Tier 2", new AutonomousSandstormCommand(AutonomousSandstormCommand.StartLocation.leftTier2, AutonomousSandstormCommand.Task.crossline));
  }

}
