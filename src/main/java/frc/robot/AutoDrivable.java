package frc.robot;

public interface AutoDrivable {
  public void autoDrive(double feet);
  public void turnToHeading(double angleInDegrees);
  public void stop();
}
