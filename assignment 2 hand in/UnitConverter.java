//package SE_Ex2;

public abstract class UnitConverter
{

  private String inputUnits = "";
  private String outputUnits = "";

  public UnitConverter() { }
  public abstract double convert(double inValue);
  public abstract String toString();
  public void print(){
    System.out.println(toString());
  }



  public String getInputUnits(){
    return inputUnits;
  }
  public String getOutputUnits(){ return outputUnits; }

  public void setInputUnits(String inString){inputUnits = inString;}
  public void setOutputUnits(String inString){outputUnits = inString;}
};

