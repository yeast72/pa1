package converter;
/**
 * this class convert unit from unit to another unit
 * @author Wisarut Boonnumma
 *
 */
public class UnitConverter {
	/**
	 * 
	 * @param amount 
	 * @param fromUnit
	 * @param toUnit
	 * @return convert fromUnit to toUnit.
	 */
	public double convert(double amount, Unit fromUnit, Unit toUnit) {
		return (amount * fromUnit.getValue()) / toUnit.getValue();
	}
	/**
	 * 
	 * @return all unit of length
	 */
	public Unit[] getUnits(UnitType uType) {
		return UnitFactory.getInstance().getUnits(uType);
	}
}
