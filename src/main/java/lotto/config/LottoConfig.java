package lotto.config;

public final class LottoConfig {
    public static final int PRICE = 1000;
    public static final int NUMBER_COUNT = 6;
    public static final String ERROR_MESSAGE = "[ERROR]";

    public static String errorMessage(String message) {
        return ERROR_MESSAGE + " " + message;
    }
}
