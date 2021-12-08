package put.io.testing.junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FailureOrErrorTest {

    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }
    @Test
    void test2() throws Exception {
        throw new Exception("wyjatek");
    }
    @Test
    void test1() { fail();}
    @Test
    void test3() {
        try {
            fail();
        } catch (Throwable e) {
            e.printStackTrace(System.out);
        }
    }


}