package calculator;

import org.junit.*;

public class CalculatorTest {
    static Calculator calculator;
    static int i;

    @BeforeClass
    public static void prepareEnvironment() {
        // Here is a place when you should prepare "environment" for test
        // i.e. get instances of utils class
        // in case of UI automation test here is a place for database connection etc.
        calculator = Calculator.getInstance();
        i=0;
    }
    @Before
    public void showHowManyTestExecuted(){
        //Here is a place when you should contain action executed before each test.
        // i.e. test data prepare
        i+=1;
    }

    @AfterClass
    public static void showLogAboutTests(){
        //Here is the place when you could perform action connected with @BeforeClass method
        //It will be executed after all tests
        System.out.println("We've executed "+ i + " test cases.");
    }

    @Test
    public void checkIsNumberEven() {
        //when I check my number
        boolean isMyNumberEven = calculator.isEvenNumber(2);
        //then my number should be even
        Assert.assertTrue(isMyNumberEven);
    }

    @Test
    @Ignore
    public void checkIsNumberEvenWithFail() {
        //when I check my number
        boolean isMyNumberEven = calculator.isEvenNumber(2);
        //then my number should be even
        Assert.assertFalse(isMyNumberEven);
    }

    @Test
    public void checkIsNumberNotEven() {
        //when I check my number
        boolean isMyNumberEven = calculator.isEvenNumber(1);
        //then my number should not be even
        Assert.assertFalse(isMyNumberEven);
    }

    @Test
    public void checkIsSumCorrectly() {
        //given I have two number 2, 5
        int firstNumber = 2;
        int secondNumber = 5;
        //when I add my number in calculator class
        int result = calculator.addNumbers(2, 5);
        //then result should be correct
        Assert.assertEquals(7, result);
    }

    @Test
    public void twoInstanceOfCalculatorShouldNotBeSame(){
        //when I get two instance
        Calculator calc1 = new Calculator();
        Calculator calc2 = new Calculator();
        //Then they should be different objects
        Assert.assertNotSame(calc1,calc2);
    }

    @Test
    public void twoCalculatorsFromSingletonShouldBeSame(){
        //when I get two object form singleton pattern
        Calculator calc1 = Calculator.getInstance();
        Calculator calc2 = Calculator.getInstance();
        //Then they should be the same objects
        Assert.assertSame(calc1,calc2);
    }

    @Test(expected = RuntimeException.class)
    public void divideByZeroShouldThrowException(){
        //When I have number
        int firstNumber = 2;
        //Then I try to divide by zero and I should get exception
        calculator.divideNumbers(firstNumber, 0);

    }
}
