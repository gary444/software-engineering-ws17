import TinyTestJ.Test;

import static TinyTestJ.Assert.*;

public class TestSuite {

  private  static UnitConverter testConverter;
  private static double result;

  private static ConverterFactory factory = ConverterFactory.getInstance();



  //====================================================================
//  //factory testing
  @Test public static void FTest1() {
    testConverter = factory.create("DollarToEuro");
    assertEquals(new DollarToEuroConverter(),testConverter);
  }

  @Test public static void FTest2() {
    testConverter = factory.create("EuroToDollar");
    assertEquals(new EuroToDollarConverter(),testConverter);
  }

  @Test public static void FTest3() {
    testConverter = factory.create("CelsiusToFahrenheit");
    assertEquals(new CelsiusToFahrenheitConverter(),testConverter);
  }

  @Test public static void FTest4() {
    testConverter = factory.create("FahrenheitToCelsius");
    assertEquals(new FahrenheitToCelsiusConverter(),testConverter);
  }

  @Test public static void FTest5() {
    testConverter = factory.create("SquareFootToSquareMeter");
    assertEquals(new SquareFootToSquareMeterConverter(),testConverter);
  }

  @Test public static void FTest6() {
    testConverter = factory.create("SquareMeterToSquareFoot");
    assertEquals(new SquareMeterToSquareFootConverter(),testConverter);
  }

  //erroneous input tests - factory should return null object
  @Test public static void FTest7() {
    testConverter = factory.create("hd ha");
    assertEquals(null,testConverter);
  }

  @Test public static void FTest8() {
    testConverter = factory.create(null);
    assertEquals(null,testConverter);
  }

  @Test public static void FTest9() {
    testConverter = factory.create("");
    assertEquals(null,testConverter);
  }




  //====================================================================
  // Dollar To Euro
  @Test public static void DETest1() {
    testConverter = new DollarToEuroConverter();
    result = testConverter.convert(10000);
    assertEquals(8600,result,0.001);
  }
  @Test public static void DETest2() {
    testConverter = new DollarToEuroConverter();
    result = testConverter.convert(-10000);
    assertEquals(0,result,0.001);
  }

  @Test public static void DETest3() {
    testConverter = new DollarToEuroConverter();
    result = testConverter.convert(-0);
    assertEquals(0,result,0.001);
  }

  //====================================================================
  // Euro To Dollar
  @Test public static void EDTest1() {
    testConverter = new EuroToDollarConverter();
    result = testConverter.convert(10);
    assertEquals(11.6,result,0.001);
  }

  @Test public static void EDTest2() {
    testConverter = new EuroToDollarConverter();
    result = testConverter.convert(-499);
    assertEquals(0,result,0.001);
  }

  @Test public static void EDTest3() {
    testConverter = new EuroToDollarConverter();
    result = testConverter.convert(1000000);
    assertEquals(1160000,result,0.001);
  }

  //====================================================================
  // Square Meter to Square Foot
  @Test public static void SM_SF_Test1() {
    testConverter = new SquareMeterToSquareFootConverter();
    result = testConverter.convert(-4);
    assertEquals(0, result, 0.001);
  }

  @Test public static void SM_SF_Test2() {
    testConverter = new SquareMeterToSquareFootConverter();
    result = testConverter.convert(200);
    assertEquals(2152, result, 0.001);
  }

  @Test public static void SM_SF_Test3() {
    testConverter = new SquareMeterToSquareFootConverter();
    result = testConverter.convert(-0);
    assertEquals(0, result, 0.001);
  }

  //====================================================================
  // Square Foot to Square Meter

  @Test public static void SF_SM_Test1() {
    testConverter = new SquareFootToSquareMeterConverter();
    result = testConverter.convert(-0);
    assertEquals(0, result, 0.001);
  }

  @Test public static void SF_SM_Test2() {
    testConverter = new SquareFootToSquareMeterConverter();
    result = testConverter.convert(600);
    assertEquals(55.8, result, 0.001);
  }

  @Test public static void SF_SM_Test3() {
    testConverter = new SquareFootToSquareMeterConverter();
    result = testConverter.convert(-100000);
    assertEquals(0, result, 0.001);
  }


  //====================================================================
  // celsius to fahrenheit
  @Test public static void CFTest1() {
    testConverter = new CelsiusToFahrenheitConverter();
    result = testConverter.convert(40);
    assertEquals(104, result, 0.001);
  }

  @Test public static void CFTest2() {
    testConverter = new CelsiusToFahrenheitConverter();
    result = testConverter.convert(-50);
    assertEquals(-58, result, 0.001);
  }

  @Test public static void CFTest3() {
    testConverter = new CelsiusToFahrenheitConverter();
    result = testConverter.convert(-0);
    assertEquals(32, result, 0.001);
  }


  //====================================================================
  // fahrenheit to celsius

  @Test public static void FCTest1() {
    testConverter = new FahrenheitToCelsiusConverter();
    result = testConverter.convert(-40);
    assertEquals(-40, result, 0.001);
  }

  @Test public static void FCTest2() {
    testConverter = new FahrenheitToCelsiusConverter();
    result = testConverter.convert(-0);
    assertEquals(-17.7777, result, 0.001);
  }

  @Test public static void FCTest3() {
    testConverter = new FahrenheitToCelsiusConverter();
    result = testConverter.convert(100);
    assertEquals(37.7777, result, 0.001);
  }




}
