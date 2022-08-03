import lejos.hardware.lcd.LCD;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;

/* ultraPort S4
 * colorPort1 s1
 * colorPortM s2
 * colorport2 s3*/
public class Banana {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// Declaracao de Objeto e variaves
		EV3Hardware abacaxi = new EV3Hardware();
		EV3Movement rodas = new EV3Movement(MotorPort.A, MotorPort.D, 3.81971, 23.5);
		EV3Sensors sens = new EV3Sensors(SensorPort.S4, SensorPort.S1, SensorPort.S2, SensorPort.S3);
		EV3Sounds som = new EV3Sounds();

		// EV3Bracos bracos = new EV3Bracos(MotorPort.C, MotorPort.B, 3.81971, 23.5);

		// EV3Bracos bracos = new EV3Bracos(MotorPort.B, MotorPort.C, 3.81971, 23.5);
		double TRobo = 16;
		double TLinPreta = 2;
		String anterior = "branco";

		// bracos.rotate(90);

		// sensor 1 = direita = port 1
		// sensor 2 = esquerda = port 3

		// processamento do Codigo
		while (abacaxi.ESCNotPressed()) {

			sens.preencherSensores();
			som.msc();

			do {
				sens.preencherSensores();
				rodas.moveForward();
			} while ((sens.isBranco1() & sens.isBranco2()) & sens.isPretoM());

			if ((sens.isBranco1() & sens.isBranco2()) & sens.isPretoM()) {
				anterior = "branco";
			}
			// Virando para onde esteja a linha preta

			sens.preencherSensores();
			if ((!sens.isPreto1() & sens.isPreto2()) & !sens.isPretoM()) {
				sens.preencherSensores();
				rodas.rotate(-5);
				anterior = "preto: 2";
			} else if ((sens.isBranco1() & sens.isBranco2()) & sens.isBrancoM() & anterior == "preto: 2") {
				sens.preencherSensores();
				rodas.rotate(-5);
			}

			if ((sens.isPreto1() & !sens.isPreto2()) & !sens.isPretoM()) {
				sens.preencherSensores();
				rodas.rotate(5);
				anterior = "preto: 1";
			} else if ((sens.isBranco1() & sens.isBranco2()) & sens.isBrancoM() & anterior == "preto: 1") {
				sens.preencherSensores();
				rodas.rotate(-5);
			}
			sens.preencherSensores();

			// Verificar velocidade
			rodas.getLEFT_MOTOR().setSpeed(200);
			rodas.getRIGHT_MOTOR().setSpeed(200);

			int rodaD = rodas.getRIGHT_MOTOR().getSpeed();
			int rodaE = rodas.getLEFT_MOTOR().getSpeed();
			LCD.drawString("RodaD: " + rodaD, 1, 1);
			LCD.drawString("RodaE: " + rodaE, 1, 2);
			sens.preencherSensores();

			// girar para Direita
			if ((sens.isVerde1() & sens.isBranco2()) & sens.isPretoM()) {
				sens.preencherSensores();
				rodas.travel(8.5);
				rodas.rotate(90);
				// girar para Esqueda
			} else if ((sens.isBranco1() & sens.isVerde2()) & sens.isPretoM()) {
				sens.preencherSensores();
				rodas.travel(8.5);
				rodas.rotate(-90);
			}
			sens.preencherSensores();

			/*
			 * //Verde if (sens.isVerde1() && sens.isVerde2()) { rodas.rotate(180); }
			 * 
			 * if((sens.isVerde1() & sens.isBranco2()) & sens.isPretoM()) {
			 * while(sens.isVerde1()) { rodas.moveForward(); sens.preencherSensor1(); }
			 * rodas.stop(); if((sens.isVerde1() & sens.isBranco2()) & sens.isPretoM()) {
			 * rodas.travel(4+ TLinPreta); rodas.rotate(90); } }
			 * 
			 * if((sens.isBranco1() & sens.isVerde2()) & sens.isPretoM()) {
			 * while((sens.isBranco1() & sens.isVerde2()) & sens.isPretoM()) {
			 * rodas.moveForward(); sens.preencherSensor2(); } rodas.stop();
			 * if(sens.isPreto2()) { rodas.travel(4+ TLinPreta); rodas.rotate(-90); } }
			 * 
			 * 
			 * //sens.preencherSensores();
			 * 
			 * 
			 * LCD.drawString("Preto: "+sens.isPretoM(), 1, 1);
			 * LCD.drawString("Branco: "+sens.isBranco2(), 1, 2);
			 * LCD.drawString("Verde: "+sens.isVerde1(), 1, 3); LCD.drawString("R 1: "+
			 * sens.sensorRGBM[0], 1, 4); LCD.drawString("G 1: "+ sens.sensorRGBM[1], 1, 5);
			 * LCD.drawString("B 1: "+ sens.sensorRGBM[2], 1, 6);
			 * 
			 * sens.preencherSensores(); if(sens.isAllBranco()) { rodas.stop(); break; }
			 */
			// abacaxi.getButtons().waitForAnyPress();
		}
	}
}