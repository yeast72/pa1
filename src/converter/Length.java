package converter;
/** A definition of common units of length. */
public enum Length{
	/* Define the members of the enumeration
	 * The attributes are:
	 * name = a string name for this units,
	 * value = multiplier to convert to meters.
	 */
	METER("METER",1.0),
	KILOMETER("KILOMETER",1000),
	CENTIMETER("CENTIMETER",0.01),
	MILE("MILE",1609.344),
	FOOT("FOOT", 0.3048),
	YARD("YARD",Length.FOOT.getValue()*3),
	WA("WA",2),
	INCH("INCH", 0.0254),
	LIGHTYEAR("LIGHT-YEAR",9460730472580800.0),
	MICRON("MICRON", 1.0E-6);
	
	
	/**
	 * name of this unit */
	private final String name;
	/**multiplier to convert this unit to std unit*/
	private final double value;
	
	/**Privavte constuctor for enum member */
	Length(String name,double value){
		this.name = name;
		this.value = value;
	}
	public double getValue(){ return this.value; }
	public String toString(){ return this.name; }
	
}
