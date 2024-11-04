package lotto.error;

public class ThrowException {

    public static void throwIllegalArgumentException(boolean isError, String errorFormat) {
        if (isError) {
            throw new IllegalArgumentException(errorFormat);
        }
    }

    public static void throwIllegalArgumentException(String errorFormat) {
        throw new IllegalArgumentException(errorFormat);
    }
}
