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
import frc.robot.commands.turret.OperateTurret;

/**
 * The Turret Subsystem. Provides functions for
 * controlling it.
 */
public class Turret extends Subsystem {
  
  Spark turretMotor = new Spark(RobotMap.PWM_TURRET);
  
  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new OperateTurret());
  }

  /**
   * Rotate the turret 
   * @param speed Value between -1 and 1 to move the turret
   */
  public void rotate(double speed) {
    turretMotor.set(speed);
  }

  /**
   * Stop the turret
   */
  public void stop() {
    turretMotor.stopMotor();
  }
}
