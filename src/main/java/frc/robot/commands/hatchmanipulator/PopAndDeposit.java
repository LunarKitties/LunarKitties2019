/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.hatchmanipulator;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;

/**
 * Add your docs here.
 */
public class PopAndDeposit extends InstantCommand {
  /**
   * Add your docs here.
   */
  public PopAndDeposit() {
    super();
    // Use requires() here to declare subsystem dependencies
    requires(Robot.mHatchManipulator);
  }

  // Called once when the command executes
  @Override
  protected void initialize() {
    Robot.mHatchManipulator.clampHatch();
    Robot.mHatchManipulator.pop();

  }

}