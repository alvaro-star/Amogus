import lejos.hardware.port.Port;

public class Functions extends EV3Movement {

	Cores sens;
	double TRobo = 16;
	double TLinPreta = 2;
	String anterior = "branco";

	public Functions(Port PORT_LEFT, Port PORT_RIGHT, double WHEEL_DIAMETER, double OFFSET, Cores sens) {
		super(PORT_LEFT, PORT_RIGHT, WHEEL_DIAMETER, OFFSET);
		this.sens = sens;
	}
	
	public void alinhar() {
		sens.preencherSensores();
		if ((!sens.isPreto1() & sens.isPreto2()) & !sens.isPretoM()) {
			sens.preencherSensores();
			this.rotate(-7);
			anterior = "preto: 2";
		} else if ((sens.isBranco1() & sens.isBranco2()) & sens.isBrancoM() & anterior == "preto: 2") {
			sens.preencherSensores();
			this.rotate(-7);
		}else if ((sens.isPreto1() & !sens.isPreto2()) & !sens.isPretoM()) {
			sens.preencherSensores();
			this.rotate(7);
			anterior = "preto: 1";
		} else if ((sens.isBranco1() & sens.isBranco2()) & sens.isBrancoM() & anterior == "preto: 1") {
			sens.preencherSensores();
			this.rotate(7);
		}
		sens.preencherSensores();
	}
	
}
