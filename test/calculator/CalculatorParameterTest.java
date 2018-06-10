package calculator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Parameterized.Parameter;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class CalculatorParameterTest {
//    @Parameters
//    public static Collection<Integer> data(){
//        Integer data[] = {1,2,3,4};
//        return Arrays.asList(data);
//    }
//
//    @Parameter
//    public int evenNumber;
//
//    @Test
//    public void isEvenNumber(){
//        Assert.assertTrue(Calculator.getInstance().isEvenNumber(evenNumber));
//    }

    @Parameters
    public static Collection<Object[]> arrayData(){
        Integer data[][] = {{1,2,3},{3,4,7},{10,20,30},{30,40,70}};
        return Arrays.asList(data);
    }

    @Parameter
    public int firsNumber;
    @Parameter(1)
    public int secondNumber;
    @Parameter(2)
    public int sumOfNumber;

    @Test
    public void checkSumMethod(){
        System.out.println(firsNumber);
        System.out.println(secondNumber);
        System.out.println(sumOfNumber);

        Assert.assertEquals(sumOfNumber,Calculator.getInstance().addNumbers(firsNumber,secondNumber));
    }
}
