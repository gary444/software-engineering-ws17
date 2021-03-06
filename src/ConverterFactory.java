import java.util.HashMap;

public class ConverterFactory {

    private static final ConverterFactory INSTANCE = new ConverterFactory();
    private HashMap<String, AbstractUnitConverter> hashMap;

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
    public AbstractUnitConverter create(String inString) {
        return hashMap.get(inString);
    }

    //fill hash map with converters, matched with correct text string
    private void initMap(){

        hashMap = new HashMap<String, AbstractUnitConverter>();

        hashMap.put("DollarToEuro", new DollarToEuroConverter());
        hashMap.put("EuroToDollar", new EuroToDollarConverter());
        hashMap.put("EuroToPound", new EuroToPoundConverter());
        hashMap.put("PoundToEuro", new PoundToEuroConverter());
        hashMap.put("CelsiusToFahrenheit", new CelsiusToFahrenheitConverter());
        hashMap.put("FahrenheitToCelsius", new FahrenheitToCelsiusConverter());
        hashMap.put("SquareFootToSquareMeter", new SquareFootToSquareMeterConverter());
        hashMap.put("SquareMeterToSquareFoot", new SquareMeterToSquareFootConverter());



    }
}
