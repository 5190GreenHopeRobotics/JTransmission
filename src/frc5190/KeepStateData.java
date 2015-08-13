package frc5190;

import java.util.LinkedList;
import java.util.List;

public class KeepStateData implements TransmissionData {

	protected Byte state;
	protected Byte sequence;

	public KeepStateData() {
		state = new Byte((byte) 1);
		sequence = new Byte((byte) 0);
	}

	/**
	 * @return the state
	 */
	public Byte getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(Byte state) {
		this.state = state;
	}

	/**
	 * @return the sequence
	 */
	public Byte getSequence() {
		return sequence;
	}

	/**
	 * @param sequence
	 *            the sequence to set
	 */
	public void setSequence(Byte sequence) {
		this.sequence = sequence;
	}

	@Override
	public List<Byte> toPacket() {
		List<Byte> buf = new LinkedList<Byte>();
		buf.add(state);
		buf.add(sequence);
		return buf;
	}

	@Override
	public Byte getLength() {
		return new Byte((byte) 2);
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
				+ ((sequence == null) ? 0 : sequence.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
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
		KeepStateData other = (KeepStateData) obj;
		if (sequence == null) {
			if (other.sequence != null)
				return false;
		} else if (!sequence.equals(other.sequence))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		return true;
	}

}
