/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.commands.accumulator.OperateAccumulator;

/**
 * Accumulator Class. Handles the motors for the accumulator to intake
 * game elements. Does not handle tilt. The @Tilt class does
 */
public class Accumulator extends Subsystem {
  TalonSRX topAccum = new TalonSRX(RobotMap.CAN_TOP_ACCUMULATOR);
  TalonSRX bottomAccum = new TalonSRX(RobotMap.CAN_BOTTOM_ACCUMULATOR);
  DigitalInput grabSwitch = new DigitalInput(RobotMap.DIO_ACCUMULATOR_SWITCH);

  public Accumulator()
  {
    bottomAccum.setInverted(InvertType.OpposeMaster);
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new OperateAccumulator());
  }
  /**
   * Run the Accumulator
   * @param power A double value to control the accumulator. -1 to 1
   */
  public void run(double power){
    bottomAccum.follow(topAccum);
    topAccum.set(ControlMode.PercentOutput, power);
  }

  public void stop()
  {
    topAccum.set(ControlMode.PercentOutput, 0);
    bottomAccum.set(ControlMode.PercentOutput, 0);
  }

  public boolean ballGrabbed()
  {
    return !grabSwitch.get();
  }

  public void log()
  {
    SmartDashboard.putBoolean("Ball Grabbed", ballGrabbed());
  }
}
