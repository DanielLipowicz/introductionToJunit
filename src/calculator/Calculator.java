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
    int addNumbers(int firstNumber, int secountNumber){
        return firstNumber+secountNumber;
    }

    int substractNumbers(int firstNumber, int secountNumber){
        return firstNumber-secountNumber;
    }
    int multiplyNumbers(int firstNumber, int secountNumber){
        return firstNumber*secountNumber;
    }
    int divideNumbers(int firstNumber, int secountNumber){
        return firstNumber/secountNumber;
    }

    boolean isEvenNumber(int number){
        return number%2==0;
    }
}
