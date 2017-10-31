public class FahrenheitToCelsiusConverter extends TemperatureConverter{

    public FahrenheitToCelsiusConverter(){
        setInputUnits("*F");
        setOutputUnits("*C");
    }

    @Override
    public double convert(double inValue) {

        return (inValue - 32.0) / 1.8;
    }

    @Override
    public String toString() {
        return "Fahrenheit To Celsius Converter";
    }
}
