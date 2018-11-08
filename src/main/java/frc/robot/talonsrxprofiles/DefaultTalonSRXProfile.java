package frc.robot.talonsrxprofiles;

import com.ctre.phoenix.motorcontrol.NeutralMode;

import frc.robot.util.TalonSRXProfile;

public class DefaultTalonSRXProfile implements TalonSRXProfile {

    @Override
    public NeutralMode getNeutralMode() {
        System.out.println("Neutral Mode Set To Brake");
		return NeutralMode.Brake;
	}

}
