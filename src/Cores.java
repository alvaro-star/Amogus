import lejos.hardware.port.Port;

public class Cores extends EV3Sensors {

	public String cor1;
	public String cor2;
	public String corM;

	public Cores(Port ultraPort, Port colorPort1, Port colorPortM, Port colorPort2) {
		super(ultraPort, colorPort1, colorPortM, colorPort2);
	}

	public void preencherSensores() {
		this.preencherSensor1();
		this.preencherSensor2();
		this.preencherSensorM();
		this.conhecerCores();
	}

	public void conhecerCores() {
		isVerde1();
		if (cor1.equals("d")) {
			isPreto1();
		}
		if (cor1.equals("d")) {
			isBranco1();
		}
		
		isVerde2();
		if (cor2.equals("d")) {
			isPreto2();
		}
		if (cor2.equals("d")) {
			isBranco2();
		}
		
		isVerdeM();
		if (corM.equals("d")) {
			isPretoM();
		}
		if (corM.equals("d")) {
			isBrancoM();
		}
	}

	public void isVerde1() {
		if (sensorRGB1[0] > 0.0230 & sensorRGB1[0] < 0.0380) {
			if (sensorRGB1[1] > 0.0700 & sensorRGB1[1] < 0.1100) {
				if (sensorRGB1[2] > 0.0500 & sensorRGB1[2] < 0.0880) {
					cor1 = "v";
				} else {
					cor1 = "d";
				}
			} else {
				cor1 = "d";
			}
		} else {
			cor1 = "d";
		}
	}

	public void isPreto1() {
		if (sensorRGB1[0] > 0.0150 & sensorRGB1[0] < 0.0700) {
			if (sensorRGB1[1] > 0.0150 & sensorRGB1[1] < 0.0400) {
				if (sensorRGB1[2] > 0.0200 & sensorRGB1[2] < 0.0400) {
					cor1 = "p";
				} else {
					cor1 = "d";
				}
			} else {
				cor1 = "d";
			}
		} else {
			cor1 = "d";
		}
	}

	public void isBranco1() {
		if (sensorRGB1[0] > 0.2800 & sensorRGB1[0] < 0.3500) {
			if (sensorRGB1[1] > 0.2000 & sensorRGB1[1] < 0.2650) {
				if (sensorRGB1[2] > 0.2400 & sensorRGB1[2] < 0.3200) {
					cor1 = "b";
				} else {
					cor1 = "d";
				}
			} else {
				cor1 = "d";
			}
		} else {
			cor1 = "d";
		}
	}

	public void isVerde2() {
		if (sensorRGB2[0] > 0.0200 & sensorRGB2[0] < 0.0500) {
			if (sensorRGB2[1] > 0.0800 & sensorRGB2[1] < 0.1300) {
				if (sensorRGB2[2] > 0.0500 & sensorRGB2[2] < 0.1000) {
					cor2 = "v";
				} else {
					cor2 = "d";
				}
			} else {
				cor2 = "d";
			}
		} else {
			cor2 = "d";
		}
	}

	public void isBranco2() {
		if (sensorRGB2[0] > 0.2800 & sensorRGB2[0] < 0.3500) {
			if (sensorRGB2[1] > 0.2500 & sensorRGB2[1] < 0.3500) {
				if (sensorRGB2[2] > 0.2400 & sensorRGB2[2] < 0.3300) {
					cor2 = "b";
				} else {
					cor2 = "d";
				}
			} else {
				cor2 = "d";
			}
		} else {
			cor2 = "d";
		}
	}

	public void isPreto2() {
		if (sensorRGB2[0] > 0.0200 & sensorRGB2[0] < 0.0350) {
			if (sensorRGB2[1] > 0.0200 & sensorRGB2[1] < 0.0400) {
				if (sensorRGB2[2] > 0.0220 & sensorRGB2[2] < 0.0400) {
					cor2 = "p";
				} else {
					cor2 = "d";
				}
			} else {
				cor2 = "d";
			}
		} else {
			cor2 = "d";
		}
	}

	public void isVerdeM() {
		if (sensorRGBM[0] > 0.0100 & sensorRGBM[0] < 0.0600) {
			if (sensorRGBM[1] > 0.0900 & sensorRGBM[1] < 0.1700) {
				if (sensorRGBM[2] > 0.0250 & sensorRGBM[2] < 0.0750) {
					corM = "v";
				} else {
					corM = "d";
				}
			} else {
				corM = "d";
			}
		} else {
			corM = "d";
		}
	}

	public void isBrancoM() {
		if (sensorRGBM[0] > 0.2000 & sensorRGBM[0] < 0.2900) {
			if (sensorRGBM[1] > 0.2500 & sensorRGBM[1] < 0.3950) {
				if (sensorRGBM[2] > 0.1400 & sensorRGBM[2] < 0.2000) {
					corM = "b";
				} else {
					corM = "d";
				}
			} else {
				corM = "d";
			}
		} else {
			corM = "d";
		}
	}

	public void isPretoM() {
		if (sensorRGBM[0] > 0.0130 & sensorRGBM[0] < 0.0350) {
			if (sensorRGBM[1] > 0.016 & sensorRGBM[1] < 0.0980) {
				if (sensorRGBM[2] > 0.0050 & sensorRGBM[2] < 0.0560) {
					corM = "p";
				} else {
					corM = "d";
				}
			} else {
				corM = "d";
			}
		} else {
			corM = "d";
		}
	}

	public boolean isAllPreto() {
		if (cor1.equals("p") & cor2.equals("p") & corM.equals("p")) {
			return true;
		}
		return false;
	}

	public boolean isAllBranco() {
		if (cor1.equals("b") & cor2.equals("b") & corM.equals("b")) {
			return true;
		}
		return false;
	}

	public boolean isApagado2() {
		if (sensorRGB2[0] > 0.0200 & sensorRGB2[0] < 0.0350) {
			if (sensorRGB2[1] > 0.0200 & sensorRGB2[1] < 0.0400) {
				if (sensorRGB2[2] > 0.0220 & sensorRGB2[2] < 0.0400) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean isApagado1() {
		if (sensorRGB1[0] > 0.2800 & sensorRGB1[0] < 0.3500) {
			if (sensorRGB1[1] > 0.2000 & sensorRGB1[1] < 0.2650) {
				if (sensorRGB1[2] > 0.2400 & sensorRGB1[2] < 0.3200) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean isApagadoM() {
		if (corM.equals("p") && corM.equals("v") && corM.equals("b")) {
			return false;
		}
		return true;
	}

	public boolean isAnyApagado() {
		if (sensorRGBM[0] > 0.0130 & sensorRGBM[0] < 0.0350) {
			if (sensorRGBM[1] > 0.016 & sensorRGBM[1] < 0.0980) {
				if (sensorRGBM[2] > 0.0050 & sensorRGBM[2] < 0.0560) {
					return true;
				}
			}
		}
		return false;
	}
}
