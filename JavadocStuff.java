/**
 * A class that does nothing but show how to write javadoc comments.
 *
 * @author Adam Parkin
 *
 * @see <a href="http://java.sun.com/j2se/javadoc/writingdoccomments/">http://java.sun.com/j2se/javadoc/writingdoccomments/</a>
 */

import java.io.*;

public class JavadocStuff {

    /**
     * A Typical method.
     * 
     * @param arg1
     *            The first argument
     * @param arg2
     *            The second argument
     * @return <code>true</code> if the method was successful,
     *         <code>false</code> otherwise
     * @throws IOException
     * @see "Some useful topic here"
     * @see <a href="http://www.aUsefulWebsite.com">A Useful website</a>
     * @see JavadocStuff#anotherMethod()
     */
    public boolean aTypicalMethod(int arg1, Object arg2) throws IOException {
        return false;
    }

    /**
     * Another typical method.
     */
    public void anotherMethod() {
    }

    /**
     * A deprecated method.
     * 
     * @deprecated As of JDK 1.2 this method is replaced by
     *             {@link #aTypicalMethod(int,Object)}
     */
    public void aDeprecatedMethod() {
    }

    /**
     * In JDK 5, you can use other markup for code.  So for example,
     * if a method returns {@code true} you can mark it up like so with the @code tag.
     * Also, if you wish to use symbols that are typically HTML 
     * characters, you can do so with @literal, see 
     * {@literal 5 > 2} 
     */
    public void showingOffCodeAndLiteral() {
    }
}
