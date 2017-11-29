//package SE_Ex2;

class Main {
  public static void main(String[] args)
  {
    String conversionString = args[0];
    String value = args[1];

    //create singleton factory instance
    ConverterFactory factory = ConverterFactory.getInstance();

    double numToConvert;

    //check that input value is a number
    try {
      numToConvert = Double.parseDouble(value);
    }
    catch (NumberFormatException e){
      System.out.println("Invalid input value for converter - not a number!");
      return;
    }

    //attempt to create converter with factory
    UnitConverter myConverter = factory.create(conversionString);

    //display options and quit if converter creation fails
    if(myConverter == null){
      System.out.println("\nConversion type not recognised!");
      displayOptions();
      return;
    }

    //calculate output number and format to 2 d.p.
    String outputValue = String.format("%.02f", myConverter.convert(numToConvert));

    //print output string to console
    System.out.println(myConverter.toString() + " has converted " + value + " " + myConverter.getInputUnits() + " to " +
        outputValue + " " + myConverter.getOutputUnits());

  }

  public static void displayOptions(){
    System.out.println("Available conversion commands:");
    System.out.println("- DollarToEuro");
    System.out.println("- EuroToDollar");
    System.out.println("- CelsiusToFahrenheit");
    System.out.println("- FahrenheitToCelsius");
    System.out.println("- SquareFootToSquareMeter");
    System.out.println("- SquareMeterToSquareFoot");
  }
}


