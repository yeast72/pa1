package converter;

/**
 * A definition of common units of weight.
 * @author Wisarut Boonnumma
 *
 */
public enum Weight implements Unit {
	KILOGRAM("KILOGRAM", 1),
	MICROGRAM("MICROGRAM",1E-9),
	MILLIGRAM("MILLIGRAM",0.000001),
	NEWTON("NEWTON",0.1019716212978),
	POUND("POUND",0.45359237),
	OUNCE("OUNCE",0.028349523125),
	PENNYWEIGHT("PENNYWEIGHT",0.00155517384),
	GRAM("GRAM",0.001),
	GRAIN("GRAIN",0.00006479891),
	STONE("STONE",6.35029318),
	TON("TON",1016.0469088),
	TONNE("TONNE",1000),
	QUARTER("QUARTER",12.70058636),
	HUNDREDWEIGHT("HUNDREDWEIGHT", 50.80234544),
	;
	
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
	Weight(String name, double value) {
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
