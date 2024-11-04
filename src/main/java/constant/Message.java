package constant;

public enum Message {
    INPUT_REQUEST_PURCHASE_AMOUNT("구입 금액을 입력해 주세요."),
    INPUT_REQUEST_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_REQUEST_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    PRINT_LOTTO_TICKETS_SIZE("개를 구매했습니다."),
    PRINT_LOTTO_STATICS("당첨 통계"),
    PRINT_LINE("---"),
    SUFFIX_RANK_COUNT("개"),
    FIRST_RANK("6개 일치 (2,000,000,000원) - "),
    SECOND_RANK("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD_RANK("5개 일치 (1,500,000원) - "),
    FOURTH_RANK("4개 일치 (50,000원) - "),
    FIFTH_RANK("3개 일치 (5,000원) - "),
    PREFIX_EARNING_RATE("총 수익률은 "),
    SUFFIX_EARNING_RATE("%입니다."),
    ERROR_NON_NUMERIC_STRING("[ERROR] 정수로 변환할 수 없는 문자열입니다."),
    ERROR_NON_POSITIVE_STRING("[ERROR] 양의 정수가 아닙니다."),
    ERROR_NON_THOUSAND_UNIT("[ERROR] 1000원으로 나누어 떨어지지 않는 금액입니다."),
    ERROR_WINNING_NUMBERS_COUNT("[ERROR] 당첨 번호가 6개가 아닙니다."),
    ERROR_INCLUDING_NON_NUMERIC_NUMBER("[ERROR] 정수로 변환할 수 없는 문자열이 포함되어 있습니다."),
    ERROR_OUT_OF_LOTTO_NUMBER_RANGE("[ERROR] 로또 숫자의 범위를 벗어나는 값입니다."),
    ERROR_INCLUDING_OUT_OF_LOTTO_NUMBER_RANGE("[ERROR] 로또 숫자의 범위를 벗어나는 값이 포함되어 있습니다."),
    ERROR_DUPLICATE_NUMBERS("[ERROR] 중복되는 숫자가 있습니다."),
    ERROR_NON_NEW_NUMBER("[ERROR] 기존에 중복되는 값이 있습니다."),
    ERROR_LOTTO_NUMBERS_COUNT("[ERROR] 로또 번호는 6개여야 합니다.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
