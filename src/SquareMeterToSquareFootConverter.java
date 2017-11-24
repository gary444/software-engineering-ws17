public class SquareMeterToSquareFootConverter extends Area_Converter {

    private double SQUARE_METER_TO_SQUARE_FOOT_FACTOR = 10.76;

    public SquareMeterToSquareFootConverter(){
        setInputUnits("m^2");
        setOutputUnits("ft^2");
    }

    @Override
    public double convert(double inValue) {

        if (inValue < 0)
            inValue = 0;

        return inValue * SQUARE_METER_TO_SQUARE_FOOT_FACTOR;
    }

    @Override
    public String toString() {
        return "Square Meter to Square Foot Converter";
    }


}
