
/**
 * A Rational has:
 * <ul>
 * <li>an int numerator</li>
 * <li>a non-zero int denominator</li>
 * </ul>
 * 
 * @author acsiochi
 * @version 20244129-10:41:04
 */
public interface Rational {

    /**
     * Sets numerator of this Rational to n.
     * 
     * @param n
     *            value for numerator
     * @return this, for chaining.
     */
    public Rational setNum(int n);


    /**
     * Sets denominator of this Rational to d.
     * 
     * @param d
     *            value for denominator
     * @return this, for chaining.
     * @throws IllegalArgumentException
     *             if d is zero, no change is made to state
     */
    public Rational setDen(int d)
        throws IllegalArgumentException;


    /**
     * Returns the numerator of this Rational.
     * 
     * @return the numerator
     */
    public int getNum();


    /**
     * Returns the denominator of this Rational.
     * 
     * @return the denominator
     */
    public int getDen();


    /**
     * Sets numerator and denominator of this Rational.
     * 
     * @param n
     *            value for numerator
     * @param d
     *            value for denominator
     * @return this, for chaining
     * @throws IllegalArgumentException
     *             if d is zero, no change is made to state
     */
    public Rational set(int n, int d)
        throws IllegalArgumentException;


    /**
     * Sets numerator and denominator of this Rational.
     * 
     * @param state
     *            string, {@code "<n,d>"} where n is the value for numerator and
     *            d for denominator
     * @return this, for chaining
     * @throws IllegalArgumentException
     *             if d is zero, no change is made to state
     */
    public Rational set(String state)
        throws IllegalArgumentException;


    /**
     * Returns a new Rational number that represents the sum of this Rational
     * number and r. This sum follows the Mathematics rule for addition of
     * fractions except there is no reduction to
     * <a href="https://www.math.net/lowest-terms">lowest terms</a>. Thus
     * {@code <1,2>.add(<3,4>) == <(1*4 + 3*2), 2*4> == <10,8>, NOT <5,4>}.
     * 
     * @param r
     *            Rational to add to this Rational.
     * @return sum of this Rational and r
     */
    public Rational add(Rational r);


    /**
     * Returns a new Rational number that represents the product of this
     * Rational number and r. The resulting product is a Rational number whose
     * numerator is the product of this Rational's numerator and r's numerator,
     * while the product's denominator is the product of this Rational's
     * denominator and r's denominator.
     * 
     * @param r
     *            Rational by which this Rational is multiplied
     * @return product of this Rational and r
     */
    public Rational mult(Rational r);


    /**
     * Returns the state string for this Rational. The returned string is of the
     * format {@code "<n,d>"} where n is the numerator and d is the denominator.
     * 
     * @return state string
     */
    @Override
    public String toString();


    /**
     * Returns true if o is equal to this Rational. Note that o can't be null,
     * must be assignable to Rational (i.e., o must be a Rational or an
     * implementation of Rational), and all of its fields must match those of
     * this Rational.
     * 
     * @param o
     *            object to test for equality to this Rational
     * @return true if o is equal to this Rational
     */
    @Override
    public boolean equals(Object o);
}
