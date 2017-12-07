//package SE_Ex2;

public abstract class AbstractUnitConverter implements UnitConverter
{

  private String inputUnits = "";
  private String outputUnits = "";

  //public AbstractUnitConverter() { }
  public void print(){
    System.out.println(toString());
  }


  //common method implementation for all unit converters
  public String getInputUnits(){
    return inputUnits;
  }
  public String getOutputUnits(){ return outputUnits; }

  public void setInputUnits(String inString){inputUnits = inString;}
  public void setOutputUnits(String inString){outputUnits = inString;}
};

