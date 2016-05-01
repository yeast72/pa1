package converter;

/**
 * UnitFactory be a Singleton
 * 
 * @author Wisarut Boonnumma
 *
 */
public class UnitFactory {
	private static UnitFactory unit = null;

	private UnitFactory() {

	}

	/**
	 * get the singleton instance
	 * @return singleton
	 */
	public static UnitFactory getInstance() {
		if (unit == null)
			unit = new UnitFactory();
		return unit;
	}

	/**
	 * 
	 * @return arrays of unit types
	 */
	public UnitType[] getUnitTypes() {
		return UnitType.values();
	}

	/**
	 * 
	 * @param uType is unit type
	 * @return all the unit of type utype
	 */
	public Unit[] getUnits(UnitType uType) {
		return uType.getUnit();
	}
}
