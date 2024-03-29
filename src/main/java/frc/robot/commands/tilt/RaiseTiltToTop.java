/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.tilt;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**
 * Raise the tilt to the top and stop
 */
public class RaiseTiltToTop extends Command {
  public RaiseTiltToTop() {

    requires(Robot.mTilt);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.mTilt.unlatch();
    Robot.mTilt.run(1);

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.mTilt.unlatch();
    Robot.mTilt.run(.75);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return Robot.mTilt.isAtTop();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.mTilt.stop();
    Robot.processingCargo = false;
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.mTilt.stop();
    Robot.processingCargo = false;
  }
}
