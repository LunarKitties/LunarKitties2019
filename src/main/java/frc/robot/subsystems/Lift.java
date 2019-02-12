/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
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

  DoubleSolenoid shifters = new DoubleSolenoid(RobotMap.PCM_LIFT_S_IN, RobotMap.PCM_LIFT_S_OUT);

  SpeedControllerGroup liftMotors = new SpeedControllerGroup(tlMotor, trMotor,blMotor,brMotor);
  

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new OperateLift());
  }

  /**
   * Control the lift by passing in a power input
   * @param speed Value between -1 and 1 to raise/lower the lift
   */
  public void run(double speed) {
    liftMotors.set(speed);
  }

  /**
   * Shift to high gear
   */
  public void shiftHigh()
  {
    shifters.set(Value.kForward);
  }

  /**
   * Shift to low gear
   */
  public void shiftLow()
  {
    shifters.set(Value.kReverse);
  }
  /**
   * Stops the Lift
   */
  public void stop() {
    liftMotors.stopMotor();
  }
}
