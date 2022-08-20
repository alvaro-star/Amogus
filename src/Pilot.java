import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.chassis.Chassis;
import lejos.robotics.chassis.Wheel;
import lejos.robotics.chassis.WheeledChassis;
import lejos.robotics.navigation.MovePilot;

public class Pilot {
	@SuppressWarnings({ "resource", "unused" })
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
		
		//tentativa de fazer ele percorrer a parte apagada

		/*
		  //Verde if (sens.isVerde1() && sens.isVerde2()) { rodas.rotate(180); }
		  
		  if((sens.isVerde1() & sens.isBranco2()) & sens.isPretoM()) {
		  while(sens.isVerde1()) { rodas.moveForward(); sens.preencherSensor1(); }
		  rodas.stop(); if((sens.isVerde1() & sens.isBranco2()) & sens.isPretoM()) {
		  rodas.travel(4+ TLinPreta); rodas.rotate(90); } }
		  
		  if((sens.isBranco1() & sens.isVerde2()) & sens.isPretoM()) {
		  while((sens.isBranco1() & sens.isVerde2()) & sens.isPretoM()) {
		  rodas.moveForward(); sens.preencherSensor2(); } rodas.stop();
		  if(sens.isPreto2()) { rodas.travel(4+ TLinPreta); rodas.rotate(-90); } }
		   //sens.preencherSensores(); if(sens.isAllBranco()) { rodas.stop(); break; }
		 */
		// sens.preencherSensores();
		/*
		 	LCD.drawString("Preto: "+sens.isPretoM(), 1, 1);
		 	LCD.drawString("Branco: "+sens.isBranco2(), 1, 2);
		 	LCD.drawString("Verde: "+sens.isVerde1(), 1, 3); LCD.drawString("R 1: "+
		 	sens.sensorRGBM[0], 1, 4); LCD.drawString("G 1: "+ sens.sensorRGBM[1], 1, 5);
		 	LCD.drawString("B 1: "+ sens.sensorRGBM[2], 1, 6);
		 */
		// abacaxi.getButtons().waitForAnyPress();
		
		
	}
}
