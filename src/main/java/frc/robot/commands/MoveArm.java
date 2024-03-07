package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.subsystems.ArmSubsystem;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.units.Time;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;

import com.ctre.phoenix.motorcontrol.ControlMode;


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
