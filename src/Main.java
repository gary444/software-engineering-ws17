//package SE_Ex2;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;


class Main {
  public static void main(String[] args)
  {

    //create singleton factory instance
    ConverterFactory factory = ConverterFactory.getInstance();

    //command pattern actors
    LinkedList<Command> commandList = new LinkedList<>();
    Invoker invoker = new Invoker();

    String conversion1String;
    String conversion2String;
    String value;
    double numToConvert = 0.0;


    displayOptions();

    //test scanner loop=====================================================
    Scanner sc = new Scanner(System.in);
    while (sc.hasNext()){
      System.out.println("Enter a conversion:");

      String s = sc.nextLine();
      String[] inputs = s.split("\\s+");

      conversion1String = inputs[0];



      //if there are 3 arguments, a decorator is needed
      if (inputs.length == 3){

        //check for inversion argument
        if (inputs[1].equals("invert")){

          value = inputs[2];

          //input value validation
          try {
            numToConvert = toNumber(value);
          }
          catch (NumberFormatException e){
            System.out.println(" - Input number not valid - ");
            continue;
          }

          UnitConverter myConverter = factory.create(conversion1String);

          //display options and quit if converter creation fails
          if(myConverter == null){
            System.out.println("\n - Conversion type not recognised! - ");
            displayOptions();
            continue;
          }

          InversionConverter inversionConverter = new InversionConverter(myConverter);
          Command command = new ConvertCommand(inversionConverter, numToConvert);
          commandList.add(command);


        }
        //if not inversion, attempt to link converters
        else {

          conversion2String = inputs[1];
          value = inputs[2];

          //input value validation
          try {
            numToConvert = toNumber(value);
          }
          catch (NumberFormatException e){
            System.out.println(" - Input number not valid - ");
            continue;
          }

          //attempt to create converter with factory
          UnitConverter myConverter1 = factory.create(conversion1String);
          UnitConverter myConverter2 = factory.create(conversion2String);

          //display options if converter creation fails
          if(myConverter1 == null || myConverter2 == null){
            System.out.println("\nConversion type not recognised!");
            displayOptions();
            continue;
          }


          //create converter decorator to allow linking
          LinkedConverter linkedConverter = new LinkedConverter(myConverter1);
          linkedConverter.link(myConverter2);

          //create and invoke command
          Command command = new ConvertCommand(linkedConverter, numToConvert);
          commandList.add(command);

        }

      }
      //if just 2 arguments, do normal conversion
      else if (inputs.length == 2){

        value = inputs[1];

        //input value validation
        try {
          numToConvert = toNumber(value);
        }
        catch (NumberFormatException e){
          System.out.println(" - Input number not valid - ");

        }

        //attempt to create converter with factory
        UnitConverter myConverter = factory.create(conversion1String);

        //display options if converter creation fails
        if(myConverter == null){
          System.out.println("\nConversion type not recognised!");
          displayOptions();
          continue;
        }

        Command command = new ConvertCommand(myConverter, numToConvert);
        commandList.add(command);

      }

    }
    //end test scanner loop=====================================================

    //cycle through command list and execute each command
    for (int i = 0; i < commandList.size(); i++){

      invoker.execute(commandList.get(i));
    }

    System.out.println("Conversion program ended.");

  }

  //converts input, and validates that input string is a number
  public static double toNumber(String inString) throws NumberFormatException {

    double numToConvert = 0.0;

    numToConvert = Double.parseDouble(inString);

    return numToConvert;
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


