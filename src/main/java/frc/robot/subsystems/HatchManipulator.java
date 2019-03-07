/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInLayouts;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardLayout;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.commands.hatchmanipulator.MonitorHatch;

/**
 * Controls the Hatch Manipulator of the Robot
 */
public class HatchManipulator extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  DoubleSolenoid clamp = new DoubleSolenoid(RobotMap.PCM_HATCH_CLAMP_IN, RobotMap.PCM_HATCH_CLAMP_OUT);
  DoubleSolenoid popper = new DoubleSolenoid(RobotMap.PCM_HATCH_IN, RobotMap.PCM_HATCH_OUT);
  DigitalInput panelSwitch = new DigitalInput(RobotMap.DIO_HATCH_PANEL_SWITCH);

  boolean panelPossessed = false;
  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new MonitorHatch());
  }


  /**
   * Grabs the Hatch Panel
   */
  public void clampHatch()
  {
    clamp.set(Value.kReverse);
    panelPossessed = true;
  }

  /**
   * Releases the Hatch Panel
   */
  public void releaseHatch()
  {
    clamp.set(Value.kForward);
    panelPossessed = false;

  }

  /**
   * Pops out the Popper
   * Does Magic stuff
   */
  public void pop()
  {
    popper.set(Value.kForward);
  }

  /**
   * Retracts/Pulls back the Popper
   */
  public void retract()
  {
    popper.set(Value.kReverse);
  }

  public boolean isTouching()
  {
    return !panelSwitch.get();
  }
  public void log()
  {
    ShuffleboardTab mainTab =  Shuffleboard.getTab("Main");
    mainTab.getLayout("Primary", BuiltInLayouts.kList)
    .withPosition(0, 0)
    .withSize(2, 2)
    .add("Have Panel", havePanel());
    
    ShuffleboardLayout hatchLayout = mainTab.getLayout("Hatch Manipulator", BuiltInLayouts.kList).withSize(2, 3);

    hatchLayout.add("Popper Out", isPopped());
    hatchLayout.add("Clamped", isClamped());
    hatchLayout.add("Touching Hatch", isTouching());


    // SmartDashboard.putBoolean("Touching Hatch", isTouching());
    // SmartDashboard.putBoolean("Popper Out", popper.get() == Value.kForward);
    // SmartDashboard.putBoolean("Clamped", clamp.get() == Value.kReverse);
    // SmartDashboard.putBoolean("Have Panel", havePanel());
  }

  public boolean havePanel()
  {
    return panelPossessed;
  }

  public boolean isPopped()
  {
    return popper.get() == Value.kForward;
  }

  public boolean isClamped()
  {
    return clamp.get() == Value.kReverse;
  }



}
