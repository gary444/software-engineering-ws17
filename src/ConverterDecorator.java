abstract class ConverterDecorator implements UnitConverter {

   protected UnitConverter converterToDecorate;

   public ConverterDecorator(UnitConverter newConvToDecorate){
       this.converterToDecorate = newConvToDecorate;
   }


   // pass on all functionality from unit converter to held instance of unit converter
    @Override
    public double convert(double inValue) {
        return converterToDecorate.convert(inValue);
    }


    @Override
    public void printConversion(double inputValue, double convertedValue) {
        converterToDecorate.printConversion(inputValue, convertedValue);
    }

    @Override
    public void print() {
        converterToDecorate.print();
    }

    @Override
    public String getInputUnits() {
        return converterToDecorate.getInputUnits();
    }

    @Override
    public String getOutputUnits() {
        return converterToDecorate.getOutputUnits();
    }

    @Override
    public void setInputUnits(String inString) {
        converterToDecorate.setInputUnits(inString);
    }

    @Override
    public void setOutputUnits(String inString) {
        converterToDecorate.setOutputUnits(inString);
    }
}
