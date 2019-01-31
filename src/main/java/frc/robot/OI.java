package frc.robot;

import edu.wpi.first.wpilibj.Joystick;

public class OI {
  // Makes the axis of the joystick exist

  public static enum Axis {X, Y, Z, LeftY, RightY, THROTTLE, RightTab};

  // Makes the joystick and xbox controller exist

  private static Joystick driveStick = new Joystick(RobotMap.DRIVE_STICK);
  private static Joystick xBoxController = new Joystick(RobotMap.XBOX_CONTROLLER);

  public static double getJoystickAxis(int joystickID, Axis axis) {

      // Establishes the joystick and its axes

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
          axisValue = joystick.getRawAxis(1); // 2 is supposed to be XBox id for left joystick
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

      return axisValue;
  }
}
