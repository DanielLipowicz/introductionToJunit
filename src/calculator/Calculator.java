package calculator;

/**
 * Created by DLIPOWIC on 6/6/2018.
 */
public class Calculator {
    private static Calculator calculatorInstance =null;

    public static Calculator getInstance(){
        if (calculatorInstance==null) {
            calculatorInstance = new Calculator();
        }
        return calculatorInstance;
    }

    public Calculator(){

    }
    int addNumbers(int firstNumber, int secondNumber){
        return firstNumber+secondNumber;
    }

    int substractNumbers(int firstNumber, int secondNumber){
        return firstNumber-secondNumber;
    }
    int multiplyNumbers(int firstNumber, int secondNumber){
        return firstNumber*secondNumber;
    }
    int divideNumbers(int firstNumber, int secondNumber){
        if (secondNumber==0) throw new RuntimeException("Dividing by Zero is undefined. ( ͡° ͜ʖ ͡°) ");
        return firstNumber/secondNumber;
    }

    boolean isEvenNumber(int number){
        return number%2==0;
    }
}
