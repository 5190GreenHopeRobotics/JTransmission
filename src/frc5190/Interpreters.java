package frc5190;

public class Interpreters {

	public Interpreters() {
		// TODO Auto-generated constructor stub
	}

	public static KeepStateData interpreteKeepState(TransmissionPacket packet) {
		Byte[] data = packet.getData();
		KeepStateData result = new KeepStateData();
		result.setState(data[0]);
		result.setSequence(data[1]);
		return result;
	}

	public static CommandData interpretCommand(TransmissionPacket data) {
		CommandData result = new CommandData();
		Byte[] raw = data.getData();
		result.setCommand(raw[0]);
		result.setParam(raw[1]);
		return result;
	}

	public static SensorData interpretSensorData(TransmissionPacket packet) {
		SensorData result = new SensorData();
		SensorInfo info = null;
		Byte[] raw = packet.getData();
		result.setArduinoStat(raw[0]);
		result.setSensorNum(raw[1]);
		for (int i = 0; i < result.getSensorNum(); ++i) {
			info = new SensorInfo();
			info.setId(raw[(i * 2) + 2]);
			info.setStat(raw[(i * 2) + 3]);
			info.setData(raw[3 + (2 * result.getSensorNum()) + (i * 2)]);
			result.addInfo(info);
		}
		return result;
	}
}
