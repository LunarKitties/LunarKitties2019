package frc.robot.subsystems;

import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class CameraHandler extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public Servo cameraTilt = new Servo(RobotMap.PWM_CAMERA_TILT);
	
    public static final double TOP_ANGLE = 0;
    public static final double BOTTOM_ANGLE = 0.46;

    public CameraHandler()
    {
        //setName("Camera Handler");
        //SmartDashboard.putData(cameraTilt);
    }
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    
    public void setCameraPosition(double angle)
    {
    	// if(angle > TOP_ANGLE)
    	// 	angle = TOP_ANGLE;
    	// else if(angle < BOTTOM_ANGLE)
    	// 	angle = BOTTOM_ANGLE;
    	
  //  	cameraTilt.set(angle);
    }
    
    public void adjustCameraPosition(double angle)
    {
    	setCameraPosition(cameraTilt.get() + angle);
    }
    
    public void setToTop()
    {
    	setCameraPosition(TOP_ANGLE);
    }
    
    public void setToBottom()
    {
    	setCameraPosition(BOTTOM_ANGLE);
    }
    
    public void log()
    {
    //	SmartDashboard.putNumber("CAMERA HANDLER: Camera Angle", cameraTilt.get());
    }
    
    
    
}

