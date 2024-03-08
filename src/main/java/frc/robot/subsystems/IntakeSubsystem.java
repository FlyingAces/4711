package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.Constants;



public class IntakeSubsystem{
    private static IntakeSubsystem _instance;

    private TalonSRX intakeMotor;
    

    private IntakeSubsystem() {
        intakeMotor = new TalonSRX(Constants.INTAKE_MOTOR_CAN_ID); // Initialize the Talon SRX motor controller
        configureTalonSRX();
    }
    private void configureTalonSRX() {
        // Configure motor controller feedback device (if using)
        //talonSRX.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);

        // Configure limit switch
          
        intakeMotor.configReverseLimitSwitchSource(
            LimitSwitchSource.FeedbackConnector, // Use limit switch connected to the feedback connector
            LimitSwitchNormal.NormallyOpen,      // Assume the limit switch is normally open
            0);                                // Timeout in milliseconds (0 for no timeout)
    }
    public static IntakeSubsystem getInstance(){
		if(_instance == null)
			_instance = new IntakeSubsystem();
		
		return _instance;
	}

    // Method to intake game elements
    public void intake() {
        // Check if limit switch is not pressed before starting intake
        
        intakeMotor.set(ControlMode.PercentOutput, 1); // Example: Set motor to 50% output
                
    }
     public void Output() {
        // Check if limit switch is not pressed before starting intake
        
        intakeMotor.set(ControlMode.PercentOutput, -1); // Example: Set motor to -50% output
                
    }
    public void stopArmI(){
        intakeMotor.set(ControlMode.PercentOutput, 0.0); // Example: Set motor to 0% output

    }
}
