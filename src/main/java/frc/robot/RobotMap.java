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
    public static int joystick = 0;

    // Joystick Buttons
    public static int joystickButton1 = 1;
    public static int joystickButton2 = 2;
    public static int joystickButton3 = 3;
    public static int joystickButton4 = 4;
    public static int joystickButton5 = 5;
    public static int joystickButton6 = 6;
    public static int joystickButton7 = 7;
    public static int joystickButton8 = 8;
    public static int joystickButton9 = 9;
    public static int joystickButton10 = 10;
    public static int joystickButton11 = 11;
    public static int joystickButton12 = 12;
    public static int joystickButton13 = 13;

    // PWM
    // Drivetrain Motors
    public static int leftFront = 0;
    public static int leftBack = 1;
    public static int rightFront = 2;
    public static int rightBack = 3;

    // DIO
    // Drivetrain Encoders
    public static int endoderLeft1 = 0;
    public static int encoderLeft2 = 1;
    public static int encoderRight1 = 2;
    public static int encoderRight2 = 3;
}
