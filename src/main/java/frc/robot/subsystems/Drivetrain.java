/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;

/**
 * An example subsystem. You can replace me with your own Subsystem.
 */
public class Drivetrain extends Subsystem {
    // Declare 4 Motor Controllers
    private SpeedController leftFront;
    private SpeedController leftBack;
    private SpeedController rightFront;
    private SpeedController rightBack;
    // Declare 2 Groups For Sides
    private SpeedController leftSide;
    private SpeedController rightSide;

    private DifferentialDrive drivetrain;

    private Encoder encoderLeft;
    private Encoder encoderRight;

    public Drivetrain() {
        leftFront = new Spark(RobotMap.leftFront);
        leftBack = new Spark(RobotMap.leftBack);
        rightFront = new Spark(RobotMap.rightFront);
        rightBack = new Spark(RobotMap.rightBack);

        leftSide = new SpeedControllerGroup(leftFront, leftBack);
        rightSide = new SpeedControllerGroup(rightFront, rightBack);

        drivetrain = new DifferentialDrive(leftSide, rightSide);

        encoderLeft = new Encoder(RobotMap.endoderLeft1, RobotMap.encoderLeft2);
        encoderRight = new Encoder(RobotMap.encoderRight1, RobotMap.encoderRight2);
    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    public void arcadeDrive(double speed, double rotation) {
        drivetrain.arcadeDrive(speed, rotation);
    }



}
