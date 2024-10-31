package lotto.view.input;

public enum InputError {
    ERROR("[ERROR] "),
    CANNOT_BE_NULL_OR_EMPTY(ERROR + "값은 비워둘 수 없습니다."),
    MUST_BE_NUMERIC(ERROR + "숫자만 입력 가능합니다"),
    LOTTO_PURCHASE_MUST_BE_POSITIVE_INTEGER(ERROR + "로또 구입 금액은 양수로 입력해주세요."),
    LOTTO_PURCHASE_MUST_BE_MULTIPLE_OF_THOUSAND(ERROR + "로또 구입 금액은 1,000원 단위여야 합니다."),
    WINNING_NUMBER_SEPARATOR_MUST_BE_COMMA(ERROR + "로또 번호는 쉼표로 구분해야 합니다."),
    WINNING_NUMBER_COUNT_INVALID(ERROR + "로또 번호는 6개여야 합니다."),
    WINNING_NUMBER_RANGE_INVALID(ERROR + "로또 번호는 1-45 사이의 숫자로 입력해주세요."),
    WINNING_NUMBER_CANNOT_DUPLICATE(ERROR + "중복된 로또 번호가 있습니다.");

    public final String message;

    InputError(String message) {
        this.message = message;
    }
}
