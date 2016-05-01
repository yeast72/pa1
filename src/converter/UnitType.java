package converter;
/**
 * include unit type.
 * @author Wisarut Boonnumma
 *
 */
public enum UnitType {
	LENGTH("Length", Length.values()),
	AREA("Area",Area.values()),
	WEIGHT("Weight", Weight.values()),
	VOLUME("Volume",Volume.values());
	
	/**
	 * all unit of this type
	 */
	private final Unit[] unit;
	/**
	 * name of this type
	 */
	private final String name;

	/**
	 * Private constuctor for enum member
	 */
	UnitType(String name, Unit[] unit) {
		this.name = name;
		this.unit = unit;
	}

	/**
	 * 
	 * @return all unit of type
	 */
	public Unit[] getUnit() {
		return unit;
	}

	/**
	 * 
	 * @return name of unit
	 */
	public String getName() {
		return name;
	}

}
