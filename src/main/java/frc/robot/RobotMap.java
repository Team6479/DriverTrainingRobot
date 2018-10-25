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
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;

    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;

    // Controllers
    public final static int joystick = 0;
    
    // PWM
    // Drivetrain Motors
    public final static int leftFront = 0;
    public final static int leftBack = 1;
    public final static int rightFront = 2;
    public final static int rightBack = 3;

    // DIO
    // Drivetrain Encoders
    public final static int endoderLeft1 = 0;
    public final static int encoderLeft2 = 1;
    public final static int encoderRight1 = 2;
    public final static int encoderRight2 = 3;
}
