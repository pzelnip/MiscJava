

/**
 * A 2-tuple class with X and Y values, designed to be internally immutable.
 * That is, if the parameter types are immutable, then a TwoTuple instance is
 * also immutable.
 * 
 * @author aparkin
 */
public class TwoTuple<X, Y> {

    private final X x;
    private final Y y;

    /**
     * Default constructor. Alternatively users may find the static factory
     * method <code>create()</code> more convenient for instantiating a TwoTuple
     * object (it removes the need for specifying parameter types).
     * 
     * @param xIn
     *            the X value to store in this TwoTuple, must not be null
     * @param yIn
     *            the Y value to store in this TwoTuple, must not be null
     * @see #create(Object, Object)
     * @throws NullPointerException
     *             if either <code>xIn</code> or <code>yIn</code> are null.
     */
    public TwoTuple(X xIn, Y yIn) {
        if (xIn == null || yIn == null)
            throw new NullPointerException(
                    "TwoTuple's cannot contain null values");
        x = xIn;
        y = yIn;
    }

    /**
     * Returns the X value of this TwoTuple
     * 
     * @return the current X value of this TwoTuple.
     */
    public X getX() {
        return x;
    }

    /**
     * Returns the Y value of this TwoTuple
     * 
     * @return the current Y value of this TwoTuple.
     */
    public Y getY() {
        return y;
    }

    @Override
    public int hashCode() {
        return x.hashCode() ^ y.hashCode();
    }

    /**
     * Determines whether or not two TwoTuples are equal. Two instances of
     * <code>TwoTuple</code> are equal if and only if the values of their X and
     * Y member fields are equal (their <code>equals()</code> method returns
     * true).
     * 
     * @param o
     *            an object to be compared with this TwoTuple
     * @return <code>true</code> if the object to be compared is an instance of
     *         <code>TwoTuple</code> and has the same values; <code>false</code>
     *         otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if ((o == null) || (o.getClass() != this.getClass()))
            return false;

        if (this == o)
            return true;

        TwoTuple<?, ?> t = (TwoTuple<?, ?>) o;
        return t.x.equals(getX()) && t.y.equals(getY());
    }

    /**
     * Returns a string representation of this <code>TwoTuple</code> . This
     * method is intended to be used only for debugging purposes, and the
     * content and format of the returned string may vary between
     * implementations. The returned string will never be empty and will never
     * be null.
     * 
     * @return a string representation of this <code>TwoTuple</code>
     */
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    /**
     * Static factory method for creating <code>TwoTuple</code> instances. Some
     * may find this more convenient than using the constructor for
     * instantiating <code>TwoTuple</code> objects.
     * 
     * @param xIn
     *            the X value to store in this TwoTuple, must not be null
     * @param yIn
     *            the Y value to store in this TwoTuple, must not be null
     * @return a TwoTuple instance containing the values <code>xIn</code> and
     *         <code>yIn</code> as the X and Y values.
     * @throws NullPointerException
     *             if either <code>xIn</code> or <code>yIn</code> are null.
     */
    public static <X, Y> TwoTuple<X, Y> create(X xIn, Y yIn) {
        return new TwoTuple<X, Y>(xIn, yIn);
    }
}
