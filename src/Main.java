//package SE_Ex2;

class Main {
  public static void main(String[] args)
  {
    String conversionString = args[0];
    String value = args[1];


    //create factory instance
    //ConverterFactoryV1 factory = ConverterFactoryV1.getInstance();
    UnitConverter myConverter;

    ConverterFactoryV2 factory = new ConcreteConverterFactory();

    double numToConvert;

    //check that input value is a number
    try {
      numToConvert = Double.parseDouble(value);
    }
    catch (NumberFormatException e){
      System.out.println("Invalid input value for converter - not a number!");
      return;
    }


    //create converter with factory - original attempt
    //myConverter = ConverterFactoryV1.create(conversion);

    myConverter = factory.create(conversionString);



//    // assignment 2 method
//    //determine which conversion method is required
//    switch (conversion){
//      case "DollarToEuro":
//        myConverter = new DollarToEuroConverter();
//        break;
//      case "EuroToDollar":
//        myConverter = new EuroToDollarConverter();
//        break;
//      case "SquareFootToSquareMeter":
//        myConverter = new SquareFootToSquareMeterConverter();
//        break;
//      case "SquareMeterToSquareFoot":
//        myConverter = new SquareMeterToSquareFootConverter();
//        break;
//      case "CelsiusToFahrenheit":
//        myConverter = new CelsiusToFahrenheitConverter();
//        break;
//      case "FahrenheitToCelsius":
//        myConverter = new FahrenheitToCelsiusConverter();
//        break;
//
//      default:
//        System.out.println("Error: Conversion type not recognised");
//        return;
//
//    }

    //calculate output number and format to 2 d.p.
    String outputValue = String.format("%.02f", myConverter.convert(numToConvert));

    //print output string to console
    System.out.println(myConverter.toString() + " has converted " + value + " " + myConverter.getInputUnits() + " to " +
        outputValue + " " + myConverter.getOutputUnits());

  }
}
