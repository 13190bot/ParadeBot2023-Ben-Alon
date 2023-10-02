package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;
import org.firstinspires.ftc.teamcode.ArmSubSystem;

public class AutoArmCommand extends CommandBase {
    protected ArmSubSystem armSystem;
    AutoArmCommand(ArmSubSystem armSystem){
        this.armSystem = armSystem;
        addRequirements(armSystem);
    }
@Override
    public void execute(){
            if (armSystem.atTarget()) {
                switch (armSystem.currentGoal) {
                    case LEFT:
                        armSystem.setTarget(ArmSubSystem.POSITION.RIGHT);
                        break;
                    case RIGHT:
                        armSystem.setTarget(ArmSubSystem.POSITION.LEFT);
                        break;
                    case MID:
                        armSystem.setTarget(ArmSubSystem.POSITION.RIGHT);
                        break;
                }
            }
    }
}
