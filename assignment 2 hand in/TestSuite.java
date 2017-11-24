import TinyTestJ.Test;
import static TinyTestJ.Assert.*;

public class TestSuite {


  //====================================================================
  // Dollar To Euro
  @Test public static void DETest1() {
    UnitConverter test = new DollarToEuroConverter();
    double result = test.convert(10000);
    assertEquals(8600,result,0.001);
  }
  @Test public static void DETest2() {
    UnitConverter test = new DollarToEuroConverter();
    double result = test.convert(-10000);
    assertEquals(0,result,0.001);
  }

  @Test public static void DETest3() {
    UnitConverter test = new DollarToEuroConverter();
    double result = test.convert(-0);
    assertEquals(0,result,0.001);
  }

  //====================================================================
  // Euro To Dollar
  @Test public static void EDTest1() {
    UnitConverter test = new EuroToDollarConverter();
    double result = test.convert(10);
    assertEquals(11.6,result,0.001);
  }

  @Test public static void EDTest2() {
    UnitConverter test = new EuroToDollarConverter();
    double result = test.convert(-499);
    assertEquals(0,result,0.001);
  }

  @Test public static void EDTest3() {
    UnitConverter test = new EuroToDollarConverter();
    double result = test.convert(1000000);
    assertEquals(1160000,result,0.001);
  }

  //====================================================================
  // Square Meter to Square Foot
  @Test public static void SM_SF_Test1() {
    UnitConverter test = new SquareMeterToSquareFootConverter();
    double result = test.convert(-4);
    assertEquals(0, result, 0.001);
  }

  @Test public static void SM_SF_Test2() {
    UnitConverter test = new SquareMeterToSquareFootConverter();
    double result = test.convert(200);
    assertEquals(2152, result, 0.001);
  }

  @Test public static void SM_SF_Test3() {
    UnitConverter test = new SquareMeterToSquareFootConverter();
    double result = test.convert(-0);
    assertEquals(0, result, 0.001);
  }

  //====================================================================
  // Square Foot to Square Meter

  @Test public static void SF_SM_Test1() {
    UnitConverter test = new SquareFootToSquareMeterConverter();
    double result = test.convert(-0);
    assertEquals(0, result, 0.001);
  }

  @Test public static void SF_SM_Test2() {
    UnitConverter test = new SquareFootToSquareMeterConverter();
    double result = test.convert(600);
    assertEquals(55.8, result, 0.001);
  }

  @Test public static void SF_SM_Test3() {
    UnitConverter test = new SquareFootToSquareMeterConverter();
    double result = test.convert(-100000);
    assertEquals(0, result, 0.001);
  }


  //====================================================================
  // celsius to fahrenheit
  @Test public static void CFTest1() {
    UnitConverter test = new CelsiusToFahrenheitConverter();
    double result = test.convert(40);
    assertEquals(104, result, 0.001);
  }

  @Test public static void CFTest2() {
    UnitConverter test = new CelsiusToFahrenheitConverter();
    double result = test.convert(-50);
    assertEquals(-58, result, 0.001);
  }

  @Test public static void CFTest3() {
    UnitConverter test = new CelsiusToFahrenheitConverter();
    double result = test.convert(-0);
    assertEquals(32, result, 0.001);
  }


  //====================================================================
  // fahrenheit to celsius

  @Test public static void FCTest1() {
    UnitConverter test = new FahrenheitToCelsiusConverter();
    double result = test.convert(-40);
    assertEquals(-40, result, 0.001);
  }

  @Test public static void FCTest2() {
    UnitConverter test = new FahrenheitToCelsiusConverter();
    double result = test.convert(-0);
    assertEquals(-17.7777, result, 0.001);
  }

  @Test public static void FCTest3() {
    UnitConverter test = new FahrenheitToCelsiusConverter();
    double result = test.convert(100);
    assertEquals(37.7777, result, 0.001);
  }




}
