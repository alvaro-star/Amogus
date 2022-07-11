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
		double TRobo = 80;
		double TLinPreta = 80;
		
		
		//processamento do Codigo
		while(abacaxi.ESCNotPressed()) {
			
			sens.preencherSensores();
			do {
				sens.preencherSensores();
				rodas.moveForward();
			}while((sens.isBranco1() && (sens.isPretoM() || sens.isBrancoM()) && sens.isBranco2()) || sens.isAllPreto());
			rodas.stop();
			
			//Verde
			if (sens.isVerde1() && sens.isVerde2()) {
				rodas.rotate(180);
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
			}
			
			
			
		}
	}
}