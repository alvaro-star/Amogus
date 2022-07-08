import lejos.hardware.BrickFinder;
import lejos.hardware.Keys;
import lejos.hardware.ev3.EV3;
import lejos.hardware.lcd.TextLCD;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
public class sus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EV3LargeRegulatedMotor left_engine = new EV3LargeRegulatedMotor(MotorPort.A);
		EV3LargeRegulatedMotor right_engine = new EV3LargeRegulatedMotor(MotorPort.B);
		
		int pressionar = 0; 
		
		EV3 ev3 = (EV3)BrickFinder.getLocal();
		Keys buttons = ev3.getKeys();
		TextLCD display= ev3.getTextLCD();
		
		left_engine.setSpeed(720);
		right_engine.setSpeed(720);
		
		display.drawString("GAS GAS GAS", 1, 1);
		
		buttons.waitForAnyPress();
		do {
			left_engine.forward();
			right_engine.forward();
		} while(true);
		
		/*
		Keys botao= ev3.getKeys();
		
		
		display.drawString("Vamos começar...", 1, 1);
		botao.waitForAnyPress();
		
		display.drawString("Vrummmm", 0, 0);
		
		while(pressionar == 0) {
			
			left_engine.backward();
			right_engine.forward();
			
			pressionar = botao.readButtons();
			
		}
		display.drawString("Girando rodando, ma oi", 0, 0);
		left_engine.rotate(360);
		right_engine.rotate(-360);
	*/	
	}

}
