package model.enums;

public enum ModeOfTransport {
	BUS, //
	CAB;

	public static ModeOfTransport fromString(String text) {
		for (ModeOfTransport modeOfTransport : ModeOfTransport.values()) {
			if (modeOfTransport.name().equalsIgnoreCase(text)) {
				return modeOfTransport;
			}
		}
		throw new IllegalArgumentException("No constant with name " + text + " found in enum");
	}
}
