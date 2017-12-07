public class EuroToDollarConverter extends CurrencyConverter {

    private double EURO_TO_DOLLAR_RATE = 1.16;

    public EuroToDollarConverter(){
        setInputUnits("EUR");
        setOutputUnits("USD");
    }

    public double convert(double amountInEuros){

        if (amountInEuros < 0)
            amountInEuros = 0;

        return amountInEuros * EURO_TO_DOLLAR_RATE;
    }

    public String toString(){
        return "Euro to Dollar";
    }


}