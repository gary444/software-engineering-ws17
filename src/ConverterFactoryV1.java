
//singleton factory class that returns the requested type of unit converter
// ref from: http://coding-geek.com/design-pattern-singleton-prototype-and-builder/
public abstract class ConverterFactoryV1 {

    //private static ConverterFactoryV1 instance = new ConverterFactoryV1();

    //returns pre-initialised instance
//    public static ConverterFactoryV1 getInstance() {
//        return instance;
//    }

    //constructor set as private to prevent more than one instance being created
    //private ConverterFactoryV1(){ }

    //create method - takes a string and returns the specified type of converter
    //TODO - return null/throw error if string is invalid
    public static UnitConverter create(String inString){

        //TODO - use Map to return correct converter type
        return new DollarToEuroConverter();
    }
}
