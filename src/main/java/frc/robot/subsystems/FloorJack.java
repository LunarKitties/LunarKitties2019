/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.floorjack.OperateJack;

/**
 * Add your docs here.
 */
public class FloorJack extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  TalonSRX jack = new TalonSRX(RobotMap.CAN_JACK);
  DigitalInput topSensor = new DigitalInput(RobotMap.DIO_JACK_TOP_SWITCH);
  DigitalInput bottomSensor = new DigitalInput(RobotMap.DIO_JACK_BOTTOM_SWITCH);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new OperateJack());
  }

  public FloorJack()
  {
    jack.setInverted(InvertType.InvertMotorOutput);
  }
  public void log()
  {
    SmartDashboard.putBoolean("Jack Top", topSensor.get());
    SmartDashboard.putBoolean("Jack Bottom", bottomSensor.get());
  }

  public void run(double speed)
  {
    jack.set(ControlMode.PercentOutput, speed);
  }

  public void stop()
  {
    jack.set(ControlMode.PercentOutput, 0);
    Robot.mLeds.setColor(LEDS.STROBE_RED);
  }

  public boolean atTop()
  {
    return !topSensor.get();
  }

  public boolean atBottom()
  {
    return !bottomSensor.get();
  }

}
