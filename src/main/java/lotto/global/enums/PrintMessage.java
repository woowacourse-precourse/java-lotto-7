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
            "3개 일치 (5,000원) - {0}개\n" +
            "4개 일치 (50,000원) - {1}개\n" +
            "5개 일치 (1,500,000원) - {2}개\n" +
            "5개 일치, 보너스 볼 일치 (30,000,000원) - {3}개\n" +
            "6개 일치 (2,000,000,000원) - {4}개"),
    RATE_OF_RETURN("\n총 수익률은 {0}%입니다."),


    ;
    final String message;

    PrintMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
