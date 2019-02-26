/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.commands.lift.OperateLift;

/**
 * The Lift Subsystem.
 * Provides functions to control the lift on the robot
 */
public class Lift extends Subsystem {
  
  Spark tlMotor = new Spark(RobotMap.PWM_LIFT_TL);
  Spark trMotor = new Spark(RobotMap.PWM_LIFT_TR);
  Spark blMotor = new Spark(RobotMap.PWM_LIFT_BL);
  Spark brMotor = new Spark(RobotMap.PWM_LIFT_BR);

  AnalogInput liftPot = new AnalogInput(RobotMap.AI_LIFT_POT);

  DoubleSolenoid discBrake = new DoubleSolenoid(RobotMap.PCM_BRAKE_IN, RobotMap.PCM_BRAKE_OUT);

  SpeedControllerGroup liftMotors = new SpeedControllerGroup(tlMotor, trMotor, blMotor, brMotor);
  
  /*
  * 
Hatch Pot Heights
* height-3.12
* mid-2.2
* low-.98
*/
  public static final double TOP_HEIGHT = 0.0;
  public static final double MID_HEIGHT = 0.0;
  public static final double BOT_HEIGHT = 0.0;

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new OperateLift());
  }

  public void log()
  {
    SmartDashboard.putNumber("Potentiometer", liftPot.getVoltage());
    SmartDashboard.putNumber("Potentiometer AVG", liftPot.getAverageVoltage());
    SmartDashboard.putBoolean("Brake Engaged", (discBrake.get() == Value.kForward));
  }

  /**
   * Control the lift by passing in a power input
   * @param speed Value between -1 and 1 to raise/lower the lift
   */
  public void run(double speed) {
    liftMotors.set(speed);
  }

  /**
   * Push in the disc brake to prevent the lift from moving
   */
  public void engageBrake()
  {
    discBrake.set(Value.kForward);
  }

  /**
   * Release the disc brake to allow the lift to move.
   */
  public void disengagebrake()
  {
    discBrake.set(Value.kOff);
  }

  /**
   * Stops the Lift
   */
  public void stop() {
    liftMotors.stopMotor();
  }

  /**
   * Returns if the brake is engaged
   */
  public boolean brakeEngaged()
  {
    return discBrake.get() == Value.kForward;
  }

  public double getLiftHeight()
  {
    return liftPot.getAverageVoltage();
  }
}
