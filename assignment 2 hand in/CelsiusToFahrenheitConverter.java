public class CelsiusToFahrenheitConverter extends TemperatureConverter {


    public CelsiusToFahrenheitConverter(){
        setInputUnits("*C");
        setOutputUnits("*F");
    }

    @Override
    public double convert(double inValue) {

        return (inValue * 1.8) + 32.0;
    }

    @Override
    public String toString() {
        return "Celsius To Fahrenheit Converter";
    }
}
