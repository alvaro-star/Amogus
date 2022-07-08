import lejos.hardware.BrickFinder;
import lejos.hardware.Button;
import lejos.hardware.Keys;
import lejos.hardware.Sound;
import lejos.hardware.ev3.EV3;
import lejos.hardware.lcd.TextLCD;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.SampleProvider;
import lejos.robotics.navigation.MovePilot;

public class Pilot {
	public static void main (String [] args) {
		EV3LargeRegulatedMotor left_engine = new EV3LargeRegulatedMotor(MotorPort.A);
		EV3LargeRegulatedMotor right_engine = new EV3LargeRegulatedMotor(MotorPort.D);
		
		double diametro = 5;
		double distancia = 13.3;
		//Sensore de Som
		EV3UltrasonicSensor sonic = new EV3UltrasonicSensor(SensorPort.S2);
		SampleProvider dist = sonic.getDistanceMode();
		//Sensore de Cor
		EV3ColorSensor colorDireita = new EV3ColorSensor(SensorPort.S1);
		EV3ColorSensor colorEsquerda = new EV3ColorSensor(SensorPort.S4);
		SampleProvider sensorD = colorDireita.getColorIDMode();
		SampleProvider sensorE = colorEsquerda.getColorIDMode();
		
		
		
		
		/*
			public static final
					RED = 0;
					GREEN = 1;
					BLUE = 2;
					YELLOW = 3;
					MAGENTA = 4;
					ORANGE = 5;
					WHITE = 6;
   					BLACK = 7;
   					PINK = 8;
   					GRAY = 9;
   					LIGHT_GRAY = 10;
   					DARK_GRAY = 11;
   					CYAN = 12;
   					BROWN = 13;
   					NONE = -1; 
		*/
		
		
		EV3 ev3 = (EV3)BrickFinder.getLocal();
		Keys buttons = ev3.getKeys();
		TextLCD display= ev3.getTextLCD();
		
		left_engine.setSpeed(800);
		right_engine.setSpeed(800);
		MovePilot pilot = new MovePilot(diametro, distancia, left_engine, right_engine, false);
		
		double multG = 0.7455;
		double multD = 0.901;
		
		float[] sensores = new float[3];

		
		/*
		pilot.travel(85*multD);
		pilot.rotate(720*multG);
		//Button.waitForAnyPress();
		//dist.fetchSample(sensores, 0);
		//display.drawString("Dist: "+sensores[0], 0, 0);
		//Button.waitForAnyPress();
		*/
		
		//SSSSSSSSSSS
		
		while(true)
		{
			dist.fetchSample(sensores, 0);
			sensorE.fetchSample(sensores, 1);
			sensorD.fetchSample(sensores, 2);
			
			if(sensores[1] == 1|| sensores[2] == 1) {
				pilot.rotate(95*multG);
			}
			if(sensores[0] < 0.01) {
				Sound.beep();
				pilot.rotate(360*multG);
			}else {
				
				if(pilot.isMoving() == false) {
					pilot.forward();
				}
			}
		}
		  //pilot.travel(30*multD); // Integer.MAX_VALUE =∞
		  //pilot.stop();
		//pilot.rotate(360*multG);
		//}
	}
}
