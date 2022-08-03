import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.chassis.Chassis;
import lejos.robotics.chassis.Wheel;
import lejos.robotics.chassis.WheeledChassis;
import lejos.robotics.navigation.MovePilot;

public class Pilot {
	@SuppressWarnings({ "resource", "unused", "deprecation" })
	public static void main (String [] args) {

		double WHEEL_DIAMETER = 3.81971;
		double OFFSET = 23.5;
		
		EV3LargeRegulatedMotor LEFT_MOTOR = new EV3LargeRegulatedMotor(MotorPort.C);
		EV3LargeRegulatedMotor RIGHT_MOTOR = new EV3LargeRegulatedMotor(MotorPort.B);
		
		Wheel wheel1 = WheeledChassis.modelWheel(LEFT_MOTOR, WHEEL_DIAMETER).offset(-OFFSET);
		Wheel wheel2 = WheeledChassis.modelWheel(RIGHT_MOTOR, WHEEL_DIAMETER).offset(OFFSET);
		
		Wheel wheelArr[] = { wheel1, wheel2 };
		
		Chassis chassis = new WheeledChassis(wheelArr, WheeledChassis.TYPE_DIFFERENTIAL);
			
		MovePilot pilot = new MovePilot(chassis);
		double x = 0.0338;
		pilot.travel(-x*90);
		//pilot.rotate(10);
		
		
		
	}
}
