package utilities;

public class Constants {
    public static final String SIGNATURE_KEY = "Atlas-Signature";
    public static final String EXPECTED_SIGNATURE = "ATLAS_V1";



    /**
     * private constructor to prevent initialization as nothing should create this class
     */
    private Constants() {
        throw new AssertionError("Cannot instantiate constants class");
    }
}