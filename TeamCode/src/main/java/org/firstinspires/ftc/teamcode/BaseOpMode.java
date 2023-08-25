package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.button.GamepadButton;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;

public class BaseOpMode extends CommandOpMode {

    protected MotorEx fl1, fr1, fl2, fr2;
    protected ParadeBotSubSystem paradeSystem;
    protected GamepadEx pad1;


    @Override
    public void initialize() {

        // TODO: Get real Config Names
        fl1 = new MotorEx(hardwareMap, "frontLeft1");
        fr1 = new MotorEx(hardwareMap, "frontRight1");
        fl2 = new MotorEx(hardwareMap, "frontLeft2");
        fr2 = new MotorEx(hardwareMap, "frontRight2");

        paradeSystem = new ParadeBotSubSystem(fl1, fr1,fl2,fr2);

        pad1 = new GamepadEx(gamepad1);
    }

    protected GamepadButton gp1(GamepadKeys.Button button) {
        return pad1.getGamepadButton(button);
    }


}