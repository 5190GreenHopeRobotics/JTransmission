package frc5190;

import java.util.LinkedList;
import java.util.List;

public class CommandData implements TransmissionData {

	protected Byte command;
	protected Byte param;

	public CommandData() {
		command = new Byte((byte) 0);
		param = new Byte((byte) 0);
	}

	/**
	 * @return the command
	 */
	public Byte getCommand() {
		return command;
	}

	/**
	 * @param command
	 *            the command to set
	 */
	public void setCommand(Byte command) {
		this.command = command;
	}

	/**
	 * @return the param
	 */
	public Byte getParam() {
		return param;
	}

	/**
	 * @param param
	 *            the param to set
	 */
	public void setParam(Byte param) {
		this.param = param;
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
		result = prime * result + ((command == null) ? 0 : command.hashCode());
		result = prime * result + ((param == null) ? 0 : param.hashCode());
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
		CommandData other = (CommandData) obj;
		if (command == null) {
			if (other.command != null)
				return false;
		} else if (!command.equals(other.command))
			return false;
		if (param == null) {
			if (other.param != null)
				return false;
		} else if (!param.equals(other.param))
			return false;
		return true;
	}

	@Override
	public List<Byte> toPacket() {
		List<Byte> buf = new LinkedList<Byte>();
		buf.add(command);
		buf.add(param);
		return buf;
	}

	@Override
	public Byte getLength() {
		return new Byte((byte) 2);
	}

}
