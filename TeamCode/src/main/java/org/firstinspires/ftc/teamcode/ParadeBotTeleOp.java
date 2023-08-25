package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.commands.CruiseControlCmd;
import org.firstinspires.ftc.teamcode.commands.DriveNormalCmd;
import org.firstinspires.ftc.teamcode.commands.DriveSlowCmd;

@TeleOp(name = "Parade Bot Teleop")
public class ParadeBotTeleOp extends BaseOpMode {
    // Instance of Commands

    @Override
    public void initialize() {
        super.initialize();
        CruiseControlCmd cruiseCntrl = new CruiseControlCmd(paradeSystem, pad1::getLeftY, pad1::getRightX);
        DriveNormalCmd driveNormal = new DriveNormalCmd(paradeSystem, pad1::getLeftY, pad1::getRightX);
        DriveSlowCmd driveSlow = new DriveSlowCmd(paradeSystem, pad1::getLeftY, pad1::getRightX);

        //Toggled Commands
        gp1(GamepadKeys.Button.X).toggleWhenPressed(driveSlow);
        gp1(GamepadKeys.Button.B).toggleWhenPressed(cruiseCntrl);

        register(paradeSystem);
        paradeSystem.setDefaultCommand(driveNormal);
    }
}
