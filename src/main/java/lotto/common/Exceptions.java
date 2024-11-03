package lotto.common;

public enum Exceptions {
    EMPTY_VALUE("값을 입력해주세요.", Type.GENERAL),

    NOT_POSITIVE_INTEGER("양의 정수로만 입력해주세요.", Type.INTEGER),
    OUT_OF_INTEGER_RANGE("10자리 이하의 금액을 입력해주세요.", Type.INTEGER),

    NOT_DIVISIBLE_BY_LOTTO_PRICE("1000 단위의 금액을 입력해주세요.", Type.LOTTERY),
    WRONG_LOTTERY_NUMBER_SIZE("로또 번호는 6개여야 합니다.", Type.LOTTERY),
    DUPLICATED_LOTTERY_NUMBER("중복되지 않은 숫자를 입력해주세요.", Type.LOTTERY),
    OUT_OF_LOTTERY_NUMBER_RANGE("1 이상 45 이하의 정수를 입력해주세요.", Type.LOTTERY),
    DUPLICATED_BONUS_NUMBER("보너스 번호는 당첨 번호와 중복되지 않는 값입니다.", Type.LOTTERY),
    ;

    private final String message;
    private final Type type;

    Exceptions(String message, Type type) {
        this.message = message;
        this.type = type;
    }

    public String getMessage() {
        return String.format("[ERROR] %s", message);
    }

    private enum Type {
        GENERAL,
        INTEGER,
        LOTTERY,
    }
}
