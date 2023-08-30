package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.drivebase.DifferentialDrive;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.arcrobotics.ftclib.hardware.motors.MotorGroup;

public class ParadeBotSubSystem extends SubsystemBase {

    protected MotorGroup leftWheel, rightWheel;


    protected DifferentialDrive diffDrive;
    MotorEx fL, fR;

    int slowSpeed = 4;

    public ParadeBotSubSystem(MotorEx fl, MotorEx fr) {
        this.fL = fl;
        this.fR = fr;







        diffDrive = new DifferentialDrive(fL,fR);
    }

    public void driveNormal(Double forward, Double turn){
        diffDrive.arcadeDrive(forward,turn);
    }

    public void driveSlow(Double forward, Double turn){
        diffDrive.arcadeDrive(forward/slowSpeed,turn/slowSpeed);
    }







}
