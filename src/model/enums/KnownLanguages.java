package model.enums;

public enum KnownLanguages {
	ENGLISH, //
	SPANISH, //
	FRENCH, //
	GERMAN, //
	CHINESE, //
	JAPANESE, //
	ARABIC, //
	RUSSIAN, //
	PORTUGUESE, //
	HINDI, //
	BENGALI, //
	URDU, //
	PUNJABI, //
	TAMIL, //
	TELUGU, //
	MARATHI, //
	GUJARATI, //
	KANNADA, //
	MALAYALAM;

	public static KnownLanguages fromString(String text) {
		for (KnownLanguages language : KnownLanguages.values()) {
			if (language.name().equalsIgnoreCase(text)) {
				return language;
			}
		}
		throw new IllegalArgumentException("No constant with name " + text + " found in enum");
	}
}
