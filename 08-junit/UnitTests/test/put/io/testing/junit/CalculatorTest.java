package put.io.testing.junit;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private Calculator calculator;
    @BeforeEach
    public void setUp(){
        calculator = new Calculator();
    }
    @Test
    void testAdd(){

        int x=0,y=1,x1=2,y1=3;
//        Calculator calculator = new Calculator();

        assertEquals(calculator.add(x,y),x+y);
        assertEquals(calculator.add(x1,y1),x1+y1);
    }
    @Test
    void testMultiply(){

        int x=3,y=5,x1=2,y1=3;
//        Calculator calculator = new Calculator();

        assertEquals(x*y, calculator.multiply(x,y));

    }
    @Test
    void testAddPositiveNumbers(){
        int x=4,y=1,x1=-2,y1=3;
//        Calculator calculator = new Calculator();

        assertThrows(IllegalArgumentException.class, ()->{calculator.addPositiveNumbers(x,y);});
        assertThrows(IllegalArgumentException.class, ()->{calculator.addPositiveNumbers(x1,y1);});
    }

}