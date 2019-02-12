/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.lift.OperateLift;

/**
 * Operates the tilt of arm
 */
public class Tilt extends Subsystem {
  
  private TalonSRX leftTilt = new TalonSRX(RobotMap.CAN_LEFT_TILT);
  private TalonSRX rightTilt = new TalonSRX(RobotMap.CAN_RIGHt_TILT);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new OperateLift());
  }

  /**
   * Runs the tilt motors
   * @param power Double value between -1 and 1
   */
  public void run(double power)
  {
    leftTilt.set(ControlMode.PercentOutput, power);
    rightTilt.follow(leftTilt);
  }

  /**
   * Stops the Tilt Motor
   */
  public void stop()
  {
    leftTilt.set(ControlMode.PercentOutput, 0);
    rightTilt.set(ControlMode.PercentOutput,0);
  }
}
