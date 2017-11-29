import java.util.HashMap;

public class ConcreteConverterFactory implements AbstractConverterFactory {

    private static final ConcreteConverterFactory INSTANCE = new ConcreteConverterFactory();
    private HashMap<String, UnitConverter> hashMap;

    //private constructor - to implement singleton design pattern
    private ConcreteConverterFactory(){

        //set up hash map
        initMap();
    }

    //get instance method returns only pre-instantiated instance
    public static ConcreteConverterFactory getInstance(){
        return INSTANCE;
    }

    //returns converter of appropriate class
    @Override
    public UnitConverter create(String inString) {

        UnitConverter returnConverter = hashMap.get(inString);
        //TODO - check return converter is not null

        return returnConverter;

    }

    //fill hash map with converters, matched with correct text string
    private void initMap(){

        hashMap = new HashMap<String, UnitConverter>();

        hashMap.put("DollarToEuro", new DollarToEuroConverter());
        hashMap.put("EuroToDollar", new EuroToDollarConverter());
        hashMap.put("CelsiusToFahrenheit", new CelsiusToFahrenheitConverter());
        hashMap.put("FahrenheitToCelsius", new FahrenheitToCelsiusConverter());
        hashMap.put("SquareFootToSquareMeterConverter", new SquareFootToSquareMeterConverter());
        hashMap.put("SquareMeterToSquareFootConverter", new SquareMeterToSquareFootConverter());
    }
}
