package frc5190;

import java.util.List;

public interface TransmissionData {
	public List<Byte> toPacket();

	public Byte getLength();
}
