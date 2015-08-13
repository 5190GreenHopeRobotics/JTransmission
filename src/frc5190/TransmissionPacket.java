package frc5190;

import java.util.LinkedList;
import java.util.List;

public class TransmissionPacket {

	protected Byte messageType;
	protected Byte messageLength;
	protected List<Byte> data;

	public TransmissionPacket() {
		messageType = new Byte((byte) 0);
		messageLength = new Byte((byte) 0);
		data = new LinkedList<Byte>();
	}

	/**
	 * @return the messageType
	 */
	public Byte getMessageType() {
		return messageType;
	}

	/**
	 * @param messageType
	 *            the messageType to set
	 */
	public void setMessageType(Byte messageType) {
		this.messageType = messageType;
	}

	/**
	 * @return the messageLength
	 */
	public Byte getMessageLength() {
		return messageLength;
	}

	/**
	 * @param messageLength
	 *            the messageLength to set
	 */
	public void setMessageLength(Byte messageLength) {
		this.messageLength = messageLength;
	}

	public Byte[] getData() {
		return data.toArray(new Byte[2]);
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(Byte[] data) {
		List<Byte> b = new LinkedList<Byte>();
		for (Byte buf : data) {
			b.add(buf);
		}
		this.data = b;
	}

	public void setData(TransmissionData data) {
		this.messageLength = new Byte((byte) (data.getLength() + 2));
		this.data = data.toPacket();
	}

	public List<Byte> toPacket() {
		List<Byte> result;
		result = new LinkedList<Byte>();
		result.add(messageType);
		result.add(messageLength);
		result.addAll(data);
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
		result = prime * result
				+ ((messageLength == null) ? 0 : messageLength.hashCode());
		result = prime * result
				+ ((messageType == null) ? 0 : messageType.hashCode());
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
		TransmissionPacket other = (TransmissionPacket) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (messageLength == null) {
			if (other.messageLength != null)
				return false;
		} else if (!messageLength.equals(other.messageLength))
			return false;
		if (messageType == null) {
			if (other.messageType != null)
				return false;
		} else if (!messageType.equals(other.messageType))
			return false;
		return true;
	}

}