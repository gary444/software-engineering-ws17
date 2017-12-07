//package SE_Ex2;

public class DollarToEuroConverter extends CurrencyConverter
{
  private double DOLLAR_TO_EURO_RATE = 0.86;


  public DollarToEuroConverter() {
    setInputUnits("USD");
    setOutputUnits("EUR");
  }

  public double convert(double inDollars) {

    if(inDollars < 0)
      inDollars = 0;

    return inDollars * DOLLAR_TO_EURO_RATE;
  }

  public String toString(){
    return "Dollar to Euro Converter";
  }

}
