public class FahrenheitToCelsiusConverter extends TemperatureConverter{

    public FahrenheitToCelsiusConverter(){
        setInputUnits("*F");
        setOutputUnits("*C");
    }

    @Override
    public double convert(double inValue) throws IllegalArgumentException {

        if(inValue < -459.67) {
            throw new IllegalArgumentException("Value is below minimum possible temperature!");
        }

        return (inValue - 32.0) / 1.8;
    }

    @Override
    public String toString() {
        return "Fahrenheit To Celsius Converter";
    }
}
