package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;
import org.firstinspires.ftc.teamcode.ParadeBotSubSystem;

import java.util.function.DoubleSupplier;

public class CruiseControlCmd extends CommandBase {
    protected ParadeBotSubSystem paradeSystem;
    protected DoubleSupplier intForward,turn;

    protected Double forward;

    private Double defualtForward = 0.3;



    public CruiseControlCmd(ParadeBotSubSystem paradeSystem, DoubleSupplier intForward, DoubleSupplier turn ){
        this.paradeSystem = paradeSystem;
        this.intForward = intForward;
        this.turn = turn;

        addRequirements(paradeSystem);
    }

    @Override
    public void initialize(){

        // Runs once when ran


        if (intForward.getAsDouble() == 0.0){
           forward = defualtForward;
        } else {
            forward = intForward.getAsDouble();
        }
    }



    @Override
    public void execute() {
        paradeSystem.driveNormal(forward,turn.getAsDouble());
    }

}
