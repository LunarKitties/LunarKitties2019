/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class LEDS extends Subsystem {

  // Put methods for controlling this subsystem
  // here. Call these from Commands.
Spark ledDriver = new Spark(RobotMap.PWM_BLINKIN);

public static final double RAINBOW = -0.99;
public static final double STROBE_GOLD = -0.07;
//-0.31
public static final double CHASE_RED = -0.31;
public static final double SPECIAL_CHASE = .45;
public static final double SLOW_BREATHE_COLOR2 = 0.29;
public static final double BPM_RAINBOW = -0.69;
  public void initDefaultCommand() {
      // Set the default command for a subsystem here.
      //setDefaultCommand(new MySpecialCommand());
    //setDefaultCommand(new MonitorLEDS());
  }
  
  public void setColor(double color)
  {
    ledDriver.set(color);
  }
}