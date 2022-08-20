import lejos.hardware.BrickFinder;
import lejos.hardware.Keys;
import lejos.hardware.ev3.EV3;
import lejos.hardware.lcd.TextLCD;
import lejos.hardware.port.Port;

public class EV3Hardware {
	private EV3 ev3brick;
	private Keys buttons;
	private TextLCD display;
	
	public EV3Hardware() {
		ev3brick = (EV3) BrickFinder.getLocal();
		buttons = ev3brick.getKeys();
		display = ev3brick.getTextLCD();
	}
	
	public EV3 getEv3brick() {
		return ev3brick;
	}
	
	public Keys getButtons() {
		return buttons;
	}
	
	public TextLCD getDisplay() {
		return display;
	}
	
    public Port getPort(String portName) {
		return ev3brick.getPort(portName);
	}

	public boolean ESCNotPressed() {
		if(buttons.readButtons() != Keys.ID_ESCAPE) {
			return true;
		} else {
			return false;
		}
	}
}