package frc5190;

import java.util.LinkedList;
import java.util.List;

public class SensorInfo {

	protected Byte id;
	protected Byte stat;
	protected Byte data;

	public SensorInfo() {
		id = new Byte((byte) 0);
		stat = new Byte((byte) 0);
		data = new Byte((byte) 0);
	}

	/**
	 * @return the id
	 */
	public Byte getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Byte id) {
		this.id = id;
	}

	/**
	 * @return the stat
	 */
	public Byte getStat() {
		return stat;
	}

	/**
	 * @param stat
	 *            the stat to set
	 */
	public void setStat(Byte stat) {
		this.stat = stat;
	}

	/**
	 * @return the data
	 */
	public Byte getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(Byte data) {
		this.data = data;
	}

	public List<Byte> toDataSeg1() {
		List<Byte> result = new LinkedList<Byte>();
		result.add(id);
		result.add(stat);
		return result;
	}

	public List<Byte> toDataSeg2() {
		List<Byte> result = new LinkedList<Byte>();
		result.add(id);
		result.add(data);
		return result;
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
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((stat == null) ? 0 : stat.hashCode());
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
		SensorInfo other = (SensorInfo) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (stat == null) {
			if (other.stat != null)
				return false;
		} else if (!stat.equals(other.stat))
			return false;
		return true;
	}

}
