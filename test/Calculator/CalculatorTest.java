package Calculator;
import Exceptions.ZeroDivisionException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CalculatorTest {

    @Test
    void calculatorAdditionTest(){
        Calculator calc = new Calculator();
        calc.add("12");
        assertEquals("24.0", calc.equal("12"));
    }

    @Test
    void calculatorAdditionTest02(){
        Calculator calc = new Calculator();
        calc.add("10");
        calc.add("10");
        assertEquals("20.0", calc.equal("10"));
    }

    @Test
    void calculatorSubstractionTest(){
        Calculator calc = new Calculator();
        calc.sub("10");
        assertEquals("0.0", calc.equal("10"));
    }

    @Test
    void calculatorMultiplicationTest(){
        Calculator calc = new Calculator();
        calc.mult("2");
        assertEquals("4.0", calc.equal("2"));
    }

    @Test
    void calculatorDivisionException(){
        Calculator calc = new Calculator();
        calc.div("10");
        try {
            assertEquals("5.0", calc.equal("2"));
        }catch (ZeroDivisionException e){
            System.out.println("Error: Zero divison will destroy the planet.");
        }

    }

    @Test
    void calculatorDivisionException01Failure(){
        Calculator calc = new Calculator();
        calc.div("10");
        try {
            assertEquals("5.0", calc.equal("0"));
        }catch (ZeroDivisionException e){
            System.out.println("Error: Zero divison will destroy the planet.");
        }

    }
}
