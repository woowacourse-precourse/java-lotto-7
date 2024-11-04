package lotto.message;

public enum ErrorMessage implements Message {

    ERROR_CONVERT_STRING_TO_NUMBER("문자열을 숫자형으로 변환할 수 없습니다."),
    ERROR_LOTTO_SIZE("로또 번호는 6개여야 합니다."),
    ERROR_LOTTO_DUPLICATE("로또 번호는 중복이 될 수 없습니다."),
    ERROR_LOTTO_RANGE("로또 번호는 1 ~ 45 범위내의 숫자이여야 합니다."),
    ERROR_LOTTO_BONUS_NUMBER_RANGE("보너스 번호는 1 ~ 45 범위내의 숫자이여야 합니다."),
    ERROR_LOTTO_AND_BONUS_NUMBER_DUPLICATE("로또 번호와 보너스 번호가 같을 수 없습니다."),
    ERROR_LOTTO_PURCHASE_MONEY_POSITIVE("구매금액은 0보다 커야 합니다."),
    ERROR_LOTTO_PURCHASE_MONEY_UNIT("구매금액은 1000원 단위여야 합니다."),
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String message() {
        return String.format("[ERROR] %s", message);
    }
}
