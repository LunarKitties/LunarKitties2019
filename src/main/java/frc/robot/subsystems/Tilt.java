/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.commands.tilt.OperateTilt;

/**
 * Operates the tilt of arm
 */
public class Tilt extends Subsystem {
  
  private VictorSPX tilt = new VictorSPX(RobotMap.CAN_TILT);
  private Counter tiltCounter = new Counter(RobotMap.DIO_TILT_COUNTER);
  private DigitalInput tiltSwitch = new DigitalInput(RobotMap.DIO_TILT_SWITCH);
  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new OperateTilt());
  }

  /**
   * Puts data on SmartDashboard
   */
  public void log()
  {
    SmartDashboard.putNumber("Tilt Counter", tiltCounter.get());
    SmartDashboard.putBoolean("At Top", isAtTop());
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
   * Checks to see if the Tilt is at the top
   */
  public boolean isAtTop()
  {
    return !tiltSwitch.get();
  }

  public void resetCounter()
  {
    tiltCounter.reset();
  }
  /**
   * Get Counter
   */
  public int getAngle()
  {
    return tiltCounter.get();
  }
  /**
   * Stops the Tilt Motor
   */
  public void stop()
  {
    tilt.set(ControlMode.PercentOutput, 0);
  }
}
