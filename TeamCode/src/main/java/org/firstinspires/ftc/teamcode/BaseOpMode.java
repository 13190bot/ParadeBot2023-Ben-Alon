package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.button.GamepadButton;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;

public class BaseOpMode extends CommandOpMode {

    protected MotorEx fl1, fr1, fl2, fr2, armMotor;
    protected ParadeBotSubSystem paradeSystem;
    protected ArmSubSystem armSubSystem;
    protected GamepadEx pad1;


    @Override
    public void initialize() {

        fl1 = new MotorEx(hardwareMap, "backLeft1");
        fr1 = new MotorEx(hardwareMap, "backRight1");
        fl2 = new MotorEx(hardwareMap, "backLeft2");
        fr2 = new MotorEx(hardwareMap, "backRight2");

        armMotor = new MotorEx(hardwareMap, "armMotor");

        paradeSystem = new ParadeBotSubSystem(fl1, fr1,fl2,fr2);
        armSubSystem = new ArmSubSystem(armMotor);


        pad1 = new GamepadEx(gamepad1);
    }

    @Override
    public void run(){
        telemetry.addData("Arm Encoder Pos", armSubSystem.getArmPosition());
        telemetry.update();
    }

    protected GamepadButton gpB1(GamepadKeys.Button button) {
        return pad1.getGamepadButton(button);
    }
    protected double gpT1(GamepadKeys.Trigger trigger) {
        return pad1.getTrigger(trigger);
    }


}
