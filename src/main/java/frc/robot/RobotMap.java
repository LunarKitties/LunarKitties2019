/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
 
  //CAN IDs
  public static int CAN_PDP = 0;
  public static int CAN_PCM = 1;
  public static int CAN_FL_DRIVE_MOTOR = 9;
  public static int CAN_BL_DRIVE_MOTOR = 8;
  public static int CAN_FR_DRIVE_MOTOR = 10;
  public static int CAN_BR_DRIVE_MOTOR = 11;
  public static int CAN_TOP_ACCUMULATOR = 6;
  public static int CAN_BOTTOM_ACCUMULATOR = 5;
  public static int CAN_TILT = 7;
  public static int CAN_JACK = 12;
  public static int CAN_R_CLIMBER = 3;
  public static int CAN_L_CLIMBER = 2;
  public static int CAN_CLIMBER_PIVOT = 4;

  //PCM Ports
  public static final int PCM_DRIVE_S_OUT = 6;
  public static final int PCM_DRIVE_S_IN = 7;
  public static final int PCM_BRAKE_OUT = 0;
  public static final int PCM_BRAKE_IN = 1;
  public static final int PCM_HATCH_OUT = 4;
  public static final int PCM_HATCH_IN = 5;
  public static final int PCM_HATCH_CLAMP_OUT = 2;
  public static final int PCM_HATCH_CLAMP_IN = 3;

  //PWM Ports
  public static final int PWM_CAMERA_TILT = 0;
  public static final int PWM_BLINKIN = 5;
  public static final int PWM_LIFT_TL = 6;
  public static final int PWM_LIFT_BL = 7;
  public static final int PWM_LIFT_TR = 8;
  public static final int PWM_LIFT_BR = 9; 

  //DIO Ports

  public static final int DIO_TILT_COUNTER = 0;
  public static final int DIO_HATCH_PANEL_SWITCH = 1;
  public static final int DIO_TILT_SWITCH = 2;
  public static final int DIO_ACCUMULATOR_SWITCH = 3;
  public static final int DIO_JACK_TOP_SWITCH = 4;
  public static final int DIO_JACK_BOTTOM_SWITCH = 5;

  //Analog Input Ports
  public static final int AI_LIFT_POT = 0;
}
