package lotto.constants;

public enum LottoString {
    DELIMITER(","),
    ;

    private final String value;

    LottoString(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
