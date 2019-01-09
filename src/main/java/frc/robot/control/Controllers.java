/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.control;
import frc.robot.Robot;


public class Controllers {
    private static String getControllerType() {
        return "JOYSTICK";
    }

    public static double getYAxis() {
        if (getControllerType().equals("XBOX")) {
            // Get xbox controller
            return 0;
        } else if (getControllerType().equals("JOYSTICK")) {
            return -Robot.oi.stick.getRawAxis(1);
        } else {
            return 0;
        }
    }

    public static double getXAxis() {
        if (getControllerType().equals("XBOX")) {
            // Get xbox controller
            return 0;
        } else if (getControllerType().equals("JOYSTICK")) {
            return -Robot.oi.stick.getRawAxis(2);
        } else {
            return 0;
        }
    }

    public static double getThrottle() {
        if (getControllerType().equals("XBOX")) {
            return 1;
        } else if (getControllerType().equals("JOYSTICK")) {
            return Robot.oi.stick.getThrottle();
        } else {
            return 1;
        }
    }
}
