public class LinkedConverter extends ConverterDecorator {

    private UnitConverter inputConverter;

    public LinkedConverter(UnitConverter newConvToDecorate){
        super(newConvToDecorate);

        //System.out.println("linked converter created with conv of type :" + newConvToDecorate.toString());

    }

    public void link(UnitConverter convToLink){

        //compare output units of linked converter with
        // input units of this converter
        // if they don't match...return error!

        String linkOut = convToLink.getOutputUnits();
        String linkIn = this.converterToDecorate.getInputUnits();

        if (!linkOut.equals(linkIn)) {
            System.out.println("Linked converters do not match!");
            System.exit(0);
        }

        this.inputConverter = convToLink;
    }

    @Override
    public double convert(double inValue) {

        //convert with linked converter first
        double result = inputConverter.convert(inValue);


        //then convert value with own converter
        return super.convert(result);

    }

    @Override
    public void printConversion(double inputValue, double convertedValue) {

        //calculate output number and format to 2 d.p.
        String outputValue = String.format("%.02f", convertedValue);

        //print output string to console
        System.out.println(inputConverter.toString() + " and " + converterToDecorate.toString() + " have converted "
                + inputValue + " " + inputConverter.getInputUnits() + " to "
                + outputValue + " " + converterToDecorate.getOutputUnits());
    }
}
