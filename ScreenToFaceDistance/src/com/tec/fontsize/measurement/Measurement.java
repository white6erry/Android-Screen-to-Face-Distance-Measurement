package com.tec.fontsize.measurement;

import java.util.ArrayList;
import java.util.List;

public class Measurement {
	private String _probantName;		//The probants name 이름
	private String _deviceName;			//기기의 이름
	private String _camResolution;		//측정할 때 쓰이는 전면부 카메라의 해상도
	private int _averageNumber;			//Measurement Point의 개수
	private float _calibrationPosition;	//보정이 되었을 때의 기기의 실제 위치
	private float _calibrationDistance;	//사용된 보정 거리, e.g. an A4-paper (29.7 cm)
	private final List<MeasurementPoint> _measurementPoints = new ArrayList<MeasurementPoint>();//Measurement point 배열

	/**
	 * Returns the measured failure occured while the Head is for example not
	 * exactly at Point 0 at the calibration
	 * 
	 * @return
	 */
	public float getMeasuredFailure() {
		return _calibrationPosition - _calibrationDistance;
	}

	public boolean addPoint(final MeasurementPoint p) {
		return _measurementPoints.add(p);
	}

	public List<MeasurementPoint> getMeasurementPoints() {
		return _measurementPoints;
	}

	public String getProbantName() {
		return _probantName;
	}

	public void setProbantName(final String probantName) {
		_probantName = probantName;
	}

	public String getDeviceName() {
		return _deviceName;
	}

	public void setDeviceName(final String deviceName) {
		_deviceName = deviceName;
	}

	/**
	 * The used resolution of the front camera during this measurement
	 */
	public String getCamResolution() {
		return _camResolution;
	}

	/**
	 * The used resolution of the front camera during this measurement
	 */
	public void setCamResolution(final String camResolution) {
		_camResolution = camResolution;
	}

	/**
	 * The amount of measurements which are combined into one measurement point
	 */
	public int getAverageNumber() {
		return _averageNumber;
	}

	/**
	 * The amount of measurements which are combined into one measurement point
	 */
	public void setAverageNumber(final int averageNumber) {
		_averageNumber = averageNumber;
	}

	/**
	 * The position of the device in the 'real world' in cm when the calibration
	 * is done
	 */
	public float getCalibrationPosition() {
		return _calibrationPosition;
	}

	/**
	 * The position of the device in the 'real world' in cm when the calibration
	 * is done
	 */
	public void setCalibrationPosition(final float calibrationPosition) {
		_calibrationPosition = calibrationPosition;
	}

	/**
	 * The used calibration distance, e.g. an A4-paper (294 mm)
	 */
	public float getCalibrationDistance() {
		return _calibrationDistance;
	}

	/**
	 * The used calibration distance, e.g. an A4-paper (294 mm)
	 */
	public void setCalibrationDistance(final float calibrationDistance) {
		_calibrationDistance = calibrationDistance;
	}

}
