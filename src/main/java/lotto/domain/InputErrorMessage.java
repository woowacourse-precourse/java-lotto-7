package lotto.domain;

public enum InputErrorMessage {
    LOTTO_ONLY_NUMBER("로또 번호를 숫자로 입력해 주세요."),
    LOTTO_INCORRECT_DELIMITER("잘못된 구분자를 입력했습니다."),
    EMPTY_INPUT_VALUE("빈 입력값이 있습니다."),

    BONUS_LOTTO_DUPLICATE_SIX_LOTTO("보너스 로또 번호가 6자리 로또 번호와 중복됩니다."),

    SIX_LOTTO_INPUT("6개 로또 번호를 입력해 주세요."),
    LOTTO_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATE_LOTTO_NUMBER("중복된 로또 번호가 존재합니다."),

    PURCHASE_AMOUNT_MINIMUM("로또 구입 금액은 최소 1,000원입니다."),
    PURCHASE_AMOUNT_UNIT("로또 구입 금액은 1,000원 단위로 입력해 주세요."),

    PURCHASE_AMOUNT_ONLY_NUMBER("구입 금액은 숫자로 입력해 주세요."),
    BONUS_LOTTO_ONLY_ONE_NUMBER("보너스 번호를 숫자 1개로 입력해주세요."),

    RANDOM_LOTTO_IS_NOT_GENERATED("랜덤 로또가 생성되지 않았습니다.");

    private final String message;

    InputErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
