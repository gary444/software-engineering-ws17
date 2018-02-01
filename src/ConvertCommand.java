//implementation of command pattern

public class ConvertCommand implements Command {

    private UnitConverter converter;
    private double valueToConvert;

    public ConvertCommand(UnitConverter newConverter, double newValueToConvert){

        this.converter = newConverter;
        this.valueToConvert = newValueToConvert;
    }

    @Override
    public void execute() {

        try{
            double result = converter.convert(valueToConvert);
            converter.printConversion(valueToConvert, result);
        }
        catch (IllegalArgumentException e){
            System.out.println("Error: " + e.getMessage());
        }


    }
}
