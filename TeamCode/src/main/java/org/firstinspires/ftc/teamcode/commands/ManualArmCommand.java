package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.ArmSubSystem;

import java.util.function.DoubleSupplier;

public class ManualArmCommand extends CommandBase {
    protected DoubleSupplier powerForward, powerBack;
    protected ArmSubSystem armSubSystem;
    protected GamepadEx gp1;
    protected Telemetry telemetry;
    protected Boolean isYPressed;

    public ManualArmCommand(DoubleSupplier powerForward, DoubleSupplier powerBack, ArmSubSystem armSubSystem, Telemetry telemetry, Boolean isYPressed) {
        this.powerForward = powerForward;
        this.powerBack = powerBack;
        this.armSubSystem = armSubSystem;
        this.telemetry = telemetry;
        this.isYPressed = isYPressed;
        addRequirements(armSubSystem);
    }

    @Override
    public void execute() {
        armSubSystem.moveArm(powerForward.getAsDouble()+(-powerBack.getAsDouble()));
        if (isYPressed) telemetry.addData("Arm Encoder Pos", armSubSystem.getArmPosition());
        telemetry.update();
    }
    }

