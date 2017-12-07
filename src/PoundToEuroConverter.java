public class PoundToEuroConverter extends CurrencyConverter{

    private double POUND_TO_EURO_RATE = 1.14;


    public PoundToEuroConverter() {
        setInputUnits("GBP");
        setOutputUnits("EUR");
    }

    public double convert(double inPounds) {

        if(inPounds < 0)
            inPounds = 0;

        return inPounds * POUND_TO_EURO_RATE;
    }

    public String toString(){
        return "Pound to Euro Converter";
    }
}
