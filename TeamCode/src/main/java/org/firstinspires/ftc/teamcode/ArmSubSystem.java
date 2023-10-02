package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.controller.wpilibcontroller.ProfiledPIDController;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.arcrobotics.ftclib.trajectory.TrapezoidProfile;

public class ArmSubSystem extends SubsystemBase {
    protected MotorEx armMotor;
    protected int currentTarget;

    public ArmSubSystem(MotorEx armMotor) {
        this.armMotor = armMotor;
        controller.setTolerance(3);
    }
    public enum POSITION {
        MID(0),
        LEFT(0),
        RIGHT(0);
        public final int pos;
        POSITION(int pos) {
            this.pos = pos;
        }
    }
    public static double kP = 0.00;
    public static double kG = 0.0;
    public POSITION currentGoal = POSITION.MID;
      protected ProfiledPIDController controller = new ProfiledPIDController(kP, 0, 0,
            new TrapezoidProfile.Constraints(0, 0));


    public void setTarget(POSITION target) {
        currentGoal = target;
        currentTarget = target.pos;
        controller.setGoal(target.pos);
    }
    public void setMid() {setTarget(POSITION.MID);}
    public void setLeft() {setTarget(POSITION.LEFT);}
    public void setRight() {setTarget(POSITION.RIGHT);}
    public boolean atTarget() {return controller.atGoal();}
    @Override
    public void periodic() {
        armMotor.set(controller.calculate(armMotor.getCurrentPosition()+kG));
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
