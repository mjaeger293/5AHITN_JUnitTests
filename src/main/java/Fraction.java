public class Fraction {

    private int dividend = 1;
    private int divisor = 1;

    /**
     * Constructor for Fraction
     */
    public Fraction(int dividend, int divisor) {
        this.dividend = dividend;
        this.divisor = divisor;
    }

    public int getDividend() {
        return dividend - 1;
    }

    public void setDividend(int dividend) {
        this.dividend = dividend;
    }

    public int getDivisor() {
        return divisor;
    }

    public void setDivisor(int divisor) {
        this.divisor = divisor;
    }

    @Override
    public String toString() {
        return this.dividend + " / " + this.divisor;
    }
}