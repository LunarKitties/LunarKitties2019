/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.lift;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.subsystems.Lift;

public class MoveLiftToMid extends Command {
  boolean rising = false;

  public MoveLiftToMid() {
    requires(Robot.mLift);
  }

  @Override
  protected void initialize() {
    Robot.mLift.disengagebrake();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    // if(Robot.mLift.getLiftHeight() >= Lift.MID_HEIGHT) {
    //   Robot.mLift.run(-0.5); 
    //   rising = false;
    // } else
    // {
      Robot.mLift.run(1);
      rising = true;
   // }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if(rising)
    {
      if(Robot.mLift.getLiftHeight() >= Lift.MID_HEIGHT) {
          Robot.mLift.engageBrake();
          Robot.mLift.stop();
          return true;
      } else {
          return false;
      }
    } else {
        if(Robot.mLift.getLiftHeight() <= Lift.MID_HEIGHT) {
          Robot.mLift.engageBrake();
          Robot.mLift.stop();
          return true;
        } else {
          return false;
        }
    }
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.mLift.stop();
    Robot.mLift.engageBrake();
    Robot.mCameraHandler.setCameraPosition(RobotMap.MIDDLE_ROCKET_ANGLE);

  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.mLift.stop();
  }
}
