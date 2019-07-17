package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.*;
import frc.robot.commands.GrabCommand;
import frc.robot.commands.CloseValve;

public class OI {

  public static enum Axis {X, Y, Z, LeftY, RightY, THROTTLE, RightTab};

  public static Joystick driveStick;
  public static Joystick armStick;
    
  private static JoystickButton grabButton;
    private static JoystickButton pushButton;
    private static JoystickButton breakButton;
    // private static JoystickButton driveEnableButton;
    // private static JoystickButton driveDisableButton;

    public OI(){
    driveStick = new Joystick(RobotMap.DRIVE_STICK);
    armStick = new Joystick(RobotMap.ARM_STICK);
    assoc();  
  }

  private void assoc(){
    grabButton = new JoystickButton(armStick, 1);
    pushButton = new JoystickButton(armStick, 3);
    breakButton = new JoystickButton(armStick, 2);
    // driveDisableButton = new JoystickButton(driveStick, 7);
    // driveEnableButton = new JoystickButton(driveStick, 8);

    actions();
  }

  private void actions(){    
    grabButton.whileHeld(new GrabCommand());
    grabButton.whenReleased(new CloseValve());

    pushButton.whileHeld(new ExtendCommand());

    breakButton.whileHeld(new ReleaseBreakCommand());
    breakButton.whenReleased(new BreakCommand());

    // driveDisableButton.whenPressed(new DriveCommand(false));
    // driveEnableButton.whenPressed(new DriveCommand(true));

}

  public static void getJoystickAxis(int joystickID, Axis axis) {

      Joystick joystick;

     //double axisValue = 0;

      /*if (joystickID == RobotMap.DRIVE_STICK {
          joystick = driveStick;
      } else if (joystickID == RobotMap.XBOX_CONTROLLER) {
        joystick = xBoxController;
      } else {
          return 0;
      }

      if (axis == Axis.X) {
          axisValue = joystick.getX();
      } else if (axis == Axis.Y) {
          axisValue = joystick.getY();
      } else if (axis == Axis.Z) {
          axisValue = joystick.getZ();
      } else if (axis == Axis.LeftY) {
          axisValue = joystick.getRawAxis(1); // 1 is supposed to be XBox id for left joystick
      } else if (axis == Axis.RightY) {
          axisValue = joystick.getRawAxis(5); // 5 is supposed to be XBox id for right joystick
      } else if (axis == Axis.THROTTLE) {
          axisValue = joystick.getThrottle();
      }else if (axis == Axis.RightTab) {
        axisValue = joystick.getRawAxis(3);
    }

      // Creates dead zone
      if (Math.abs(axisValue) < .1) {
          axisValue = 0;
      }

      return axisValue; */
  }
}
