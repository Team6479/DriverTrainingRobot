/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.TeleopDrive;

/**
 * An example subsystem. You can replace me with your own Subsystem.
 */
public class Drivetrain extends Subsystem {
    // Declare 4 Motor Controllers
    // Left Front Motor (Master)
    private TalonSRX leftMaster;
    // Left Back Motor (Slave)
    private TalonSRX leftSlave;
    // Right Front Motor (Master)
    private TalonSRX rightMaster;
    // Right Back Motor (Slave)
    private TalonSRX rightSlave;

    public Drivetrain() {
        // Init Master Motors
        leftMaster = new TalonSRX(RobotMap.leftFront);
        rightMaster = new TalonSRX(RobotMap.rightFront);
        // Init Slave Motors and tell them to follow their respective masters
        leftSlave = new TalonSRX(RobotMap.leftBack);
        leftSlave.follow(leftMaster);
        rightSlave = new TalonSRX(RobotMap.rightBack);
        rightSlave.follow(rightMaster);
    }

    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new TeleopDrive());
    }

    public void arcadeDrive(double speed, double rotation) {
        leftMaster.set(ControlMode.PercentOutput, speed, DemandType.ArbitraryFeedForward, rotation);
        rightMaster.set(ControlMode.PercentOutput, speed, DemandType.ArbitraryFeedForward, -rotation);
    }
}
