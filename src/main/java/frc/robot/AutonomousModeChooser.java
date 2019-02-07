package frc.robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.SandStormCommandGroup;

public class AutonomousModeChooser {

  private SendableChooser<Command> autonomousCommandDropdown;

  public AutonomousModeChooser(SendableChooser<Command> dropdown){
    this.autonomousCommandDropdown = dropdown;
  }

  public void setup() {
    //do we need this?
    //autonomousCommandDropdown.setDefaultOption("Default Auto", new DriveCommand());
    // TODO change to the actual right Command
    autonomousCommandDropdown.setDefaultOption("Left Cargo: Tier 1", new SandStormCommandGroup());
    autonomousCommandDropdown.addOption("Left Cargo: Tier 2", new SandStormCommandGroup());
    autonomousCommandDropdown.addOption("Middle Cargo", new SandStormCommandGroup());
    autonomousCommandDropdown.addOption("Right Cargo: Tier 1", new SandStormCommandGroup());
    autonomousCommandDropdown.addOption("Right Cargo: Tier 2", new SandStormCommandGroup());

    autonomousCommandDropdown.addOption("Left Rocket: Tier 1", new SandStormCommandGroup());
    autonomousCommandDropdown.addOption("Left Rocket: Tier 2", new SandStormCommandGroup());
    autonomousCommandDropdown.addOption("Middle Cargo", new SandStormCommandGroup());
    autonomousCommandDropdown.addOption("Right Rocket: Tier 1", new SandStormCommandGroup());
    autonomousCommandDropdown.addOption("Right Rocket: Tier 2", new SandStormCommandGroup());

    autonomousCommandDropdown.addOption("Cross Line: Tier 1", new SandStormCommandGroup());
    autonomousCommandDropdown.addOption("Cross Line: Tier 2", new SandStormCommandGroup());
  }

}
