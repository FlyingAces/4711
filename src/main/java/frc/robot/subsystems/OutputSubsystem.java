package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class OutputSubsystem extends SubsystemBase {

    private static TalonSRX intakeMotor;
    private static Timer outputTimer;

    public OutputSubsystem(int motorCANID) {
        intakeMotor = new TalonSRX(13);
        outputTimer = new Timer();
    }

    // Method to start the output mechanism for a specified duration
    public static void startOutput() {
        intakeMotor.set(ControlMode.PercentOutput,0.3);
        outputTimer.reset();
        outputTimer.start();

        // Stop output if duration is specified and not zero
        if (3 != 0) {
            Timer.delay(3);
            stopOutput();
        }
    }

    // Method to stop the output mechanism
    private static void stopOutput() {
        intakeMotor.set(ControlMode.PercentOutput,0);
        outputTimer.stop();
    }
}
