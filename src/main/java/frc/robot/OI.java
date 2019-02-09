package frc.robot;

import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.ExtendCommand;
import frc.robot.commands.GrabCommand;
import frc.robot.commands.ReleaseCommand;
import frc.robot.commands.ClimbCommand;
import frc.robot.commands.PositionAdjustCommandGroup;

public class OI {

  public static enum Axis {X, Y, Z, LeftY, RightY, THROTTLE};

  private static Joystick driveStick = new Joystick(RobotMap.DRIVE_STICK);
  private static Joystick xBoxController = new Joystick(RobotMap.XBOX_CONTROLLER);

  public static double getJoystickAxis(int joystickID, Axis axis) {

      Joystick joystick;

      double axisValue = 0;

      if (joystickID == RobotMap.DRIVE_STICK) {
          joystick = driveStick;
      } else if (joystickID == RobotMap.XBOX_CONTROLLER) {
          joystick = xBoxController;
      } else {
          System.out.println("Wrong id");
          return 0;
      }

      if (axis == Axis.X) {
          axisValue = joystick.getX();
      } else if (axis == Axis.Y) {
          axisValue = joystick.getY();
      } else if (axis == Axis.Z) {
          axisValue = joystick.getZ();
      } else if (axis == Axis.LeftY) {
          axisValue = joystick.getRawAxis(1);
      } else if (axis == Axis.RightY) {
          axisValue = joystick.getRawAxis(5);
      } else if (axis == Axis.THROTTLE) {
          axisValue = joystick.getThrottle();
      }

      if (Math.abs(axisValue) < .2) {
          axisValue = 0;
      }
 
      return axisValue;
  }
    

    public static JoystickButton AButton = new JoystickButton(xBoxController, 0);
    public static JoystickButton BButton = new JoystickButton(xBoxController, 1);
    public static JoystickButton XButton = new JoystickButton(xBoxController, 2);
    public static JoystickButton YButton = new JoystickButton(xBoxController, 3);

    public static JoystickButton leftBumper = new JoystickButton(xBoxController, 4);
    public static JoystickButton rightBumper = new JoystickButton(xBoxController, 5);

    public static JoystickButton backButton = new JoystickButton(xBoxController, 6);
    public static JoystickButton startButton = new JoystickButton(xBoxController, 7);

    public static JoystickButton pressLStick = new JoystickButton(xBoxController, 8);
    public static JoystickButton pressRStick = new JoystickButton(xBoxController, 9);

    public static JoystickButton trigger = new JoystickButton(driveStick, 1);
    public static JoystickButton button2 = new JoystickButton(driveStick, 2);

  public OI(){
    BButton.toggleWhenPressed(new ExtendCommand());

    leftBumper.whileHeld(new ReleaseCommand());
   
    rightBumper.whileHeld(new GrabCommand());

    trigger.whenPressed(new PositionAdjustCommandGroup());

    button2.whenPressed(new ClimbCommand());
  }
}
