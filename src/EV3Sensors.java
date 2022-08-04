import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.SampleProvider;

public class EV3Sensors {
	private EV3UltrasonicSensor ultraSensor;
	public float[] sensorRGB1;
	public float[] sensorRGBM;
	public float[] sensorRGB2;
	private EV3ColorSensor colorSensor1;
	private EV3ColorSensor colorSensorM;
	private EV3ColorSensor colorSensor2;
	
	
	
	public EV3Sensors(Port ultraPort, Port colorPort1, Port colorPortM, Port colorPort2) {
		ultraSensor = new EV3UltrasonicSensor(ultraPort);
		colorSensor1 = new EV3ColorSensor(colorPort1);
		colorSensorM = new EV3ColorSensor(colorPortM);
		colorSensor2 = new EV3ColorSensor(colorPort2);
	}

	public EV3UltrasonicSensor getUltraSensor() {
		return ultraSensor;
	}

	public EV3ColorSensor getColorSensor1() {
		return colorSensor1;
	}
	
	public EV3ColorSensor getColorSensorM() {
		return colorSensorM;
	}

	public EV3ColorSensor getColorSensor2() {
		return colorSensor2;
	}
	
	public static float[] getSampleArray(SampleProvider mode) {
		float[] vetorSamples = new float[mode.sampleSize()];
		
		mode.fetchSample(vetorSamples, 0);
		
		return vetorSamples;
	}
	
	public float getDistanceSample() {
		return getSampleArray(ultraSensor.getDistanceMode())[0];
	}
	
	public float getLightSample1() {
		return getSampleArray(colorSensor1.getAmbientMode())[0];
	} 
	
	public float getColorIDSample1() {
		return getSampleArray(colorSensor1.getColorIDMode())[0];
	}
	
	public float[] getColorRGBSample1() {
		return getSampleArray(colorSensor1.getRGBMode());
		
	}
	
	public float getLightSampleM() {
		return getSampleArray(colorSensorM.getAmbientMode())[0];
	} 
	
	public float getColorIDSampleM() {
		return getSampleArray(colorSensorM.getColorIDMode())[0];
	}
	
	public float[] getColorRGBSampleM() {
		return getSampleArray(colorSensorM.getRGBMode());
		
	}
	
	public float getLightSample2() {
		return getSampleArray(colorSensor2.getAmbientMode())[0];
	} 
	
	public float getColorIDSample2() {
		return getSampleArray(colorSensor2.getColorIDMode())[0];
	}
	
	public float[] getColorRGBSample2() {
		return getSampleArray(colorSensor2.getRGBMode());
	}
	
	
	public void preencherSensor1() {
		sensorRGB1 = this.getColorRGBSample1();
		sensorRGB1[0] = Math.round(sensorRGB1[0]*10000);
		sensorRGB1[0] = sensorRGB1[0]/10000;
		sensorRGB1[1] = Math.round(sensorRGB1[1]*10000);
		sensorRGB1[1] = sensorRGB1[1]/10000;
		sensorRGB1[2] = Math.round(sensorRGB1[2]*10000);
		sensorRGB1[2] = sensorRGB1[2]/10000;
	}
	
	public void preencherSensorM() {
		sensorRGBM = this.getColorRGBSampleM();
		sensorRGBM[0] = Math.round(sensorRGBM[0]*10000);
		sensorRGBM[0] = sensorRGBM[0]/10000;
		sensorRGBM[1] = Math.round(sensorRGBM[1]*10000);
		sensorRGBM[1] = sensorRGBM[1]/10000;
		sensorRGBM[2] = Math.round(sensorRGBM[2]*10000);
		sensorRGBM[2] = sensorRGBM[2]/10000;
	}
	
	public void preencherSensor2() {
		sensorRGB2 = getColorRGBSample2();
		sensorRGB2[0] = Math.round(sensorRGB2[0]*10000);
		sensorRGB2[0] = sensorRGB2[0]/10000;
		sensorRGB2[1] = Math.round(sensorRGB2[1]*10000);
		sensorRGB2[1] = sensorRGB2[1]/10000;
		sensorRGB2[2] = Math.round(sensorRGB2[2]*10000);
		sensorRGB2[2] = sensorRGB2[2]/10000;
	}
	
	public void preencherSensores() {
		this.preencherSensor1();
		this.preencherSensor2();
		this.preencherSensorM();
	}
	
	public boolean isVerde1() {
		if(sensorRGB1[0] > 0.0230 & sensorRGB1[0] < 0.0380){ 
			if(sensorRGB1[1] > 0.0700 & sensorRGB1[1] < 0.1100) {
				if(sensorRGB1[2] > 0.0500 & sensorRGB1[2] < 0.0880){
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
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean isAllPreto() {
		if(isPreto1() && isPreto2() && isPretoM()) {
			return true;
		}
		return false;
	}
	
	public boolean isAllBranco() {
		if(isBranco1() && isBranco2() && isBrancoM()) {
			return true;
		}
		return false;
	}
}

