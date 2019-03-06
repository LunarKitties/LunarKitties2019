/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.buttons.LiftHatchControlButtons.LiftToBottomHatchButton;
import frc.robot.buttons.LiftHatchControlButtons.LiftToMiddleHatchButton;
import frc.robot.buttons.LiftHatchControlButtons.LiftToTopHatchButton;
import frc.robot.buttons.LiftBallControlButtons;
import frc.robot.buttons.LiftBallControlButtons.LiftToBottomBallButton;
import frc.robot.buttons.LiftBallControlButtons.LiftToMiddleBallButton;
import frc.robot.buttons.LiftBallControlButtons.LiftToTopBallButton;
import frc.robot.commands.drivetrain.ShiftWheelsHigh;
import frc.robot.commands.drivetrain.ShiftWheelsLow;
import frc.robot.commands.hab.ToggleLatch;
import frc.robot.commands.hatchmanipulator.DepositPanel;
import frc.robot.commands.hatchmanipulator.GrabAndStore;
import frc.robot.commands.hatchmanipulator.PopAndDeposit;
import frc.robot.commands.hatchmanipulator.PopAndWait;
import frc.robot.commands.hatchmanipulator.PopDeposit;
import frc.robot.commands.hatchmanipulator.ResetManipulator;
import frc.robot.commands.hatchmanipulator.RetractAndScore;
import frc.robot.commands.hatchmanipulator.RetrievePanel;
import frc.robot.commands.lift.DisengageBrake;
import frc.robot.commands.lift.EngageBrake;
import frc.robot.commands.lift.MoveLiftToBottom;
import frc.robot.commands.lift.MoveLiftToMid;
import frc.robot.commands.lift.MoveLiftToTop;
import frc.robot.commands.lift.MoveToMiddleHatch;
import frc.robot.commands.lift.MoveToTopHatch;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);

  public int 
  a = 1,
	b = 2,
	x = 3,
	y = 4,
	rb = 6,
	lb = 5,
	start = 8,
	back = 7,
	rt = 3,
	lt = 2,
	dpad_up = 0,
	dpad_right = 90,
	dpad_down = 180,
  dpad_left = 270;

  public XboxController xbox1 = new XboxController(0);
  public XboxController xbox2 = new XboxController(1);

  //LiftBallControlButtons liftBallControlButtons = new LiftBallControlButtons(xbox2);
  Button btnGetPanel = new JoystickButton(xbox2, rb);
  Button btnDepositPanel = new JoystickButton(xbox2, lb);

  Button btnLiftTop = new JoystickButton(xbox2, y);
  Button btnLiftMid = new JoystickButton(xbox2, b);
  Button btnLiftBot = new JoystickButton(xbox2, a);
 
  Button btnResetManipulator = new JoystickButton(xbox2, x);
  Button btnDisengageBrake = new JoystickButton(xbox2, start);

  Button btnShiftWheelsHigh = new JoystickButton(xbox1, rb);
  Button btnShiftWheelsLow = new JoystickButton(xbox1, lb);

  // Button liftToTopHatchButton = new LiftToTopHatchButton();
  // Button liftToMidHatchButton = new LiftToMiddleHatchButton();
  // Button liftToBottomHatchButton = new LiftToBottomHatchButton();

  // Button liftToTopBallButton = new LiftToTopBallButton();
  // Button liftToMidBallButton = new LiftToMiddleBallButton();
  // Button liftToBottomBallButton = new LiftToBottomBallButton();

  Button btnToggleLatch = new JoystickButton(xbox1, start);


  public OI()
  {
    //  btnGetPanel.whileHeld(new PopAndWait());
    //  btnGetPanel.whenReleased(new GrabAndStore());

      btnDepositPanel.whenReleased(new PopAndDeposit());
     // btnDepositPanel.whenReleased(new RetractAndScore());  

     
    //Functions to automatically get panels
     btnGetPanel.whenReleased(new RetrievePanel());
    // btnDepositPanel.whenReleased(new DepositPanel());


    // liftToTopBallButton.whenReleased(new MoveLiftToTop());
    // liftToMidBallButton.whenReleased(new MoveLiftToMid());
    // liftToBottomBallButton.whenReleased(new MoveLiftToBottom());

    btnLiftTop.whenReleased(new MoveLiftToTop());
    btnLiftMid.whenReleased(new MoveLiftToMid());
    btnLiftBot.whenReleased(new MoveLiftToBottom());



    // liftToTopHatchButton.whenReleased(new MoveToTopHatch());
    // liftToMidHatchButton.whenReleased(new MoveToMiddleHatch());
    // liftToBottomHatchButton.whenReleased(new MoveToMiddleHatch());
    
    btnResetManipulator.whenReleased(new ResetManipulator());
    btnDisengageBrake.whenReleased(new DisengageBrake());
    btnShiftWheelsHigh.whenPressed(new ShiftWheelsHigh());
    btnShiftWheelsLow.whenPressed(new ShiftWheelsLow());

    btnToggleLatch.whenReleased(new ToggleLatch());
  }
  /**
   * Get the Xbox Controller plugged into port 0
   * @return An instance of "Controller 1"
   */
  public XboxController getXboxController1() {
    return xbox1;
  }

  /**
   * Get the Xbox Controller Plugged into port 1
   * @return An instance of "Controller 2"
   */
  public XboxController getXboxController2() {
    return xbox2;
  }
}

