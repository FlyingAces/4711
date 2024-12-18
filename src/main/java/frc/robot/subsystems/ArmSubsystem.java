package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
//import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
//import edu.wpi.first.wpilibj.DigitalInput;
import frc.robot.Constants;

public class ArmSubsystem {
    private static ArmSubsystem _instance;

    private TalonSRX armMotor;
    

    // Constructor
    private ArmSubsystem() {
        armMotor = new TalonSRX(Constants.ARM_MOTOR_ID); // Initialize the Talon SRX motor controller
        configureTalonSRX(); // Configure Talon SRX
    }

    // Method to configure Talon SRX parameters
    private void configureTalonSRX() {
        // Configure motor controller feedback device (if using)
        //talonSRX.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);

        // Configure limit switch
        armMotor.configReverseLimitSwitchSource(
            LimitSwitchSource.FeedbackConnector, // Use limit switch connected to the feedback connector
            LimitSwitchNormal.NormallyOpen,      // Assume the limit switch is normally open
            0);   
        armMotor.configForwardLimitSwitchSource(
            LimitSwitchSource.FeedbackConnector, // Use limit switch connected to the feedback connector
            LimitSwitchNormal.NormallyOpen,      // Assume the limit switch is normally open
            0);                                // Timeout in milliseconds (0 for no timeout)
    }

    public static ArmSubsystem getInstance(){
		if(_instance == null)
			_instance = new ArmSubsystem();
		
		return _instance;
	}

    // Method to move the arm up for 2 seconds
    public void moveUp() {
            armMotor.set(ControlMode.PercentOutput, 1); // Example: Set motor to 100% output
        }

        

    // Method to move the arm down until the limit switch is triggered
    public void moveDown() {
            armMotor.set(ControlMode.PercentOutput, -1); // Example: Set motor to -100% output
        }  
    public void stopArm(){
        armMotor.set(ControlMode.PercentOutput, 0.0);
    }
    
}
