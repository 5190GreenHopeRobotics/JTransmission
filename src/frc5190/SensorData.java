package frc5190;

import java.util.LinkedList;
import java.util.List;

public class SensorData implements TransmissionData {

	protected List<SensorInfo> buffer;
	protected Byte arduinoStat;
	protected Byte sensorNum;

	public SensorData() {
		buffer = new LinkedList<SensorInfo>();
		arduinoStat = new Byte((byte) 0);
		sensorNum = new Byte((byte) 0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((arduinoStat == null) ? 0 : arduinoStat.hashCode());
		result = prime * result + ((buffer == null) ? 0 : buffer.hashCode());
		result = prime * result
				+ ((sensorNum == null) ? 0 : sensorNum.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SensorData other = (SensorData) obj;
		if (arduinoStat == null) {
			if (other.arduinoStat != null)
				return false;
		} else if (!arduinoStat.equals(other.arduinoStat))
			return false;
		if (buffer == null) {
			if (other.buffer != null)
				return false;
		} else if (!buffer.equals(other.buffer))
			return false;
		if (sensorNum == null) {
			if (other.sensorNum != null)
				return false;
		} else if (!sensorNum.equals(other.sensorNum))
			return false;
		return true;
	}

	/**
	 * @return the buffer
	 */
	public List<SensorInfo> getBuffer() {
		return buffer;
	}

	/**
	 * @param buffer
	 *            the buffer to set
	 */
	public void setBuffer(List<SensorInfo> buffer) {
		this.buffer = buffer;
	}

	/**
	 * @return the arudinoStat
	 */
	public Byte getArduinoStat() {
		return arduinoStat;
	}

	/**
	 * @param arudinoStat
	 *            the arudinoStat to set
	 */
	public void setArduinoStat(Byte arudinoStat) {
		this.arduinoStat = arudinoStat;
	}

	/**
	 * @return the sensorNum
	 */
	public Byte getSensorNum() {
		return sensorNum;
	}

	/**
	 * @param sensorNum
	 *            the sensorNum to set
	 */
	public void setSensorNum(Byte sensorNum) {
		this.sensorNum = sensorNum;
	}

	public void addInfo(SensorInfo info) {
		buffer.add(info);
	}

	@Override
	public List<Byte> toPacket() {
		List<Byte> result = new LinkedList<Byte>();
		result.add(arduinoStat);
		result.add(sensorNum);
		for (SensorInfo i : buffer) {
			result.addAll(i.toDataSeg1());
		}
		for (SensorInfo i : buffer) {
			result.addAll(i.toDataSeg2());
		}
		return result;
	}

	@Override
	public Byte getLength() {
		return new Byte((byte) (2 + 2 * sensorNum));
	}

}
