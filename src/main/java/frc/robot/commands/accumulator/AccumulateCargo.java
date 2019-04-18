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
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
        //Get Controller 2
        XboxController xbox = Robot.m_oi.getXboxController2();

        //Speed is based on the triggers. Left Trigger is reverse, Right Trigger is forward
        double rt = xbox.getTriggerAxis(Hand.kRight);
        Robot.mAccumulator.run(rt);

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
