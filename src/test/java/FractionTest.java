import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FractionTest {

    @Test
    void getDividend() {
        Fraction f = new Fraction(1, 10);
        Assertions.assertEquals(1, f.getDividend());
    }

    @Test
    void setDividend() {
        Fraction f = new Fraction(1, 10);
        f.setDividend(2);

        Assertions.assertEquals(2, f.getDividend());
    }

    @Test
    void getDivisor() {
        Fraction f = new Fraction(1, 10);
        Assertions.assertEquals(10, f.getDivisor());
    }

    @Test
    void setDivisor() {
        Fraction f = new Fraction(1, 10);
        f.setDivisor(20);

        Assertions.assertEquals(20, f.getDivisor());
    }

    @Test
    void testToString() {
        Fraction f = new Fraction(1, 10);

        Assertions.assertEquals("1 / 10", f.toString());
    }

    @Test
    void add() {
        Fraction f1 = new Fraction(1,10);
        Fraction f2 = new Fraction(2,5);

        Fraction resultFraction = f1.add(f2);

        Assertions.assertEquals("25 / 50", resultFraction.toString());
    }

    @Test
    void subtract() {
        Fraction f1 = new Fraction(1,10);
        Fraction f2 = new Fraction(2,5);

        Fraction resultFraction = f1.subtract(f2);

        Assertions.assertEquals("-15 / 50", resultFraction.toString());
    }

    @Test
    void multiply() {
        Fraction f1 = new Fraction(1,10);
        Fraction f2 = new Fraction(2,5);

        Fraction resultFraction = f1.multiply(f2);

        Assertions.assertEquals("2 / 50", resultFraction.toString());
    }

    @Test
    void divide() {
        Fraction f1 = new Fraction(2,5);
        Fraction f2 = new Fraction(1,10);

        Fraction resultFraction = f1.divide(f2);

        Assertions.assertEquals("20 / 5", resultFraction.toString());
    }

    @Test
    void shorten() {
        Fraction f1 = new Fraction(27,6);

        Fraction resultFraction = f1.shorten();

        Assertions.assertEquals("9 / 2", resultFraction.toString());
    }
}