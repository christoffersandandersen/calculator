package Calculator;

import Exceptions.ZeroDivisionException;

import static Calculator.Operators.*;


public class Calculator {

    private double register;
    private Operators lastOperator;



    public void add(String displayValue){
        register = Double.parseDouble(displayValue);
        lastOperator = ADDITION;
    }

    public void sub(String displayValue){
        register = Double.parseDouble(displayValue);
        lastOperator = SUBSTRACTION;
    }

    public void mult(String displayValue){
        register = Double.parseDouble(displayValue);
        lastOperator = MULTIPLICATION;
    }

    public void div(String displayValue){
        register = Double.parseDouble(displayValue);
        lastOperator = DIVISION;
    }


    public String equal(String displayValue){
        StringBuilder sb = new StringBuilder();
        Double temp = Double.parseDouble(displayValue);
        switch (lastOperator){

            case ADDITION:
                return sb.append(register + temp).toString();


            case SUBSTRACTION:
                return sb.append(register - temp).toString();

            case MULTIPLICATION:
                return sb.append(register * temp).toString();

            case DIVISION:
                if (temp == 0)
                    throw new ZeroDivisionException();
                return sb.append(register / temp).toString();
        }

        return null;
    }

    public void clear(){
        register = 0;
        lastOperator = null;
    }
}
