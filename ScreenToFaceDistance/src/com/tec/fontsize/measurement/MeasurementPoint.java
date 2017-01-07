package com.tec.fontsize.measurement;

import java.util.ArrayList;
import java.util.List;

import com.tec.fontsize.utils.Util;

public class MeasurementPoint {
	private float _realPosition;		//기기와 사람의 실거리
	private float _measurePosition;		//알고리즘에 의해 측정된 위치
	private float _averageEyeDistance;	//측정단계에서 평균 눈사이 거리
	private float _processTime;			//얼마나 걸리는지
	private int _foundFaces = 0;		//얼굴이 검출되는 횟수
	List<Point> _points = new ArrayList<Point>();//눈사이 거리와 기기와 사람의 거리의 List 
	
	public void setPoints(final List<Point> points) {
		_points = points;
	}

	public List<Point> getPoints() {
		return _points;
	}

	public float getRealPosition() {
		return _realPosition;
	}

	public void setRealPosition(final float realPosition) {
		_realPosition = realPosition;
	}

	public float getMeasurePosition() {
		return _measurePosition;
	}

	public void setMeasurePosition(final float measurePosition) {
		_measurePosition = measurePosition;
	}

	public float getAverageEyeDistance() {
		return _averageEyeDistance;
	}

	public void setAverageEyeDistance(final float averageEyeDistance) {
		_averageEyeDistance = averageEyeDistance;
	}

	public float getProcessTime() {
		return _processTime;
	}

	public void setProcessTime(final float processTime) {
		_processTime = processTime;
	}

	public int getFoundFaces() {
		return _foundFaces;
	}

	public void setFoundFaces(final int foundFaces) {
		this._foundFaces = foundFaces;
	}

	public String[] toStringArray(final Measurement m) {
		String measuredString = "";
		String eyeDistString = "";

		float currMeasAvg = 0;
		float currEyeAvg = 0;

		for (int i = 0; i < 5; ++i) {
			if (i >= _points.size()) {//i가 point의 사이즈보다 클 때
				if (i == 0 || i == 4) {//첫번째와 마지막일 때
					measuredString += ",0";
					eyeDistString += ",0";
				} else {
					measuredString += ",0,0";
					eyeDistString += ",0,0";
				}
			} else {
				currMeasAvg += _points.get(i).getDeviceDistance();
				currEyeAvg += _points.get(i).getEyeDistance();

				if (i == 0 || i == 4) {

					measuredString += ","
							+ Util.MM_TO_CM(_points.get(i).getDeviceDistance());//cm단위로 기기와의 거리 string으로 저장
					eyeDistString += "," + _points.get(i).getEyeDistance();
				} else {
					measuredString += ","
							+ Util.MM_TO_CM(_points.get(i).getDeviceDistance())
							+ "," + Util.MM_TO_CM((currMeasAvg / (i + 1)));//cm단위로 기기와의 거리와 평균 거리를 string에 저장
					eyeDistString += "," + _points.get(i).getEyeDistance()
							+ "," + (currEyeAvg / (i + 1));
				}
			}
		}
		/**
		 *  실측거리, 측정된 기기와의 거리의 모든 값, 알고리즘에의해 측정된 거리,
		 *  눈사이 거리 모든 값, 눈사이 거리의 평균,
		 *  실행된 시간, 얼굴검출 횟수
		 *  string배열로 반환
		 */
		return (_realPosition + measuredString + "," + _measurePosition
				+ eyeDistString + "," + _averageEyeDistance + ","
				+ _processTime + "," + _foundFaces).split(",");
	}
}
