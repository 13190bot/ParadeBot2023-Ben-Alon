package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.commands.*;

@TeleOp(name = "Parade Bot Teleop")
public class ParadeBotTeleOp extends BaseOpMode {
    // Instance of Commands

    @Override
    public void initialize() {
        super.initialize();
        CruiseControlCmd cruiseCntrl = new CruiseControlCmd(paradeSystem, pad1::getLeftY, pad1::getRightX);
        DriveNormalCmd driveNormal = new DriveNormalCmd(paradeSystem, pad1::getLeftY, pad1::getRightX);
        DriveSlowCmd driveSlow = new DriveSlowCmd(paradeSystem, pad1::getLeftY, pad1::getRightX);
        ManualArmCommand manualArmCommand = new ManualArmCommand(
                () -> gpT1(GamepadKeys.Trigger.RIGHT_TRIGGER),
                () -> gpT1(GamepadKeys.Trigger.LEFT_TRIGGER),
                armSubSystem,
                telemetry,
                gpB1(GamepadKeys.Button.Y).get()
        );
        AutoArmCommand autoArmCommand = new AutoArmCommand(armSubSystem,telemetry);

        //Toggled Commands
        gpB1(GamepadKeys.Button.X).toggleWhenPressed(driveSlow);
        gpB1(GamepadKeys.Button.B).toggleWhenPressed(cruiseCntrl);
        gpB1(GamepadKeys.Button.A).toggleWhenPressed(autoArmCommand);

        gpB1(GamepadKeys.Button.BACK).whenPressed(new InstantCommand(() -> {
            armSubSystem.resetArmEncoder();
        }));

        register(armSubSystem);
        register(paradeSystem);
        paradeSystem.setDefaultCommand(driveNormal);
        armSubSystem.setDefaultCommand(manualArmCommand);
    }
}
