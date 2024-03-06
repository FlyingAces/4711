package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
//import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Timer;

public class ArmSubsystem {
    private static TalonSRX armMotor;
    private static DigitalInput lowerLimitSwitch;
    private static Timer timer;

    // Constructor
    public ArmSubsystem(int talonID, int limitSwitchChannel) {
        armMotor = new TalonSRX(9); // Initialize the Talon SRX motor controller
        lowerLimitSwitch = new DigitalInput(12); // Initialize the limit switch
        timer = new Timer(); // Initialize the timer
        configureTalonSRX(); // Configure Talon SRX
    }

    // Method to configure Talon SRX parameters
    private void configureTalonSRX() {
        // Configure motor controller feedback device (if using)
        //talonSRX.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);

        // Configure limit switch
        armMotor.configForwardLimitSwitchSource(
            LimitSwitchSource.FeedbackConnector, // Use limit switch connected to the feedback connector
            LimitSwitchNormal.NormallyOpen,      // Assume the limit switch is normally open
            0);                                   // Timeout in milliseconds (0 for no timeout)
    }

    // Method to move the arm up for 2 seconds
    public static void moveUp() {
        // Start the timer
        timer.reset();
        timer.start();

        // Move the arm up for 2 seconds
        while (timer.get() < 2.0) { // Move for 2 seconds
            armMotor.set(ControlMode.PercentOutput, 0.5); // Example: Set motor to 50% output
        }

        // Stop the motor after 2 seconds
        armMotor.set(ControlMode.PercentOutput, 0.0);
    }

    // Method to move the arm down until the limit switch is triggered
    public static void moveDown() {
        // Check if limit switch is not triggered
        if (!lowerLimitSwitch.get()) {
            // Move the arm down
            armMotor.set(ControlMode.PercentOutput, -0.5); // Example: Set motor to -50% output
        } else {
            // Stop the motor if the limit switch is triggered
            armMotor.set(ControlMode.PercentOutput, 0.0);
        }
    }
}
