/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.JoystickMap;
import frc.robot.Robot;
import robot.xbox.ButtonTracker;

/**
 * An example command. You can replace me with your own command.
 */
public class TeleopDrive extends Command {
    private double scale;
    public static boolean tiltMode = false;
    private boolean beenPressed = false;
    public ButtonTracker button11 = new ButtonTracker(Robot.oi.stick, JoystickMap.joystickButton11);

    public TeleopDrive() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        if (button11.isPressed() && !beenPressed) {
            tiltMode = !tiltMode;
            beenPressed = true;
        } else if (!button11.isPressed()) {
            beenPressed = false;
        }
        //Execute arcadeDrive with the x axis and y axis
        scale = (-Robot.oi.stick.getThrottle() + 1) / 2;
        // Robot.drivetrain.arcadeDrive(Robot.oi.controller.getX(Hand.kLeft), Robot.oi.controller.getY(Hand.kLeft));
        if (tiltMode) {
            Robot.drivetrain.arcadeDrive(-Robot.oi.stick.getRawAxis(1) * scale, Robot.oi.stick.getRawAxis(0) * scale);
        } else {
            Robot.drivetrain.arcadeDrive(-Robot.oi.stick.getRawAxis(1) * scale, Robot.oi.stick.getRawAxis(2) * scale);
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
}
