import lejos.hardware.lcd.TextLCD;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;

public class Banana {
	
	public static void main(String[] args) {
		EV3Hardware abacaxi = new EV3Hardware();
		EV3Movement rodelas = new EV3Movement(MotorPort.A, MotorPort.D, 3.81971, 23.5);
		//                       EV3Sensors(Port ultraPort, Port colorPort1, port colorPortM Port colorPort2)
		EV3Sensors sensors = new EV3Sensors(SensorPort.S4, SensorPort.S1, SensorPort.S2, SensorPort.S3);
		TextLCD LCD = abacaxi.getEv3brick().getTextLCD();
		
		while(abacaxi.ESCNotPressed()) {
			
			sensors.preencherSensor1();
			sensors.preencherSensorM();
			sensors.preencherSensor2();
			
			if(sensors.isPreto2()) {
				LCD.drawString("Preto V", 0, 1);
			}else if(sensors.isVerde2()){
				LCD.drawString("Verde V", 0, 1);
			}else if(sensors.isBranco2()){
				LCD.drawString("Branco V", 0, 1);
			}else{
				LCD.drawString("Nao sei", 0, 1);
			}
			
			LCD.drawString("R1: " + sensors.sensorRGB2[0], 0, 2);
			LCD.drawString("G1: " + sensors.sensorRGB2[1], 0, 3);
			LCD.drawString("B1: " + sensors.sensorRGB2[2], 0, 4);
			
			
			abacaxi.getButtons().waitForAnyPress();
		}
			
	}
}