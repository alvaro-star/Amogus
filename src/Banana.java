import lejos.hardware.lcd.LCD;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;

/* ultraPort S4
 * colorPort1 s1
 * colorPortM s2
 * colorport2 s3*/
public class Banana {
	
	public static void main(String[] args) {
		//Declaracao de Objeto e variaves
		EV3Hardware abacaxi = new EV3Hardware();
		EV3Movement rodas = new EV3Movement(MotorPort.A, MotorPort.D, 3.81971, 23.5);
		EV3Sensors sens = new EV3Sensors(SensorPort.S4, SensorPort.S1, SensorPort.S2, SensorPort.S3);
		double TRobo = 16;
		double TLinPreta = 2;
		
		// sensor 1 = direita
		// sensor 2 = esquerda
		
		//processamento do Codigo
		while(true) {
			rodas.getLEFT_MOTOR().setSpeed(200);
			rodas.getRIGHT_MOTOR().setSpeed(200);
			sens.preencherSensores();
			
			do {
				sens.preencherSensores();
				rodas.moveForward();
			}while((sens.isBranco1() && sens.isBranco2()) && sens.isPretoM());
			
			/*Verificar velocidade
			int rodaD = rodas.getRIGHT_MOTOR().getSpeed();
			int rodaE = rodas.getLEFT_MOTOR().getSpeed();
			LCD.drawString("RodaD: " + rodaD, 1, 1);
			LCD.drawString("RodaE: " + rodaE, 1, 2);*/
			
			//	girar para Esquerda
			if((!sens.isBranco1() && sens.isBranco2()) && sens.isPretoM()){
				rodas.travel(20);
				rodas.rotate(-90);
			//	girar para Direita
			} else if((sens.isBranco1() && !sens.isBranco2()) && sens.isPretoM()){
				rodas.travel(20);
				rodas.rotate(90);
			}
			rodas.getLEFT_MOTOR().setSpeed(300);
			rodas.getRIGHT_MOTOR().setSpeed(300);
			
			//Verde*/
			/*if (sens.isVerde1() && sens.isVerde2()) {
				rodas.rotate(180);}
			}else if(sens.isVerde1() && !sens.isVerde2()) {
				while(sens.isVerde1()) {
					rodas.moveForward();
					sens.preencherSensor1();
				}
				rodas.stop();
				if(sens.isPreto1()) {
					rodas.travel(TRobo/2 + TLinPreta);
					rodas.rotate(90);
				}
			}else if(!sens.isVerde1() && sens.isVerde2()) {
				while(sens.isVerde2()) {
					rodas.moveForward();
					sens.preencherSensor2();
				}
				rodas.stop();
				if(sens.isPreto2()) {
					rodas.travel(TRobo/2 + TLinPreta);
					rodas.rotate(-90);					
				}
			}*/
			//sens.preencherSensores();
			
			
			/*LCD.drawString("Preto: "+sens.isPreto2(), 1, 1);
			LCD.drawString("Branco: "+sens.isBranco2(), 1, 2);
			LCD.drawString("Verde: "+sens.isVerde2(), 1, 3);
			LCD.drawString("R 1: "+ sens.sensorRGB2[0], 1, 4);
			LCD.drawString("G 1: "+ sens.sensorRGB2[1], 1, 5);
			LCD.drawString("B 1: "+ sens.sensorRGB2[2], 1, 6);*/

			sens.preencherSensores();
			if(sens.isAllBranco()) {
				rodas.stop();
				break;
			}
			//abacaxi.getButtons().waitForAnyPress();
		}
	}
}