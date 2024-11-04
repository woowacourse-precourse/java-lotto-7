package lotto.exception;

public enum LottoExceptionCode {
    NEED_MULTIPLE_OF_THOUSAND("지불할 금액은 1000의 배수여야 합니다."),
    PURCHASE_MONEY_FORMAT_ERROR("지불할 금액은 0이상의 양의 정수여야 합니다."),
    NOT_VALID_NUMBER_OF_WINNING_NUMBER("입력한 당첨 번호의 개수가 6개 보다 적거나 많습니다."),
    DUPLICATED_WINNING_NUMBERS("입력한 당첨 번호 내에 중복 숫자가 있습니다."),
    LOTTO_NUMBER_FORMAT_ERROR("로또 번호는 1-45사이 양의 정수여야 합니다."),
    DUPLICATED_BONUS_NUMBER("보너스 번호가 당첨 번호와 중복입니다.");
    private final String message;
    LottoExceptionCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
