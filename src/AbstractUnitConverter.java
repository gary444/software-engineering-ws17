//package SE_Ex2;

public abstract class AbstractUnitConverter implements UnitConverter
{

  private String inputUnits = "";
  private String outputUnits = "";

  //public AbstractUnitConverter() { }
  public void print(){
    System.out.println(toString());
  }

  //this method prints a string describing the conversion
  public void printConversion(double inputValue, double convertedValue){

    //format num value
    String outputValue = String.format("%.02f", convertedValue);

    System.out.println(this.toString() + " has converted " + inputValue + " " + this.getInputUnits() + " to " +
            outputValue + " " + this.getOutputUnits());

  }

  //common method implementation for all unit converters
  public String getInputUnits(){
    return inputUnits;
  }
  public String getOutputUnits(){ return outputUnits; }

  public void setInputUnits(String inString){inputUnits = inString;}
  public void setOutputUnits(String inString){outputUnits = inString;}
};

