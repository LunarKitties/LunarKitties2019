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
import edu.wpi.first.wpilibj.GenericHID.Hand;

public class OperateLift extends Command {
  public OperateLift() {
    requires(Robot.mLift);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    double liftSpeed = -Robot.m_oi.getXboxController2().getY(Hand.kLeft);
    SmartDashboard.putNumber("Lift Speed", liftSpeed);
    double cameraSpeed = 0;
    
    /*if(liftSpeed < 0) // Lowering
    		cameraSpeed = -liftSpeed * .02; //Lift comes down faster
    	else //Raising
    		cameraSpeed = -liftSpeed *.004; //Move the camera slightly
    	
    	Robot.mCameraHandler.adjustCameraPosition(cameraSpeed); //Adjust the camera while operating lift
      
     */ 
    Robot.mLift.run(liftSpeed);
    if(Robot.mLift.atBottom())
    {
      Robot.mCameraHandler.setCameraPosition(RobotMap.BOTTOM_ANGLE);
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.mLift.stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
