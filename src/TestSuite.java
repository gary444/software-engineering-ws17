import TinyTestJ.Test;
import static TinyTestJ.Assert.*;

public class TestSuite {

  private  static UnitConverter test;
  private static double result;

  //====================================================================
  // Dollar To Euro
  @Test public static void DETest1() {
    test = new DollarToEuroConverter();
    result = test.convert(10000);
    assertEquals(8600,result,0.001);
  }
  @Test public static void DETest2() {
    test = new DollarToEuroConverter();
    result = test.convert(-10000);
    assertEquals(0,result,0.001);
  }

  @Test public static void DETest3() {
    test = new DollarToEuroConverter();
    result = test.convert(-0);
    assertEquals(0,result,0.001);
  }

  //====================================================================
  // Euro To Dollar
  @Test public static void EDTest1() {
    test = new EuroToDollarConverter();
    result = test.convert(10);
    assertEquals(11.6,result,0.001);
  }

  @Test public static void EDTest2() {
    test = new EuroToDollarConverter();
    result = test.convert(-499);
    assertEquals(0,result,0.001);
  }

  @Test public static void EDTest3() {
    test = new EuroToDollarConverter();
    result = test.convert(1000000);
    assertEquals(1160000,result,0.001);
  }

  //====================================================================
  // Square Meter to Square Foot
  @Test public static void SM_SF_Test1() {
    test = new SquareMeterToSquareFootConverter();
    result = test.convert(-4);
    assertEquals(0, result, 0.001);
  }

  @Test public static void SM_SF_Test2() {
    test = new SquareMeterToSquareFootConverter();
    result = test.convert(200);
    assertEquals(2152, result, 0.001);
  }

  @Test public static void SM_SF_Test3() {
    test = new SquareMeterToSquareFootConverter();
    result = test.convert(-0);
    assertEquals(0, result, 0.001);
  }

  //====================================================================
  // Square Foot to Square Meter

  @Test public static void SF_SM_Test1() {
    test = new SquareFootToSquareMeterConverter();
    result = test.convert(-0);
    assertEquals(0, result, 0.001);
  }

  @Test public static void SF_SM_Test2() {
    test = new SquareFootToSquareMeterConverter();
    result = test.convert(600);
    assertEquals(55.8, result, 0.001);
  }

  @Test public static void SF_SM_Test3() {
    test = new SquareFootToSquareMeterConverter();
    result = test.convert(-100000);
    assertEquals(0, result, 0.001);
  }


  //====================================================================
  // celsius to fahrenheit
  @Test public static void CFTest1() {
    test = new CelsiusToFahrenheitConverter();
    result = test.convert(40);
    assertEquals(104, result, 0.001);
  }

  @Test public static void CFTest2() {
    test = new CelsiusToFahrenheitConverter();
    result = test.convert(-50);
    assertEquals(-58, result, 0.001);
  }

  @Test public static void CFTest3() {
    test = new CelsiusToFahrenheitConverter();
    result = test.convert(-0);
    assertEquals(32, result, 0.001);
  }


  //====================================================================
  // fahrenheit to celsius

  @Test public static void FCTest1() {
    test = new FahrenheitToCelsiusConverter();
    result = test.convert(-40);
    assertEquals(-40, result, 0.001);
  }

  @Test public static void FCTest2() {
    test = new FahrenheitToCelsiusConverter();
    result = test.convert(-0);
    assertEquals(-17.7777, result, 0.001);
  }

  @Test public static void FCTest3() {
    test = new FahrenheitToCelsiusConverter();
    result = test.convert(100);
    assertEquals(37.7777, result, 0.001);
  }




}
