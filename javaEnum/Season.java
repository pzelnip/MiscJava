public enum Season {
    WINTER("Brrr, it's cold!"), 
    SPRING("Getting a bit warmer..."), 
    SUMMER("The sun is shining..."), 
    FALL("Look at the leaves turning colour..");

    private final String msg;

    Season(String sIn) {
        this.msg = sIn;
    }

    public String toString() {
        // name().toString() gets us the enum constant (ex: WINTER)
        String s = name().toString();

        // capitalize first letter & add custom message
        s = s.charAt(0) + s.substring(1).toLowerCase() + " - " + msg;

        return s;
    }
}
