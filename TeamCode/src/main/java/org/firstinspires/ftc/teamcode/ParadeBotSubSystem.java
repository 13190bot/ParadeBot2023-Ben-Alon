package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.drivebase.DifferentialDrive;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.arcrobotics.ftclib.hardware.motors.MotorGroup;

public class ParadeBotSubSystem extends SubsystemBase {

    protected MotorGroup leftWheel, rightWheel;


    protected DifferentialDrive diffDrive;
    MotorEx fL1, fR1, fL2,fR2;

    int slowSpeed = 4;

    public ParadeBotSubSystem(MotorEx fl1, MotorEx fr1, MotorEx fl2, MotorEx fr2) {
        this.fL1 = fl1;
        this.fR1 = fr1;
        this.fL2 = fl2;
        this.fR2 = fr2;


        leftWheel = new MotorGroup(fL1,fL2);
        rightWheel = new MotorGroup(fR1,fR2);


        diffDrive = new DifferentialDrive(leftWheel,rightWheel);
    }

    public void driveNormal(Double forward, Double turn){
        diffDrive.arcadeDrive(forward,turn);
    }

    public void driveSlow(Double forward, Double turn){
        diffDrive.arcadeDrive(forward/slowSpeed,turn/slowSpeed);
    }







}
