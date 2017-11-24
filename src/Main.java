//package SE_Ex2;

import TinyTestJ.RunTests;

class Main {
  public static void main(String[] args)
  {
    String conversion = args[0];
    String value = args[1];

    //test
    //System.out.println(Double.parseDouble("hello"));

    UnitConverter myConverter;
    double numToConvert;

    //check that input value is a number
    try {
      numToConvert = Double.parseDouble(value);
    }
    catch (NumberFormatException e){
      System.out.println("Invalid input value for converter - not a number!");
      return;
    }


    //determine which conversion method is required
    switch (conversion){
      case "DollarToEuro":
        myConverter = new DollarToEuroConverter();
        break;
      case "EuroToDollar":
        myConverter = new EuroToDollarConverter();
        break;
      case "SquareFootToSquareMeter":
        myConverter = new SquareFootToSquareMeterConverter();
        break;
      case "SquareMeterToSquareFoot":
        myConverter = new SquareMeterToSquareFootConverter();
        break;
      case "CelsiusToFahrenheit":
        myConverter = new CelsiusToFahrenheitConverter();
        break;
      case "FahrenheitToCelsius":
        myConverter = new FahrenheitToCelsiusConverter();
        break;

      default:
        System.out.println("Error: Conversion type not recognised");
        return;

    }

    //calculate output number and format to 2 d.p.
    String outputValue = String.format("%.02f", myConverter.convert(numToConvert));

    //print output string to console
    System.out.println(myConverter.toString() + " has converted " + value + " " + myConverter.getInputUnits() + " to " +
        outputValue + " " + myConverter.getOutputUnits());

  }
}
