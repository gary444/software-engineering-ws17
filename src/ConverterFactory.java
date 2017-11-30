import java.util.HashMap;

public class ConverterFactory {

    private static final ConverterFactory INSTANCE = new ConverterFactory();
    private HashMap<String, UnitConverter> hashMap;

    //private constructor - to implement singleton design pattern
    private ConverterFactory(){

        //set up hash map
        initMap();
    }

    //get instance method returns only pre-instantiated instance
    public static ConverterFactory getInstance(){
        return INSTANCE;
    }

    //returns converter of appropriate class
    //may return null object if string does not match
    public UnitConverter create(String inString) {
        return hashMap.get(inString);
    }

    //fill hash map with converters, matched with correct text string
    private void initMap(){

        hashMap = new HashMap<String, UnitConverter>();

        hashMap.put("DollarToEuro", new DollarToEuroConverter());
        hashMap.put("EuroToDollar", new EuroToDollarConverter());
        hashMap.put("CelsiusToFahrenheit", new CelsiusToFahrenheitConverter());
        hashMap.put("FahrenheitToCelsius", new FahrenheitToCelsiusConverter());
        hashMap.put("SquareFootToSquareMeter", new SquareFootToSquareMeterConverter());
        hashMap.put("SquareMeterToSquareFoot", new SquareMeterToSquareFootConverter());



    }
}
