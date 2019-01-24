/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.DriveWithController;

/**
 * Pretty Simple. It is the Drivetrain.
 * Control the Wheels as well as the shifters
 */
public class DriveTrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  //Create Motor Controller Objects based on CAN IDs
    CANSparkMax flMotor = new CANSparkMax(RobotMap.CAN_FL_DRIVE_MOTOR, MotorType.kBrushless);
    CANSparkMax blMotor = new CANSparkMax(RobotMap.CAN_BL_DRIVE_MOTOR, MotorType.kBrushless);     
    CANSparkMax frMotor = new CANSparkMax(RobotMap.CAN_FR_DRIVE_MOTOR, MotorType.kBrushless);
    CANSparkMax brMotor = new CANSparkMax(RobotMap.CAN_BR_DRIVE_MOTOR, MotorType.kBrushless);
  
  //Group the Left and Right Motors together
    SpeedControllerGroup leftWheels = new SpeedControllerGroup(flMotor, blMotor);
    SpeedControllerGroup rightWheels = new SpeedControllerGroup(frMotor, brMotor);
  
  //Create Differential Drive Object allowing us to drive the robot
    DifferentialDrive dd = new DifferentialDrive(leftWheels, rightWheels);

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new DriveWithController());
  }

  /**
   * Controls drivetrain using Xbox Controller
   * @param xbox XboxController Object
   */
  public void runWithController(XboxController xbox) {

    //Speed is based on the triggers. Left Trigger is reverse, Right Trigger is forward
    double lt = xbox.getTriggerAxis(Hand.kLeft);
    double rt = xbox.getTriggerAxis(Hand.kRight);
    double speed = lt - rt;

    //To Rotate you use the Right Joystick X Axis
    double rotate = xbox.getX(Hand.kRight);

    //Drive the Robot
    run(speed,rotate);
  }

  /**
   * Drive Robot using Arcade Drive
   * @param speed Power for moving the robot robot -1 to 1
   * @param rotate Power for Rotating -1 to 1
   */
  public void run(double speed, double rotate) {
    dd.arcadeDrive(speed, rotate);
  }

  /**
   * Stop the wheels on the robot
   */
  public void stop()
  {
    dd.stopMotor();
  }
}
