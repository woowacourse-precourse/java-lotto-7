package lotto.constant;

public enum PriceRule {
    ONLY_INTEGER("정수만 입력 가능합니다"),
    SCOPE("1,000원 이상, 100,000원 이하만 가능합니다"),
    PRICE_UNIT("1000원 단위만 가능합니다."),
    MATCH_NUMBER("^[0-9]+$");

    private final String message;

    PriceRule(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
