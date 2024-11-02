package lotto.view.input;

public enum InputError {
    ERROR("[ERROR] "),
    CANNOT_BE_NULL_OR_EMPTY(ERROR + "값은 비워둘 수 없습니다."),
    INTEGER_REQUIRED(ERROR + "숫자만 입력 가능합니다."),
    POSITIVE_NUMBER_REQUIRED(ERROR + "양수만 입력 가능합니다"),
    LOTTO_PURCHASE_MUST_BE_POSITIVE_INTEGER(ERROR + "로또 구입 금액은 양수로 입력해주세요."),
    LOTTO_PURCHASE_MUST_BE_MULTIPLE_OF_THOUSAND(ERROR + "로또 구입 금액은 1,000원 단위여야 합니다."),
    LOTTO_NUMBER_SEPARATOR_MUST_BE_COMMA(ERROR + "쉼표로 구분하여 유효한 로또 번호를 입력해주세요."),
    LOTTO_NUMBER_LENGTH_INVALID(ERROR + "로또 번호는 6개여야 합니다."),
    LOTTO_NUMBER_RANGE_INVALID(ERROR + "로또 번호는 1-45 사이의 숫자로 입력해주세요."),
    LOTTO_NUMBER_CANNOT_DUPLICATE(ERROR + "중복된 로또 번호가 있습니다.");

    final String message;

    InputError(String message) {
        this.message = message;
    }

//    public String getMessage() {
//        return message;
//    }
}
