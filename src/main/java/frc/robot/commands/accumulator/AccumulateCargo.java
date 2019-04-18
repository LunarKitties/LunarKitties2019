/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.accumulator;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class AccumulateCargo extends Command {
  public AccumulateCargo() {
    requires(Robot.mAccumulator);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.processingCargo = true;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
        Robot.mAccumulator.run(1);

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return Robot.mAccumulator.ballGrabbed();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.mAccumulator.stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.mAccumulator.stop();
  }
}
