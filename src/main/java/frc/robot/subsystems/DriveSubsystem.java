package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogGyro;

public class DriveSubsystem extends Subsystem {
  

  /* 
   * NOTICE: Using the NetworkTable
   * ==============================
   *
   * If you want to store data in the NetworkTable, you need to use a
   * NetworkTableEntry. These objects work like key-pair values. To get an
   * entry, call table.getEntry(String key).setValue(Object obj). The key
   * should be the name of the information being stored. The obj in setValue()
   * can be any object or primitive variable.
   *
   * Ex: table.getEntry("speed").setValue(42);
   *
   * To later retrieve this value (in any subsystem!), use
   * table.getEntry.getDouble() or the appropriate type method eg
   * getBoolean(). Note: you must pass a default value that will be returned
   * in case the key doesn't exist or other errors occur. I recommend passing
   * 0 when in doubt.
   *
   * Ex: double myVelocity = table.getDefault("speed").getDouble(0);
   *
   * The above gets the stored value and stores it into myVelocity.
   * If you want to use a custom data object (don't do this unless you know what
   * you're doing), call getValue().getValue() and cast to the appropriate type.
   */

  //initialize the NetworkTable and store a reference to it in table
  private NetworkTableInstance table;

  public DriveSubsystem() {
    table = NetworkTableInstance.getDefault();
  }

  @Override
  public void initDefaultCommand() {
  }
}
