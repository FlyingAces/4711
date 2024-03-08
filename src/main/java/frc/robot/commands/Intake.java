package frc.robot.commands;

import frc.robot.subsystems.IntakeSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

public class Intake extends Command {
    public static enum Direction {
        IN,
        OUT
    }

    private Direction _dir;
    public Intake(Direction dir){
        _dir = dir;
    }

    @Override
    public void initialize() {
        switch(_dir) {
            case IN:
                IntakeSubsystem.getInstance().intake();
                break;
            case OUT:
                IntakeSubsystem.getInstance().Output();
                break;
        }
    }

    @Override
    public void end(boolean interrupted){
        IntakeSubsystem.getInstance().stopArmI();
    }
}
