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
		Functions r = new Functions(MotorPort.A, MotorPort.D, 5.8, 9.1, sensores);

		String contador = "branco";
		int contadorN = 0;

		// sensor 1 = direita = port 1
		// sensor 2 = esquerda = port 3

		// processamento do Codigo
		r.getLEFT_MOTOR().setSpeed(225);
		r.getRIGHT_MOTOR().setSpeed(225);
		while (abacaxi.ESCNotPressed()) {

			r.sens.preencherSensores();

			if (!(r.sens.corM.equals("p") & r.sens.cor1.equals("b") & r.sens.cor2.equals("b"))) {
				r.alinhar();
			} else {
				r.anterior = "branco";
			}

			r.moveForward();

			// girar para Direita
			if ((r.sens.cor1.equals("v") & r.sens.cor2.equals("b")) & r.sens.corM.equals("p")) {
				r.travel(8.5);
				r.rotate(90);
				r.anterior = "preto: 2";
				// girar para Esqueda
			} else if ((r.sens.cor1.equals("b") & r.sens.cor2.equals("v")) & r.sens.corM.equals("p")) {
				r.travel(8.5);
				r.rotate(-90);
				r.anterior = "preto: 1";
			} else if (r.sens.cor1.equals("v") & r.sens.cor2.equals("v") & r.sens.corM.equals("p")) {
				r.rotate(180);
			}
			if (r.sens.isAllPreto()) {
				r.sens.preencherSensores();
				r.travel(2.5);
				if (r.sens.isAllBranco() & r.anterior == "preto2") {
					r.rotate(7);
					r.anterior = "preto1";
				} else if (r.sens.isAllBranco() & r.anterior == "preto1") {
					r.rotate(-7);
					r.anterior = "preto2";
				}
			}

			r.moveForward();
			if ((r.sens.cor1.equals("p") & r.sens.cor2.equals("b")) & r.sens.corM.equals("p")) {
				r.travel(2);
				r.sens.preencherSensores();
				if (r.sens.isAllBranco()) {
					r.travel(6.5);
					r.rotate(90);
					r.anterior = "preto: 2";
				}
				// girar para Esqueda
			} else if ((r.sens.cor1.equals("b") & r.sens.cor2.equals("p")) & r.sens.corM.equals("p")) {
				r.sens.preencherSensores();
				r.travel(2);
				if (r.sens.isAllBranco()) {
					r.travel(6.5);
					r.rotate(-90);
					r.anterior = "preto: 1";

				}

			}
		}
	}
}