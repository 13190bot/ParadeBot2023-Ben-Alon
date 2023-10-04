package org.firstinspires.ftc.teamcode.commands;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.arcrobotics.ftclib.command.CommandBase;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.ArmSubSystem;

import static org.firstinspires.ftc.teamcode.ArmSubSystem.kG;
public class AutoArmCommand extends CommandBase {
    FtcDashboard dashboard = FtcDashboard.getInstance();
    Telemetry dashboardTelemetry = dashboard.getTelemetry();

    protected ArmSubSystem armSystem;
    protected Telemetry telemetry;
    public AutoArmCommand(ArmSubSystem armSystem, Telemetry telemetry){
        this.armSystem = armSystem;
        this.telemetry = telemetry;
        addRequirements(armSystem);
    }
@Override
    public void execute(){
        if(armSystem.currentGoal == null){
            armSystem.setTarget(ArmSubSystem.POSITION.RIGHT);
        } else {
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
        armSystem.armToOuput();
        telemetry.addData("Current PID output",armSystem.getCurrentPIDOutput());
        dashboardTelemetry.addData("Current PID output",armSystem.getCurrentPIDOutput());
        dashboardTelemetry.addData("Current Goal",armSystem.currentGoal);
        dashboardTelemetry.update();
        telemetry.update();

}
}
