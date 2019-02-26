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
  TalonSRX rightClimber = new TalonSRX(RobotMap.CAN_R_CLIMBER);
  TalonSRX leftClimber = new TalonSRX(RobotMap.CAN_L_CLIMBER);

  boolean latched = true;

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new OperateClimber());
  }

  public void movePivot(double speed)
  {
    pivotMotor.set(ControlMode.PercentOutput, speed);
  }

  public void moveWheels(double speed)
  {
    rightClimber.set(ControlMode.PercentOutput, speed);
    leftClimber.follow(rightClimber);
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
    SmartDashboard.putNumber("Left Climber Wheels", leftClimber.getMotorOutputPercent());
    SmartDashboard.putNumber("Right Climber Wheels", rightClimber.getMotorOutputPercent());
    SmartDashboard.putNumber("Climber Pivot", pivotMotor.getMotorOutputPercent());
  }
}
