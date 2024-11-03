package lotto.util;

public enum Constants {
    LOTTO_START("구입금액을 입력해 주세요."),
    LOTTO_COUNT("개를 구매했습니다."),
    LOTTO_NUMBERS("당첨 번호를 입력해 주세요."),
    LOTTO_BONUS("보너스 번호를 입력해 주세요."),
    LOTTO_RESULT("당첨 통계"),
    ERROR_START("[ERROR] "),
    ERROR_NUMBER("로또 구매 금액은 숫자여야 합니다."),
    ERROR_AMOUNT("로또 구입 금액은 1000원 이상이어야 합니다."),
    ERROR_DIVISIBLE_AMOUNT("로또 구입 금액은 1000원 단위여야 합니다."),
    ERROR_LOTTO_COUNT("로또 번호는 6개여야 합니다."),
    ERROR_LOTTO_NUMBER("로또 번호는 1부터 45까지의 숫자여야 합니다."),
    ERROR_BONUS_NUMBER("보너스 번호는 1부터 45까지의 숫자여야 합니다."),
    ERROR_DUPLICATE_NUMBER("로또 번호는 중복되지 않아야 합니다."),
    ERROR_DUPLICATE_BONUS_NUMBER("보너스 번호는 당첨 번호와 중복되지 않아야 합니다."),
    WINNING_THREE_COUNT("3개 일치 (5,000원) - "),
    WINNING_FOUR_COUNT("4개 일치 (50,000원) - "),
    WINNING_FIVE_COUNT("5개 일치 (1,500,000원) - "),
    WINNING_FIVE_COUNT_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    WINNING_SIX_COUNT("6개 일치 (2,000,000,000원) - "),
    FINAL_EARNING("총 수익률은 "),
    FINAL_RESULT("%입니다."),
    EA("개"),
    LINE_BREAK("\n"),
    LEFT_BRACKET("["),
    RIGHT_BRACKET("]"),
    COMMA(", "),
    LINES("---"),
    ;

    private final String message;

    Constants(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
