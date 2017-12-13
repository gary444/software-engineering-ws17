//package SE_Ex2;
import java.util.LinkedList;
import java.util.Scanner;


class Main {
  public static void main(String[] args)
  {
    //command pattern actors
    LinkedList<Command> commandList = new LinkedList<>();

    Scanner sc = new Scanner(System.in);

    //print initial info
    displayOptions();
    System.out.println("Enter a conversion: (Ctrl-D to quit and print all conversions)");

    while (sc.hasNext()){

      String s = sc.nextLine();
      String[] inputs = s.split("\\s+");

      Command command = null;

      //if there are 3 arguments, a decorator is needed
      if (inputs.length == 3){

        //check for inversion argument
        if (inputs[1].equals("invert")){

          command = invertedCalculation(inputs[0], inputs[2]);
        }
        //if not inversion, attempt to link converters
        else {

          command = linkedCalculation(inputs[0], inputs[1], inputs[2]);
        }
      }
      //if just 2 arguments, do basic conversion
      else if (inputs.length == 2){

        command = basicCalculation(inputs[0], inputs[1]);
      }
      else {
        System.out.println("Invalid Input.");
      }

      //add command to list unless it is null
      if (command != null)
        commandList.add(command);

      System.out.println("Enter a conversion: (Ctrl-D to quit and print all conversions)");

    }
    //end test scanner loop=====================================================

    convertAndPrintAll(commandList);


  }


  //takes two strings describing conversion types,
  // and another string describing a string value
  // returns a command for a linked conversion or
  // returns null if arguments are invalid
  public static Command linkedCalculation(String conversion1String, String conversion2String, String value){

    double numToConvert;

    //input value validation
    if (validateNumString(value))
      numToConvert = Double.parseDouble(value);
    else
      return null;

    //attempt to create converter with factory
    ConverterFactory factory = ConverterFactory.getInstance();
    UnitConverter myConverter1 = factory.create(conversion1String);
    UnitConverter myConverter2 = factory.create(conversion2String);

    //display options if converter creation fails
    if(myConverter1 == null || myConverter2 == null){
      System.out.println("\nConversion type not recognised!");
      displayOptions();
      return null;
    }

    //create converter decorator to allow linking
    LinkedConverter linkedConverter = new LinkedConverter(myConverter1);

    //check that these converters can be linked without an exception
    try {
      linkedConverter.link(myConverter2);
    }
    catch (IllegalArgumentException e){
      System.out.println(e.getMessage());
      return null;
    }

    //create command
    Command command = new ConvertCommand(linkedConverter, numToConvert);
    return command;
  }

  //takes one string describing a conversion type,
  // and another string describing a string value
  // returns a command for a inverted conversion or
  // returns null if arguments are invalid
  public static Command invertedCalculation(String converterString, String value) {

    double numToConvert;

    //input value validation
    if (validateNumString(value))
      numToConvert = Double.parseDouble(value);
    else
      return null;


    ConverterFactory factory = ConverterFactory.getInstance();
    UnitConverter myConverter = factory.create(converterString);

    //display options if converter creation fails
    if(myConverter == null){
      System.out.println("\n - Conversion type not recognised! - ");
      displayOptions();
      return null;
    }

    //check that inversion converter can be used - will throw an exception if not
    InversionConverter inversionConverter = null;
    try {
      inversionConverter = new InversionConverter(myConverter);
    }
    catch (IllegalArgumentException e){
      System.out.println(e.getMessage());
      return null;
    }

    Command command = new ConvertCommand(inversionConverter, numToConvert);
    return command;

  }

  //takes one string describing a conversion type,
  // and another string describing a string value
  // returns a command for a basic conversion or
  // returns null if arguments are invalid
  public static Command basicCalculation(String converterString, String value){

    double numToConvert;

    //input value validation
    if (validateNumString(value))
      numToConvert = Double.parseDouble(value);
    else
      return null;

    //attempt to create converter with factory
    ConverterFactory factory = ConverterFactory.getInstance();
    UnitConverter myConverter = factory.create(converterString);

    //display options if converter creation fails
    if(myConverter == null){
      System.out.println("\nConversion type not recognised!");
      displayOptions();
      return null;
    }

    Command command = new ConvertCommand(myConverter, numToConvert);
    return command;
  }

  //executes all conversions and prints results
  public static void convertAndPrintAll(LinkedList<Command> commandList){

    Invoker invoker = new Invoker();

    System.out.println("---------------------------------------");
    //cycle through command list and execute each command
    for (int i = 0; i < commandList.size(); i++){

      System.out.print("(" + i + "): ");
      invoker.execute(commandList.get(i));
    }
    System.out.println("---------------------------------------");
    System.out.println("Conversion program ended.");
  }

  //validates that a string can be converted safely to a double  - returns true if so
  public static boolean validateNumString(String inString){

    //input value validation
    try {
      double num = Double.parseDouble(inString);
    }
    catch (NumberFormatException e){
      System.out.println(" - Input number not valid - ");
      return false;
    }


    return true;

  }

  //displays all options as text to the user
  public static void displayOptions(){
    System.out.println("Available conversion commands:");
    System.out.println("- DollarToEuro");
    System.out.println("- EuroToDollar");
    System.out.println("- PoundToEuro");
    System.out.println("- EuroToPound");
    System.out.println("- CelsiusToFahrenheit");
    System.out.println("- FahrenheitToCelsius");
    System.out.println("- SquareFootToSquareMeter");
    System.out.println("- SquareMeterToSquareFoot");
    System.out.println("-------------------------");
    System.out.println("- To invert enter 'invert' after name of converter, e.g.");
    System.out.println("- 'java Main EuroToDollar invert 1000");
    System.out.println("-------------------------");
    System.out.println("- To chain converters enter two converter names, e.g.");
    System.out.println("- 'java Main EuroToDollar PoundToEuro 1000");
    System.out.println("- this will convert from pound > euro > dollar\n\n");

  }
}