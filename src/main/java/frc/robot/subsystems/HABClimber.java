/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.commands.hab.OperateClimber;

/**
 * Controls the HAB Climber part of the robot
 */
public class HABClimber extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  TalonSRX pivotMotor = new TalonSRX(RobotMap.CAN_CLIMBER_PIVOT);
  DoubleSolenoid stepOne = new DoubleSolenoid(RobotMap.PCM_JACK_ONE_IN, RobotMap.PCM_JACK_ONE_OUT);
  DoubleSolenoid stepTwo = new DoubleSolenoid(RobotMap.PCM_JACK_TWO_IN, RobotMap.PCM_JACK_TWO_OUT);
  boolean latched = true;

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
   setDefaultCommand(new OperateClimber());
  }


  public void popStepOneOut()
  {
    stepOne.set(Value.kForward);
  }

  public void popStepTwoOut()
  {
    stepTwo.set(Value.kForward);
  }

  public void pullStepOneIn()
  {
    stepOne.set(Value.kReverse);
  }

  public void pullStepTwoIn()
  {
    stepTwo.set(Value.kReverse);;
  }

  public void movePivot(double speed)
  {
    pivotMotor.set(ControlMode.PercentOutput, speed);
  }


  public void unlatch()
  {
    latched = false;
  }

  public void latch()
  {
    latched = true;
  }

  public void toggleLatch()
  {
    latched = !latched;
  }

  public boolean isLatched()
  {
    return latched;
  }

  public void log()
  {
      SmartDashboard.putNumber("Climber Pivot", pivotMotor.getMotorOutputPercent());
  }
}
