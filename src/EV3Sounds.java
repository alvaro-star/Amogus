import java.io.File;

import lejos.hardware.Sound;

public class EV3Sounds {
	public void msc() {
		File sound = new File("RulesOfNature.wav");
		Sound.playSample(sound, 50);
	}
}
