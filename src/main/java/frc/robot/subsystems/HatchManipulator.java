/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Controls the Hatch Manipulator of the Robot
 */
public class HatchManipulator extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  DoubleSolenoid clamp = new DoubleSolenoid(RobotMap.PCM_HATCH_CLAMP_IN, RobotMap.PCM_HATCH_CLAMP_OUT);
  DoubleSolenoid popper = new DoubleSolenoid(RobotMap.PCM_HATCH_CLAMP_IN, RobotMap.PCM_HATCH_CLAMP_OUT);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
  }

  /**
   * Grabs the Hatch Panel
   */
  public void clampHatch()
  {
    clamp.set(Value.kForward);
  }

  /**
   * Releases the Hatch Panel
   */
  public void releaseHatch()
  {
    clamp.set(Value.kReverse);
  }

  /**
   * Pops out the Popper
   * Does Magic stuff
   */
  public void pop()
  {
    clamp.set(Value.kForward);
  }

  /**
   * Retracts/Pulls back the Popper
   */
  public void retract()
  {
    clamp.set(Value.kReverse);
  }



}
