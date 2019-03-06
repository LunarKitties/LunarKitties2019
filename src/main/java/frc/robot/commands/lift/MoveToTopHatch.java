/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.lift;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.subsystems.Lift;

public class MoveToTopHatch extends Command {
  boolean rising = false;

  public MoveToTopHatch() {
    requires(Robot.mLift);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.mLift.disengagebrake();
    SmartDashboard.putData(this);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    /*
      Robot.mLift.run(1);
      rising = true;
      Robot.mCameraHandler.setCameraPosition(RobotMap.TOP_ROCKET_ANGlE);
      */

    
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    /*
    if(rising)
    {
      if(Robot.mLift.getLiftHeight() >= Lift.TOP_HEIGHT) {
          Robot.mLift.engageBrake();
          Robot.mLift.stop();
          return true;
      } else {
          return false;
      }
    } else {
        if(Robot.mLift.getLiftHeight() <= Lift.TOP_HEIGHT) {
          Robot.mLift.engageBrake();
          Robot.mLift.stop();
          return true;
        } else {
          return false;
        }
    }
    */
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.mLift.stop();
    Robot.mLift.engageBrake();
    Robot.mCameraHandler.setCameraPosition(RobotMap.TOP_ROCKET_ANGLE);

  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.mLift.stop();
  }
}
