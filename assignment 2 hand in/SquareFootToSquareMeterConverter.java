public class SquareFootToSquareMeterConverter extends Area_Converter {

    private double SQUARE_FOOT_TO_SQUARE_METER_FACTOR = 0.093;

    public SquareFootToSquareMeterConverter(){
        setInputUnits("ft^2");
        setOutputUnits("m^2");
    }

    @Override
    public double convert(double inValue) {

        if (inValue < 0)
            inValue = 0;

        return inValue * SQUARE_FOOT_TO_SQUARE_METER_FACTOR;
    }

    @Override
    public String toString() {
        return "Square Foot to Square Meter Converter";
    }

}
