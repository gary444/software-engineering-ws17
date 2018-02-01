public class CelsiusToFahrenheitConverter extends TemperatureConverter {


    public CelsiusToFahrenheitConverter(){
        setInputUnits("*C");
        setOutputUnits("*F");
    }

    @Override
    public double convert(double inValue) throws IllegalArgumentException {

        //if lower than absolute zero, throw exception
        if (inValue < -273.15){
            throw new IllegalArgumentException("Value is below minimum possible temperature!");
        }

        return (inValue * 1.8) + 32.0;
    }

    @Override
    public String toString() {
        return "Celsius To Fahrenheit Converter";
    }
}
