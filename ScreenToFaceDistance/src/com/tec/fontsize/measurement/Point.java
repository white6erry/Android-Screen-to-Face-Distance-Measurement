package com.tec.fontsize.measurement;

public class Point {

	private final float _eyeDistance;		//눈 사이의 거리(mm) 
	private final float _deviceDistance;	//디바이스와 사람의 거리(mm)

	public Point(final float eyeDistance, final float deviceDistance) {
		_eyeDistance = eyeDistance;
		_deviceDistance = deviceDistance;
	}

	/**
	 * in mm
	 * @return
	 */
	public float getEyeDistance() {
		return _eyeDistance;
	}

	/**
	 * in mm
	 * @return
	 */
	public float getDeviceDistance() {
		return _deviceDistance;
	}
}
