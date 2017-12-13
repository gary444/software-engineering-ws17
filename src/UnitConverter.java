public interface UnitConverter {

    double convert(double inValue);
    String toString();

    void printConversion(double inputValue, double convertedValue);

    void print();

    String getInputUnits();
    String getOutputUnits();

    void setInputUnits(String inString);
    void setOutputUnits(String inString);
}
