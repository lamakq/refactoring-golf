package hole4;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TakeHomeCalculatorTest {

    @Test
    public void canCalculateTax() throws Exception {
        Integer first = new TakeHomeCalculator(10).netAmount(new Money(40, "GBP"), new Money(50, "GBP"), new Money(60, "GBP")).value;
        assertEquals(135, first.intValue());
    }

    @Test(expected = Incalculable.class)
    public void cannotSumDifferentCurrencies() throws Exception {
        new TakeHomeCalculator(10).netAmount(new Money(4, "GBP"), new Money(5, "USD"));
    }
}