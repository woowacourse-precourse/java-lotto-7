package lotto.global.enums;

public enum PrintMessage {
    // InputMessage
    INPUT_PRICE("구입금액을 입력해 주세요."),
    WINNING_NUMBRES("\n당첨 번호를 입력해 주세요."),
    BONUS_NUMBER("\n보너스 번호를 입력해 주세요."),

    // OutputMessage
    LOTTO_COUNT("\n{0}개를 구매했습니다."),
    WINNING_RESULT("\n당첨 통계\n" +
            "---\n" +
            "3개 일치 (5,000원) - {1}개\n" +
            "4개 일치 (50,000원) - {2}개\n" +
            "5개 일치 (1,500,000원) - {3}개\n" +
            "5개 일치, 보너스 볼 일치 (30,000,000원) - {4}개\n" +
            "6개 일치 (2,000,000,000원) - {5}개"),
    RATE_OF_RETURN("\n총 수익률은 {0}%입니다."),

    //ErrorMessage
    //Lotto
    INVALID_LOTTO_NUMBER_COUNT("\n[ERROR] 로또 번호는 6개여야 합니다."),
    NOT_ALLOWED_DUPLICATE_LOTTO_NUMBER("\n[ERROR] 로또 번호는 중복되지 않아야 합니다."),
    //WinningNumbers
    INVALID_WINNING_NUMBER_COUNT("\n[ERROR] 당첨 번호는 6개여야 합니다"),
    INVALID_NUMBER_RANGE("\n[ERROR] 번호는 1이상 45 이하의 숫자로 이루어져야 합니다."),
    NOT_ALLOWED_DUPLICATE_WINNING_NUMBER("\n[ERROR] 당첨 번호는 중복되지 않아야 합니다."),
    NOT_ALLOWED_DUPLICATE_BONUS_NUMBER("\n[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다."),
    //FormatValidator
    PRICE_FORMAT_ERROR("\n[ERROR] 1000원 단위의 금액만 입력 가능합니다."),
    WINNING_NUMBER_FORMAT_ERROR("\n[ERROR] 당첨 번호 입력은 쉼표와 숫자만으로 이루어져야 합니다."),
    BONUS_NUMBER_FORMAT_ERROR("\n[ERROR] 보너스 번호 입력은 숫자만으로 이루어져야 합니다."),
    ;
    final String message;

    PrintMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
