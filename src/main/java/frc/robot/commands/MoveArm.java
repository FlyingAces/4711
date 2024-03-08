package frc.robot.commands;

import frc.robot.subsystems.ArmSubsystem;

import edu.wpi.first.wpilibj2.command.Command;



public class MoveArm extends Command {
    public static enum Direction {
        UP,
        DOWN
    }
    
    private Direction _dir;
    public MoveArm(Direction dir){
        _dir = dir;
    }

    @Override
    public void initialize() {
        switch(_dir) {
            case UP:
                ArmSubsystem.getInstance().moveUp();
                break;
            case DOWN:
                ArmSubsystem.getInstance().moveDown();
                break;
        }
    }
    
    @Override
    public void end(boolean interrupted){
        ArmSubsystem.getInstance().stopArm();
    }

   // @Override
    //public boolean isFinished(){
   //     switch (_dir) {
    //        case UP:
    //            return _timer.get() >= Constants.AUTO_UP_TIME;
    //    }

     //   return false;
   // }
}
