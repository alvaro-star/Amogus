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
		if ((!sens.cor1.equals("p") & sens.cor2.equals("p")) & !sens.corM.equals("p")) {
			this.rotate(-7);
			anterior = "preto: 2";
		} else if ((sens.cor1.equals("b") & sens.cor2.equals("b")) & sens.corM.equals("b") & anterior == "preto: 2") {
			this.rotate(-7);
		} else if ((sens.cor1.equals("p") & !sens.cor2.equals("p")) & !sens.corM.equals("p")) {
			this.rotate(7);
			anterior = "preto: 1";
		} else if ((sens.cor1.equals("b") & sens.cor2.equals("b")) & sens.corM.equals("b") & anterior == "preto: 1") {
			this.rotate(7);
		} else if (sens.isAllBranco() & anterior == "branco") {
			this.travel(3);
		}
		sens.preencherSensores();
	}
	
	public void moveForward() {
		this.movePFrente();
	}
	
	public void moveBackward() {
		this.movePTraz();
	}
	
	public void girarEsquerda(double angle) {
		rotate(angle);
	}
	
	public void girarDireita(double angle) {
		rotate(-angle);
	}

}
