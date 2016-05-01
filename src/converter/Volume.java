package converter;

/**
 * A definition of common units of volume.
 * 
 * @author Wisarut Boonnumma
 *
 */
public enum Volume implements Unit {
	LITER("LITER", 1),
	MICROLITER("MICROLITER",0.000001),
	MILLILITER("MILLILITER",0.01),
	MINIM("MINIM",0.00006161151992187),
	GILL("GILL",0.11829411825),
	QUART("QUART",1.101220942715),
	THUNG("THUNG", 20);
	/**
	 * name of this unit
	 */
	private final String name;
	/**
	 * multiplier to convert this unit to std unit
	 */
	private final double value;

	/**
	 * Privavte constuctor for enum member
	 */
	Volume(String name, double value) {
		this.name = name;
		this.value = value;
	}

	public double getValue() {
		return this.value;
	}

	public String toString() {
		return this.name;
	}
}
