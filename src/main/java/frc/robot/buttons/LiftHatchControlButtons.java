/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.buttons;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import frc.robot.Robot;

/**
 * Add your docs here.
 */
public class LiftHatchControlButtons {
    public static class LiftToTopHatchButton extends Button{

        public boolean get()
        {
            return Robot.m_oi.xbox2.getYButtonReleased() 
            && Robot.m_oi.xbox2.getBackButtonPressed();
        }        
    }

    public static class LiftToMiddleHatchButton extends Button{
        public boolean get()
        {
            return Robot.m_oi.xbox2.getBButtonReleased() 
            && Robot.m_oi.xbox2.getBackButtonPressed();
        }        
    }
    public static class LiftToBottomHatchButton extends Button{
        public boolean get()
        {
            return Robot.m_oi.xbox2.getAButtonReleased() 
            && Robot.m_oi.xbox2.getBackButtonPressed();
        }        
    }
}
