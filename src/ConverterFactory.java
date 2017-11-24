
//singleton factory class that returns the requested type of unit converter
// ref from: http://coding-geek.com/design-pattern-singleton-prototype-and-builder/
public class ConverterFactory {

    private static ConverterFactory instance = new ConverterFactory();

    //returns pre-initialised instance
    public static ConverterFactory getInstance() {
        return instance;
    }

    //constructor set as private to prevent more than one instance being created
    private ConverterFactory(){ }

    //create method - takes a string and returns the specified type of converter
    //TODO - return null if string is invalid
    public UnitConverter create(String inString){

        //TODO - use Map to return correct converter type
        return new DollarToEuroConverter();
    }
}
