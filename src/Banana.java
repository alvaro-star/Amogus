import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;

/* ultraPort S4
 * colorPort1 s1
 * colorPortM s2
 * colorport2 s3*/
public class Banana {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// Declaracao de Objeto e variaveis
		EV3Hardware abacaxi = new EV3Hardware();
		Cores sensores = new Cores(SensorPort.S4, SensorPort.S1, SensorPort.S2, SensorPort.S3);
		Functions r = new Functions(MotorPort.A, MotorPort.D, 3.81971, 23.5, sensores);

		// EV3Bracos bracos = new EV3Bracos(MotorPort.C, MotorPort.B, 3.81971, 23.5);

		String contador = "branco";
		int contadorN = 0;

		// bracos.rotate(90);

		// sensor 1 = direita = port 1
		// sensor 2 = esquerda = port 3

		// processamento do Codigo
		while (abacaxi.ESCNotPressed()) {
			r.getLEFT_MOTOR().setSpeed(225);
			r.getRIGHT_MOTOR().setSpeed(225);
			r.sens.preencherSensores();

			if (r.sens.isBranco1() & r.sens.isBranco2() & r.sens.isPretoM()) {
				r.anterior = "branco";
				r.moveForward();
				r.sens.preencherSensores();
			} 
			if (r.anterior == "branco") {
				r.sens.preencherSensores();
				r.moveForward();
			}
			
			r.sens.preencherSensores();
			if(!(r.sens.isPretoM() & r.sens.isBranco1() & r.sens.isBranco2())) {
				r.alinhar();
			}
			r.moveForward();

			r.sens.preencherSensores();

			// girar para Direita
			if (((r.sens.isVerde1() | r.sens.isPreto1()) & r.sens.isBranco2()) & r.sens.isPretoM()) {
				r.sens.preencherSensores();
				if(r.sens.cor1 == "preto") {
					r.travel(7.5);
					r.sens.preencherSensores();
				}else {
					r.travel(8.5);
					r.sens.preencherSensores();
				}
				//rodas.travel(8.5);
				r.rotate(90);
				r.anterior = "preto: 2";
			// girar para Esqueda
			} else if ((r.sens.isBranco1() & (r.sens.isVerde2() | r.sens.isPreto2())) & r.sens.isPretoM()) {
				r.sens.preencherSensores();
				if(r.sens.cor2 == "preto") {
					r.travel(7.5);
					r.sens.preencherSensores();
				}else {
					r.travel(8.5);
					r.sens.preencherSensores();
				}
				r.rotate(-90);
				r.anterior = "preto: 1";
			} else if(r.sens.isAllPreto()) {
				r.sens.preencherSensores();
				r.travel(2);
				if(r.sens.isAllBranco() & r.anterior == "preto2") {
					r.rotate(7);
				}else if( r.sens.isAllBranco() & r.anterior == "preto2") {
					r.rotate(-7);
				}
			} else if(r.sens.isVerde1() & r.sens.isVerde2() & r.sens.isPretoM()) {
				r.sens.preencherSensores();
				r.rotate(180);
			}
			
			// Tentando resolver o prolema da parte sem linha
			r.sens.preencherSensores();			/*if((r.sens.isBranco1() & r.sens.isBranco2()) & r.sens.isBrancoM()) {
				r.sens.preencherSensores();
				r.travel(8.5);	
				if ((!r.sens.isPreto1() & r.sens.isPreto2()) & !r.sens.isPretoM()) {
					r.sens.preencherSensores();
					r.rotate(-7);
					r.anterior = "preto: 2";
				} else if ((r.sens.isBranco1() & r.sens.isBranco2()) & r.sens.isBrancoM() & r.anterior == "preto: 2") {
					r.sens.preencherSensores();
					r.rotate(-7);
				}

				if ((r.sens.isPreto1() & !r.sens.isPreto2()) & !r.sens.isPretoM()) {
					r.sens.preencherSensores();
					r.rotate(7);
					r.anterior = "preto: 1";
				} else if ((r.sens.isBranco1() & r.sens.isBranco2()) & r.sens.isBrancoM() & r.anterior == "preto: 1") {
					r.sens.preencherSensores();
					r.rotate(7);
				}
			} else {				if ((!r.sens.isPreto1() & r.sens.isPreto2()) & !r.sens.isPretoM()) {
					r.sens.preencherSensores();
					r.rotate(-7);
					r.anterior = "preto: 2";
				} else if ((r.sens.isBranco1() & r.sens.isBranco2()) & r.sens.isBrancoM() & r.anterior == "preto: 2") {
					r.sens.preencherSensores();
					r.rotate(-7);
				}

				if ((r.sens.isPreto1() & !r.sens.isPreto2()) & !r.sens.isPretoM()) {
					r.sens.preencherSensores();
					r.rotate(7);
					r.anterior = "preto: 1";
				} else if ((r.sens.isBranco1() & r.sens.isBranco2()) & r.sens.isBrancoM() & r.anterior == "preto: 1") {
					r.sens.preencherSensores();
					r.rotate(7);
				}
			}*/
			r.sens.preencherSensores();
		}
		
		
	}
}