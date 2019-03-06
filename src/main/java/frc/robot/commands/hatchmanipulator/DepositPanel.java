/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.hatchmanipulator;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class DepositPanel extends Command {
  boolean done = false;
  boolean running = false;


  public DepositPanel() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.mHatchManipulator);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    done = false;
    running = false;

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.mHatchManipulator.pop();
    if(Robot.mHatchManipulator.isTouching() && !running)
    {       
      running = true;
      new Thread()
      {
        public void run()
        {
          if(running) {
          try{
            Thread.sleep(50);
            Robot.mHatchManipulator.releaseHatch();
            Robot.mHatchManipulator.retract();
            } catch(Exception ex){
            System.err.println("Took to long to get panel!");
          }
          done = true;
          running = false;

          return;
        } else {
          done = true;
          running = false;
          return;
        }
        }
      }.start();
    }
    }
  

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return done;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    done = false;
    running = false;
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    SmartDashboard.putString("Deposit Panel Status", "Interrupted");

    done = false;
    running = false;
  }
}
