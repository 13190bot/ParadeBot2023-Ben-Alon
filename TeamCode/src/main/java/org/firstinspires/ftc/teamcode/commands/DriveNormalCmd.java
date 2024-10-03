package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.ParadeBotSubSystem;

import java.util.function.DoubleSupplier;

public class DriveNormalCmd extends CommandBase {

    protected ParadeBotSubSystem paradeSystem;
    protected DoubleSupplier forward,turn;
    protected Telemetry telemetry;

    public DriveNormalCmd(ParadeBotSubSystem paradeSystem, DoubleSupplier forward, DoubleSupplier turn){
        this.paradeSystem = paradeSystem;
        this.forward = forward;
        this.turn = turn;

        addRequirements(paradeSystem);
    }

    @Override
    public void execute() {
        paradeSystem.driveNormal(forward.getAsDouble(),turn.getAsDouble());
    }

}
