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
	
}

