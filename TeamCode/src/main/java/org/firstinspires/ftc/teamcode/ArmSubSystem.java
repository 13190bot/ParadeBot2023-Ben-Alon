package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.config.Config;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.controller.PIDController;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
@Config
public class ArmSubSystem extends SubsystemBase {
    protected MotorEx armMotor;
    protected int currentTarget;
    protected double PIDOutput = 0.0;

    public ArmSubSystem(MotorEx armMotor) {
        this.armMotor = armMotor;
        controller.setTolerance(20);
    }
    public enum POSITION {
        MID(0),
        LEFT(-1047),
        RIGHT(829);
        public final int pos;
        POSITION(int pos) {
            this.pos = pos;
        }
    }

    protected double maxSpeed = 0.3;
    public static double kP = 1;
    public static double kI = 0.3;
    public static double kD = 0.0;
    public static double kG = 0.0;
    public POSITION currentGoal = null;
      protected PIDController controller = new PIDController(kP, kI, kD);


    public void setTarget(POSITION target) {
        this.currentGoal = target;
        currentTarget = target.pos;
    }

    public void setMid() {setTarget(POSITION.MID);}
    public void setLeft() {setTarget(POSITION.LEFT);}
    public void setRight() {setTarget(POSITION.RIGHT);}
    public boolean atTarget() {return controller.atSetPoint();}
    public void armToOuput() {
        PIDOutput = (controller.calculate(armMotor.getCurrentPosition()+kG,currentTarget));

        if (PIDOutput > maxSpeed) {
            PIDOutput = maxSpeed;
        } else if (PIDOutput < -maxSpeed) {
            PIDOutput = -maxSpeed;
        }

        armMotor.set(PIDOutput);

    }

    public double getCurrentPIDOutput(){
        return PIDOutput;
    }

    public void moveArm(double power) {
        armMotor.set(power);
    }


    public int getArmPosition() {
        return armMotor.getCurrentPosition();
    }
    public void resetArmEncoder() {
        armMotor.resetEncoder();
    }
}
