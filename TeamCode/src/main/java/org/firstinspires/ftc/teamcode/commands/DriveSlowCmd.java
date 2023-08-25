package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;
import org.firstinspires.ftc.teamcode.ParadeBotSubSystem;

import java.util.function.DoubleSupplier;

public class DriveSlowCmd extends CommandBase {

    protected ParadeBotSubSystem paradeSystem;
    protected DoubleSupplier forward,turn;

    public DriveSlowCmd(ParadeBotSubSystem paradeSystem, DoubleSupplier forward, DoubleSupplier turn ){
        this.paradeSystem = paradeSystem;
        this.forward = forward;
        this.turn = turn;

        addRequirements(paradeSystem);
    }

    @Override
    public void execute() {
        paradeSystem.driveSlow(forward.getAsDouble(),turn.getAsDouble());
    }

}
