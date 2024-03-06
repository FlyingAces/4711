package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {

    private static TalonSRX intakeMotor;
    private static DigitalInput limitSwitch;

    public IntakeSubsystem(int motorCANID, int limitSwitchChannel) {
        intakeMotor = new TalonSRX(13);
        limitSwitch = new DigitalInput(12);
    }

    // Method to intake game elements
    public static void intake() {
        // Check if limit switch is not pressed before starting intake
        if (!limitSwitch.get()) {
            intakeMotor.set(ControlMode.PercentOutput, 0.5); // Example: Set motor to 50% output
        } else {
            intakeMotor.set(ControlMode.PercentOutput, 0); // Stop intake if limit switch is pressed
        }
    }
}
