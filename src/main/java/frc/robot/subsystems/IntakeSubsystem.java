package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {

    private  TalonSRX intakeMotor;
    

    public IntakeSubsystem(int motorCANID) {
        intakeMotor = new TalonSRX(motorCANID);
    }

    // Method to intake game elements
    public void intake() {
        // Check if limit switch is not pressed before starting intake
        
            intakeMotor.set(ControlMode.PercentOutput, 0.5); // Example: Set motor to 50% output
                
    }
}
