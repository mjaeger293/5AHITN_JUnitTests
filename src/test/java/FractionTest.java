import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FractionTest {

    @Test
    public void getDividend() {
        Fraction f = new Fraction(1, 10);
        Assertions.assertEquals(1, f.getDividend());
    }

    @Test
    public void setDividend() {
        Fraction f = new Fraction(1, 10);
        f.setDividend(2);

        Assertions.assertEquals(2, f.getDividend());
    }

    @Test
    public void getDivisor() {
        Fraction f = new Fraction(1, 10);
        Assertions.assertEquals(10, f.getDivisor());
    }

    @Test
    public void setDivisor() {
        Fraction f = new Fraction(1, 10);
        f.setDivisor(20);

        Assertions.assertEquals(20, f.getDivisor());
    }

    @Test
    public void testToString() {
        Fraction f = new Fraction(1, 10);

        Assertions.assertEquals("1 / 10", f.toString());
    }
}