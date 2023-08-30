package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.button.GamepadButton;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;

public class BaseOpMode extends CommandOpMode {

    protected MotorEx fl, fr;
    protected ParadeBotSubSystem paradeSystem;
    protected GamepadEx pad1;


    @Override
    public void initialize() {

        // TODO: Get real Config Names
        fl = new MotorEx(hardwareMap, "frontLeft");
        fr = new MotorEx(hardwareMap, "frontRight");


        paradeSystem = new ParadeBotSubSystem(fl, fr);

        pad1 = new GamepadEx(gamepad1);
    }

    protected GamepadButton gp1(GamepadKeys.Button button) {
        return pad1.getGamepadButton(button);
    }


}
