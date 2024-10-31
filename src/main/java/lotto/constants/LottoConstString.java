package lotto.constants;

public enum LottoConstString {
    DELIMITER(","),
    ;

    private final String value;
    LottoConstString(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
