//package SE_Ex2;

class Main {
  public static void main(String[] args)
  {
    String conversionString = args[0];
    String value = args[1];


    //create factory instance
    //ConverterFactoryV1 factory = ConverterFactoryV1.getInstance();
    //AbstractConverterFactory factory = new ConcreteConverterFactory();
    UnitConverter myConverter;

    AbstractConverterFactory factory = ConcreteConverterFactory.getInstance();

    double numToConvert;

    //check that input value is a number
    try {
      numToConvert = Double.parseDouble(value);
    }
    catch (NumberFormatException e){
      System.out.println("Invalid input value for converter - not a number!");
      return;
    }


    //create converter with factory
    //myConverter = ConverterFactoryV1.create(conversion);
    myConverter = factory.create(conversionString);

    //TODO - check factory is not null?


    //calculate output number and format to 2 d.p.
    String outputValue = String.format("%.02f", myConverter.convert(numToConvert));

    //print output string to console
    System.out.println(myConverter.toString() + " has converted " + value + " " + myConverter.getInputUnits() + " to " +
        outputValue + " " + myConverter.getOutputUnits());

  }
}
