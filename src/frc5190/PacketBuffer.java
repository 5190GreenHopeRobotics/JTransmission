package frc5190;

import java.util.LinkedList;
import java.util.List;

public class PacketBuffer {

	protected List<Byte> buf;

	protected TransmissionPacket interpretRawData(List<? extends Byte> data) {
		if (data.size() < 4) {
			return null;
		}
		Byte length = data.get(1);
		if (data.size() < length.intValue()) {
			return null;
		}
		TransmissionPacket tp = new TransmissionPacket();
		tp.setMessageType(data.get(0));
		tp.setMessageLength(data.get(1));
		Byte[] dataSeg = new Byte[length.intValue()];
		for (int i = 2; i < length.intValue(); ++i) {
			dataSeg[i - 2] = data.get(i);
		}
		tp.setData(dataSeg);
		return tp;
	}

	public TransmissionPacket getPacket() {
		return interpretRawData(buf);
	}

	public PacketBuffer() {
		buf = new LinkedList<Byte>();
	}

	public void addByte(Byte b) {
		buf.add(b);
	}

}
