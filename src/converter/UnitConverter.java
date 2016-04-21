package converter;

public class UnitConverter {
	public double convert(double amount,Length fromUnit, Length toUnit){
		return (amount * fromUnit.getValue()) / toUnit.getValue();
	}
	public Length[] getUnits(){
		return Length.values();
	}
	public static void main(String [] args){
		UnitConverter uc = new UnitConverter();
		uc.getUnits();
		double x = uc.convert(3.0, Length.KILOMETER, Length.METER);
		System.out.println(x);
		System.out.println(Length.MILE.getValue());
	}
}
