public class EuroToPoundConverter extends CurrencyConverter {

    private double EURO_TO_POUND_RATE = 0.88;

    public EuroToPoundConverter(){
        setInputUnits("EUR");
        setOutputUnits("GBP");
    }

    public double convert(double amountInEuros){

        if (amountInEuros < 0)
            amountInEuros = 0;

        return amountInEuros * EURO_TO_POUND_RATE;
    }

    public String toString(){
        return "Euro to Pound Converter";
    }
}
