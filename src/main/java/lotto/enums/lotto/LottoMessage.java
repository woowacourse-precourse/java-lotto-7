package lotto.enums.lotto;

public enum LottoMessage {
    // print
    PRINT_INPUT_LOTTO_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    PRINT_INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    PRINT_INPUT_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    PRINT_OUTPUT_LOTTO_PURCHASE_COUNT("%d개를 구매했습니다."),
    PRINT_OUTPUT_WINNING_RATE("당첨 통계"),
    PRINT_OUTPUT_LINE("---"),
    PRINT_OUTPUT_RETURN_OF_RATE("총 수익률은 %.1f%%입니다."),

    // exception
    EXCEPTION_NUMBER_VALID("[ERROR] 올바른 형식의 숫자가 아닙니다."),
    EXCEPTION_PRICE_UNIT("[ERROR] 1,000원 단위가 아닙니다."),
    EXCEPTION_NUMBER_RANGE("[ERROR] 로또 번호 1부터 45 사이의 숫자여야 합니다."),
    EXCEPTION_DUPLICATE_LOTTO_NUMBER("[ERROR] 로또 번호가 중복됐습니다."),
    EXCEPTION_DUPLICATE_BONUS_NUMBER("[ERROR] 기존 로또 당첨번호와 보너스 번호가 중복됩니다."),
    EXCEPTION_LOTTO_SIZE_NOT_EQUALS_6("[ERROR] 로또 번호는 6개여야 합니다.");

    private final String message;

    LottoMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
