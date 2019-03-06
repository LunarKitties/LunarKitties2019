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
public class LiftBallControlButtons {
    XboxController xbox;
    public LiftBallControlButtons(XboxController xbox)
    {
        this.xbox = xbox;
    }
    public static class LiftToTopBallButton extends Button{
        public boolean get()
        {
            return Robot.m_oi.getXboxController2().getYButtonReleased() 
            && !Robot.m_oi.getXboxController2().getBackButtonPressed();
        }        
    }

    public static class LiftToMiddleBallButton extends Button{
        public boolean get()
        {
            return Robot.m_oi.getXboxController2().getBButtonReleased() 
            && !Robot.m_oi.getXboxController2().getBackButtonPressed();
        }        
    }
    
    public static class LiftToBottomBallButton extends Button{
        public boolean get()
        {
            return Robot.m_oi.getXboxController2().getAButtonReleased() 
            && !Robot.m_oi.getXboxController2().getBackButtonPressed();
        }        
    }
}
