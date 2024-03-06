package frc.robot.autos;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.Swerve;

public class simpleAuto  extends SequentialCommandGroup {
    public simpleAuto(Swerve s_Swerve){
    addRequirements(s_Swerve);
    addCommands(
        
        new InstantCommand(() -> s_Swerve.drive(new Translation2d(1, 0), 90, true, true)),
        new WaitCommand(1),
        new InstantCommand(() -> s_Swerve.drive(new Translation2d(.5, 0), 0, true, true)),
        new WaitCommand(2),
        new InstantCommand(() -> s_Swerve.drive(new Translation2d(0, 0), 0, true, true))
    );
    }
    
}
