/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.tilt.OperateTilt;

/**
 * Operates the tilt of arm
 */
public class Tilt extends Subsystem {
  
  private VictorSPX tilt = new VictorSPX(RobotMap.CAN_TILT);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new OperateTilt());
  }

  /**
   * Runs the tilt motors
   * @param power Double value between -1 and 1
   */
  public void run(double power)
  {
    tilt.set(ControlMode.PercentOutput, power);
  }

  /**
   * Stops the Tilt Motor
   */
  public void stop()
  {
    tilt.set(ControlMode.PercentOutput, 0);
  }
}
