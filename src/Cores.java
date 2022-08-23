import lejos.hardware.port.Port;

public class Cores extends EV3Sensors{

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
		isPreto1();
		isBranco1();
		isVerde2();
		isPreto2();
		isBranco2();
		isVerdeM();
		isPretoM();
		isBrancoM();
	}
	
	public boolean isVerde1() {
		if(sensorRGB1[0] > 0.0230 & sensorRGB1[0] < 0.0380){ 
			if(sensorRGB1[1] > 0.0700 & sensorRGB1[1] < 0.1100) {
				if(sensorRGB1[2] > 0.0500 & sensorRGB1[2] < 0.0880){
					cor1 = "v";
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean isPreto1() {
		if(sensorRGB1[0] > 0.0150 & sensorRGB1[0] < 0.0700){ 
			if( sensorRGB1[1] > 0.0150 & sensorRGB1[1] < 0.0400) {
				if(sensorRGB1[2] > 0.0200 & sensorRGB1[2] < 0.0400){
					cor1 = "p";
					return true;
				}
			}
		}
		return false;
	}

	public boolean isBranco1() {
		if(sensorRGB1[0] > 0.2800 & sensorRGB1[0] < 0.3500) {
			if(sensorRGB1[1] > 0.2000 & sensorRGB1[1] < 0.2650) {
				if(sensorRGB1[2] > 0.2400 & sensorRGB1[2] < 0.3200) {
					cor1 = "b";
					return true;
				}
			}
		}
		return false;
	}
	
	
	public boolean isVerde2() {
		if(sensorRGB2[0] > 0.0200 & sensorRGB2[0] < 0.0500){ 
			if(sensorRGB2[1] > 0.0800 & sensorRGB2[1] < 0.1300) {
				if(sensorRGB2[2] > 0.0500 & sensorRGB2[2] < 0.1000){
					cor2 = "v";
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean isBranco2() {
		if(sensorRGB2[0] > 0.2800 & sensorRGB2[0] < 0.3500) {
			if(sensorRGB2[1] > 0.2500 & sensorRGB2[1] < 0.3500) {
				if(sensorRGB2[2] > 0.2400 & sensorRGB2[2] < 0.3300) {
					cor2 = "b";
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean isPreto2() {
		if(sensorRGB2[0] > 0.0200 & sensorRGB2[0] < 0.0350){ 
			if( sensorRGB2[1] > 0.0200 & sensorRGB2[1] < 0.0400) {
				if(sensorRGB2[2] > 0.0220 & sensorRGB2[2] < 0.0400){
					cor2 = "p";
					return true;
				}
			}
		}
		return false;
	}
	
	
	
	public boolean isVerdeM() {
		if(sensorRGBM[0] > 0.0100 & sensorRGBM[0] < 0.0600){ 
			if(sensorRGBM[1] > 0.0900 & sensorRGBM[1] < 0.1700) {
				if(sensorRGBM[2] > 0.0250 & sensorRGBM[2] < 0.0750){
					corM = "v";
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean isBrancoM() {
		if(sensorRGBM[0] > 0.2000 & sensorRGBM[0] < 0.2900) {
			if(sensorRGBM[1] > 0.2500 & sensorRGBM[1] < 0.3950) {
				if(sensorRGBM[2] > 0.1400 & sensorRGBM[2] < 0.2000) {
					corM = "b";
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean isPretoM() {
		if(sensorRGBM[0] > 0.0130 & sensorRGBM[0] < 0.0350){ 
			if( sensorRGBM[1] > 0.016 & sensorRGBM[1] < 0.0980) {
				if(sensorRGBM[2] > 0.0050 & sensorRGBM[2] < 0.0560){
					corM = "p";
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean isAllPreto() {
		if(isPreto1() & isPreto2() & isPretoM()) {
			return true;
		}
		return false;
	}
	
	public boolean isAllBranco() {
		if(isBranco1() & isBranco2() & isBrancoM()) {
			return true;
		}
		return false;
	}
	
	public boolean isApagado2() {
		if(sensorRGB2[0] > 0.0200 & sensorRGB2[0] < 0.0350){ 
			if( sensorRGB2[1] > 0.0200 & sensorRGB2[1] < 0.0400) {
				if(sensorRGB2[2] > 0.0220 & sensorRGB2[2] < 0.0400){
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean isApagado1() {
		if(sensorRGB1[0] > 0.2800 & sensorRGB1[0] < 0.3500) {
			if(sensorRGB1[1] > 0.2000 & sensorRGB1[1] < 0.2650) {
				if(sensorRGB1[2] > 0.2400 & sensorRGB1[2] < 0.3200) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean isApagadoM() {
		if(isPretoM() && isVerdeM() && isBrancoM()) {
			return false;
		}
		return true;
	}
	
	public boolean isAnyApagado() {
		if(sensorRGBM[0] > 0.0130 & sensorRGBM[0] < 0.0350){ 
			if( sensorRGBM[1] > 0.016 & sensorRGBM[1] < 0.0980) {
				if(sensorRGBM[2] > 0.0050 & sensorRGBM[2] < 0.0560){
					return true;
				}
			}
		}
		return false;
	}
}
