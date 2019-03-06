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
  public static int CAN_TILT = 3;
  public static int CAN_JACK = 2;
  public static int CAN_CLIMBER_PIVOT = 4;

  //PCM Ports
  public static final int PCM_DRIVE_S_OUT = 0;
  public static final int PCM_DRIVE_S_IN = 1;
  public static final int PCM_BRAKE_OUT = 3;
  public static final int PCM_BRAKE_IN = 2;
  public static final int PCM_HATCH_OUT = 4;
  public static final int PCM_HATCH_IN = 5;
  public static final int PCM_HATCH_CLAMP_OUT = 7;
  public static final int PCM_HATCH_CLAMP_IN = 6;

  //PWM Ports
  public static final int PWM_CAMERA_TILT = 0;
  public static final int PWM_BLINKIN = 5;
  public static final int PWM_TL_LIFT = 6;
  public static final int PWM_TR_LIFT = 7;
  public static final int PWM_BL_LIFT = 8;
  public static final int PWM_BR_LIFT = 9; 

  //DIO Ports

  public static final int DIO_TILT_COUNTER = 0;
  public static final int DIO_HATCH_PANEL_SWITCH = 1;
  public static final int DIO_TILT_SWITCH = 2;
  public static final int DIO_ACCUMULATOR_SWITCH = 3;
  public static final int DIO_JACK_TOP_SWITCH = 4;
  public static final int DIO_JACK_BOTTOM_SWITCH = 5;

  //Analog Input Ports
  public static final int AI_LIFT_POT = 0;

  
  public static final double BOTTOM_ROCKET_ANGLE = 0.24;
  public static final double MIDDLE_ROCKET_ANGLE = 0.35;
  public static final double TOP_ROCKET_ANGLE = 0.61;
  public static final double BOTTOM_ANGLE = 0.2;
}
