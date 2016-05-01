package converter;

/**
 * A definition of common units of area.
 * @author Wisarut Boonnumma
 *
 */
public enum Area implements Unit {
	METER("METER",1),
	CENTIMETER("CENTIMETER",0.001),
	FOOT("FOOT",0.09290304),
	INCH("INCH",0.00064516),
	KILOMETER("KILOMETER",1000000),
	MILE("MILE",2589988.110336),
	YARD("YARD",0.83612736),
	MILLIMETER("MILLIMTER",0.000001),
	ROD("ROD",25.29285264),
	BARN("BARN",1E-28),
	ARE("ARE",100),
	ACRE("ACRE",4046.8564224),
	ROOD("ROOD", 1011.7141056),
	NGAN("NGAN",400);

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
	Area(String name, double value) {
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
