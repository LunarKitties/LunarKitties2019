/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.tilt;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class OperateTilt extends Command {
  public OperateTilt() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.mTilt);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double speed = -Robot.m_oi.getXboxController2().getY(Hand.kRight);
    SmartDashboard.putNumber("Tilt Speed", speed);

    //If the Tilt Latch is set, keep the tilt up.
    if(Robot.mTilt.isLatched())
    {
      if(speed < -0.2)
      {
        Robot.mTilt.unlatch();
      }

      //Check to see if the tilt is triggering the switch
      //We want to make sure that we're not trying to lower down.
      //If we are, we need to unlatch
      if(!Robot.mTilt.isAtTop() && !(speed < -0.2))
      {
        //If Not, set the speed to tilt up by .5 (half power) 
        speed = 1;
      } 
      
    }

    //We can only move the lift if the speed is negative (lower tilt)
    // or whenever the robot isn't at the top. This is to prevent burning motors
   if(speed < -.20 || !Robot.mTilt.isAtTop())
      Robot.mTilt.run(speed);
    else
      Robot.mTilt.stop();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.mTilt.stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
