
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.Port;
import lejos.robotics.navigation.MovePilot;
import lejos.robotics.navigation.Navigator;

public class EV3Bracos {
	private EV3LargeRegulatedMotor LEFT_MOTOR;
	private EV3LargeRegulatedMotor RIGHT_MOTOR;
	
	private double WHEEL_DIAMETER;
	private double OFFSET;
	
	private MovePilot pilot;
	
	private Navigator navigator;
	
	@SuppressWarnings("deprecation")
	public EV3Bracos(Port PORT_LEFT, Port PORT_RIGHT, double WHEEL_DIAMETER, double OFFSET) {
		LEFT_MOTOR = new EV3LargeRegulatedMotor(PORT_LEFT);
		RIGHT_MOTOR = new EV3LargeRegulatedMotor(PORT_RIGHT);
		
		pilot = new MovePilot(WHEEL_DIAMETER, OFFSET, LEFT_MOTOR, RIGHT_MOTOR);
		
		navigator = new Navigator(pilot);
	}

	public EV3LargeRegulatedMotor getLEFT_MOTOR() {
		return LEFT_MOTOR;
	}

	public EV3LargeRegulatedMotor getRIGHT_MOTOR() {
		return RIGHT_MOTOR;
	}

	public double getWHEEL_DIAMETER() {
		return WHEEL_DIAMETER;
	}

	public double getOFFSET() {
		return OFFSET;
	}

	public MovePilot getPilot() {
		return pilot;
	}

	public Navigator getNavigator() {
		return navigator;
	}
	
	public void moveForward() {
		if(!pilot.isMoving()) pilot.forward();
	}
	
	public void moveBackward() {
		if(!pilot.isMoving()) pilot.backward();
	}
	
	public void travel(double distance) {
		pilot.travel(distance);
	}
	
	public void rotate(double angle) {
		pilot.travel(angle*0.0338);
	}
	
	public void stop() {
		pilot.stop();
		while(pilot.isMoving());
	}
	
}
