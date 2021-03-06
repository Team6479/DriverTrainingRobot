/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.EncoderDrive;
import frc.robot.commands.Reset;
import frc.robot.commands.Rotate;
import frc.robot.commands.StraightDrive;
import frc.robot.commands.TeleopDrive;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Drivetrain.Side;
import frc.robot.subsystems.Drivetrain.Unit;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

    public static Drivetrain drivetrain;
    public static OI oi;

    /**
     * This function is run when the robot is first started up and should be used
     * for any initialization code.
     */
    @Override
    public void robotInit() {
        drivetrain = new Drivetrain();

        oi = new OI();

        SmartDashboard.putData(new EncoderDrive(36));
        SmartDashboard.putData(new Reset());
    }

    /**
     * This function is called every robot packet, no matter the mode. Use this for
     * items like diagnostics that you want ran during disabled, autonomous,
     * teleoperated and test.
     *
     * <p>
     * This runs after the mode specific periodic functions, but before LiveWindow
     * and SmartDashboard integrated updating.
     */
    @Override
    public void robotPeriodic() {
        // SmartDashboard.putNumber("Left Encoder", drivetrain.getEndoderLeft().get());
        // SmartDashboard.putNumber("Right Encoder", drivetrain.getEndoderRight().get());
        // SmartDashboard.putNumber("Encoder Average", drivetrain.getEncoderAverage());
    }

    /**
     * This function is called once each time the robot enters Disabled mode. You
     * can use it to reset any subsystem information you want to clear when the
     * robot is disabled.
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
     * between different autonomous modes using the dashboard. The sendable chooser
     * code works with the Java SmartDashboard. If you prefer the LabVIEW Dashboard,
     * remove all of the chooser code and uncomment the getString code to get the
     * auto name from the text box below the Gyro
     *
     * <p>
     * You can add additional auto modes by adding additional commands to the
     * chooser code above (like the commented example) or additional comparisons to
     * the switch structure below with additional strings & commands.
     */
    @Override
    public void autonomousInit() {

    }

    /**
     * This function is called periodically during autonomous.
     */
    @Override
    public void autonomousPeriodic() {
        // drivetrain.arcadeDrive(0.5, 0);
        Scheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {
        // new TeleopDrive().start();
    }

    /**
     * This function is called periodically during operator control.
     */
    @Override
    public void teleopPeriodic() {
        // Display axis of the joystick and value of throttle
        SmartDashboard.putNumber("X-Axis", oi.stick.getX());
        SmartDashboard.putNumber("Y-Axis", oi.stick.getY());
        SmartDashboard.putNumber("Z-Axis", oi.stick.getZ());
        SmartDashboard.putNumber("Throttle", oi.stick.getThrottle());
        SmartDashboard.putNumber("POV", oi.stick.getPOV());

        SmartDashboard.putNumber("Left Velocity", drivetrain.getVelocity(Side.Left, Unit.Meters));
        SmartDashboard.putNumber("Right Velocity", drivetrain.getVelocity(Side.Right, Unit.Meters));
        SmartDashboard.putNumber("Average Velocity", drivetrain.getVelocity(Side.Average, Unit.Meters));
        SmartDashboard.putNumber("Left Raw Velocity", drivetrain.getVelocity(Side.Left));
        SmartDashboard.putNumber("Right Raw Velocity", drivetrain.getVelocity(Side.Right));
        SmartDashboard.putNumber("Average Raw Velocity", drivetrain.getVelocity(Side.Average));
        SmartDashboard.putNumber("Left Position", drivetrain.getPosition(Side.Left, Unit.Meters));
        SmartDashboard.putNumber("Right Position", drivetrain.getPosition(Side.Right, Unit.Meters));
        SmartDashboard.putNumber("Left Raw Position", drivetrain.getPosition(Side.Left));
        SmartDashboard.putNumber("Right Raw Position", drivetrain.getPosition(Side.Right));
        SmartDashboard.putNumber("Average Postion", drivetrain.getPosition(Side.Average, Unit.Meters));	

        // Run commands while button is active
        oi.trigger.whileActive(new StraightDrive());
        oi.sideButton.whileActive(new Rotate());
        Scheduler.getInstance().run();
    }

    /**
     * This function is called periodically during test mode.
     */
    @Override
    public void testPeriodic() {
    }
}
