/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;


import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoMode;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.Accumulator;
import frc.robot.subsystems.CameraHandler;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.FloorJack;
import frc.robot.subsystems.HABClimber;
import frc.robot.subsystems.HatchManipulator;
import frc.robot.subsystems.LEDS;
import frc.robot.subsystems.Lift;
import frc.robot.subsystems.Tilt;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  
  public static OI m_oi;

  Command m_autonomousCommand;
  SendableChooser<Command> m_chooser = new SendableChooser<>();


  /**
   * Subsystems
   */
  public static Accumulator mAccumulator;
  public static CameraHandler mCameraHandler;
  public static DriveTrain mDriveTrain;
  public static HABClimber mClimber;
  public static HatchManipulator mHatchManipulator;
  public static FloorJack mFloorJack;
  public static Lift mLift;
  public static LEDS mLeds;
  public static Tilt mTilt;
	Compressor c;


  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {

    //Initialize Subsystems
    mLeds = new LEDS();
    mAccumulator = new Accumulator();
    mCameraHandler = new CameraHandler();
    mDriveTrain = new DriveTrain();
    mHatchManipulator = new HatchManipulator();
    mFloorJack = new FloorJack();
    mClimber = new HABClimber();
    mLift = new Lift();
    mTilt = new Tilt();
    //Make sure OI is last
    m_oi = new OI();
   

    c = new Compressor(0);
    c.setClosedLoopControl(true);

    mHatchManipulator.releaseHatch();
    mHatchManipulator.retract();
		
		UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
		camera.setBrightness(50);
    camera.setVideoMode(VideoMode.PixelFormat.kMJPEG, 320, 240, 15);
    mCameraHandler.setCameraPosition(RobotMap.BOTTOM_ANGLE);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   * You can use it to reset any subsystem information you want to clear when
   * the robot is disabled.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString code to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons
   * to the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit() {
   // m_autonomousCommand = m_chooser.getSelected();

    /*
     * String autoSelected = SmartDashboard.getString("Auto Selector",
     * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
     * = new MyAutoCommand(); break; case "Default Auto": default:
     * autonomousCommand = new ExampleCommand(); break; }
     */

    // // schedule the autonomous command (example)
    // if (m_autonomousCommand != null) {
    //   m_autonomousCommand.start();
    // }

    mHatchManipulator.clampHatch();
    teleopInit();
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
    mAccumulator.log();
    mHatchManipulator.log();
    teleopPeriodic();

  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    // if (m_autonomousCommand != null) {
    //   m_autonomousCommand.cancel();
    // }
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
    mAccumulator.log();
    mHatchManipulator.log();
    //mTilt.log();
    //mFloorJack.log();
    //mLift.log();
    //mClimber.log();
    

        
    if(mHatchManipulator.havePanel())
      mLeds.setColor(LEDS.STROBE_GOLD);
    else if(mAccumulator.ballGrabbed())
      mLeds.setColor(LEDS.ORANGE);
    else if(!mClimber.isLatched())
      mLeds.setColor(LEDS.BPM_RAINBOW);
    else
      mLeds.setColor(LEDS.SPECIAL_CHASE);
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
    mHatchManipulator.releaseHatch();
    SmartDashboard.putData(mCameraHandler);
    
  }
}
