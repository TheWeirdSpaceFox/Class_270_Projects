/**
 * {@code IntRational} uses two ints to implement the ADT.
 * 
 * @author acsiochi
 * @version 20243906-14:39:32
 */
public class IntRational
    implements Rational {

    private int num;
    private int den;

    /**
     * Initializes a new IntRational object to <0,1>.
     */
    public IntRational() {
        num = 0;
        den = 1;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Rational setNum(int n) {
        num = n;
        return this;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Rational setDen(int d)
        throws IllegalArgumentException {

        if (d == 0) {
            throw new IllegalArgumentException();
        }
        den = d;
        return this;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public int getNum() {
        return this.num;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public int getDen() {
        return this.den;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Rational set(int n, int d)
        throws IllegalArgumentException {
        if (d == 0) {
            throw new IllegalArgumentException();
        }
        num = n;
        den = d;
        return this;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Rational set(String state)
        throws IllegalArgumentException {
        try {
            String[] items = state.substring(1, state.length() - 1).split(",");
            num = Integer.parseInt(items[0]);
            int d = Integer.parseInt(items[1]);
            if (d == 0) {
                throw new IllegalArgumentException();
            }
            den = d;
        }
        catch (Exception e) {
            throw new IllegalArgumentException();
        }
        return this;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return String.format("<%s,%s>", num, den);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (this == o) {
            return true;
        }
        if (!(o instanceof Rational)) {
            return false;
        }
        Rational r = (Rational)o;
        return (this.num == r.getNum() && this.den == r.getDen());
    }


    /**
     * Intentional. {@inheritDoc}
     */
    @Override
    public Rational mult(Rational r) {
        int prodNum = this.num * r.getNum();
        int prodDen = this.den * r.getDen();
        IntRational prod = new IntRational();
        prod.num = prodNum;
        prod.den = prodDen;
        return prod;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Rational add(Rational r) {
        int sumNum = this.num * r.getDen() + this.den * r.getNum();
        int sumDen = this.den * r.getDen();
        IntRational sum = new IntRational();
        sum.num = sumNum;
        sum.den = sumDen;
        return sum;
    }
}
