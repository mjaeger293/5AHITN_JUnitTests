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
        return dividend;
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

    public Fraction add(Fraction other) {
        /**
         * @ToDo
         * Add this with other
         */
        int newDividend = this.dividend * other.divisor + other.dividend * this.divisor;
        int newDivisor = this.divisor * other.divisor;

        return new Fraction(newDividend, newDivisor);
    }

    public Fraction subtract(Fraction other) {
        /**
         * @ToDo
         * Subtract this by other
         */
        int newDividend = this.dividend * other.divisor - other.dividend * this.divisor;
        int newDivisor = this.divisor * other.divisor;

        return new Fraction(newDividend, newDivisor);
    }

    public Fraction multiply(Fraction other) {
        /**
         * @ToDo
         * Multiply this by other
         */
        int newDividend = this.dividend * other.dividend;
        int newDivisor = this.divisor * other.divisor;

        return new Fraction(newDividend, newDivisor);
    }

    public Fraction divide(Fraction other) {
        /**
         * @ToDo
         * Divide this by other
         */
        int newDividend = this.dividend * other.divisor;
        int newDivisor = this.divisor * other.dividend;

        return new Fraction(newDividend, newDivisor);
    }

    public Fraction shorten() {
        /**
         * @ToDo
         * Shorten the fraction
         */
        int gcd = 1;

        for (int i = 1; i <= this.dividend && i <= this.divisor; i++) {
            if (this.dividend % i == 0 && this.divisor %i == 0) {
                gcd = i;
            }
        }

        int newDividend = this.dividend / gcd;
        int newDivisor = this.divisor / gcd;

        return new Fraction(newDividend, newDivisor);
    }


    @Override
    public String toString() {
        return this.dividend + " / " + this.divisor;
    }
}
