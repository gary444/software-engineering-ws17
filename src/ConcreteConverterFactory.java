import java.util.HashMap;

public class ConcreteConverterFactory implements ConverterFactoryV2 {

    HashMap<String, UnitConverter> hashMap;

    public ConcreteConverterFactory(){


        //set up hash map
        initMap();
    }

    //returns converter of appropriate class
    @Override
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
        hashMap.put("SquareFootToSquareMeterConverter", new SquareFootToSquareMeterConverter());
        hashMap.put("SquareMeterToSquareFootConverter", new SquareMeterToSquareFootConverter());


    }
}
