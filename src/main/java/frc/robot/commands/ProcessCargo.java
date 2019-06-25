/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.commands.accumulator.AccumulateCargo;
import frc.robot.commands.lift.MoveLiftToBottom;
import frc.robot.commands.tilt.RaiseTiltToTop;
import frc.robot.commands.tilt.SetTiltLatch;
import frc.robot.subsystems.LEDS;
public class ProcessCargo extends CommandGroup {
  /**
   * Run the accumulator using the triggers.
   * Once a ball is grabbed, the accumulator will stop
   * Then the lift will rise to the "Bottom" level
   * Then the tilt will be raised all the way up ready to score.
   */
  public ProcessCargo() {
    Robot.processingCargo = true;
    SmartDashboard.putBoolean("Processing Cargo", Robot.processingCargo);
    addSequential(new AccumulateCargo(),3);
    addSequential(new WaitCommand(.5));
    addSequential(new MoveLiftToBottom(),3);
    addSequential(new RaiseTiltToTop(),3);  
    addParallel(new SetTiltLatch(),1);  
    SmartDashboard.putBoolean("Processing Cargo", Robot.processingCargo);
  }

}
