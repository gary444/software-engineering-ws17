public class InversionConverter extends ConverterDecorator{

    public InversionConverter(UnitConverter converterToDecorate){

        super(converterToDecorate);

        //check that converterToDecorate is not a temperature converter
        if (converterToDecorate instanceof TemperatureConverter){
            System.err.println("Cannot use 'invert' for temperature conversions!!");
            System.exit(0);
        }

    }

    public double convert(double inValue){

        //determine inverse factor by converting 1 and taking reciprocal
        double invFactor = super.convert(1.0);
        invFactor = 1.0 / invFactor;

        return inValue * invFactor;
    }

    @Override
    public void printConversion(double inputValue, double convertedValue) {
        //super.printConversion(inputValue, convertedValue);

        //System.out.println("Inverted conversion printing...!!!");

        //format num value
        String outputValue = String.format("%.02f", convertedValue);

        System.out.println(converterToDecorate.toString() + " has converted " + inputValue + " " + this.getOutputUnits() + " to " +
                outputValue + " " + this.getInputUnits() );
    }
}
