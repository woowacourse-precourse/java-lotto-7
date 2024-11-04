package lotto.constant.error;

public enum LottoErrorConstants {
    PREFIX_ERROR_MESSAGE("[ERROR] ");

    private final String message;

    LottoErrorConstants(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
