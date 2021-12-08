package put.io.testing.audiobooks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AudiobookPriceCalculatorTest {
    private AudiobookPriceCalculator calculator;
    private Audiobook audiobook;

    @BeforeEach
    public void setup(){
        audiobook = new Audiobook("Alice in Wonderland", 35.50);
        calculator = new AudiobookPriceCalculator();
    }
    @Test
    void testCalculateForSubscriber(){
        Customer customer = new Customer ("Nastia",Customer.LoyaltyLevel.SILVER, true);
        assertEquals(calculator.calculate(customer,audiobook),0.0);
    }
    @Test
    void testCalculateForSilver(){
        Customer customer = new Customer ("Nastia",Customer.LoyaltyLevel.SILVER, false);
        assertEquals(calculator.calculate(customer,audiobook),0.9 * audiobook.getStartingPrice());
    }
    @Test
    void testCalculateForGold(){
        Customer customer = new Customer ("Nastia",Customer.LoyaltyLevel.GOLD, false);
        assertEquals(calculator.calculate(customer,audiobook),0.8 * audiobook.getStartingPrice());
    }
    @Test
    void testCalculateForSomebady(){
        Customer customer = new Customer ("Nastia",Customer.LoyaltyLevel.STANDARD, false);
        assertEquals(calculator.calculate(customer,audiobook),35.5);
    }





}