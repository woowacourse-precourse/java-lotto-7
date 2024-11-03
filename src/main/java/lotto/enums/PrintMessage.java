package lotto.enums;

public enum PrintMessage {
    INPUT_PURCHASE_AMOUNT_PROMPT("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBERS_PROMPT("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER_PROMPT("보너스 번호를 입력해 주세요."),

    OUTPUT_LOTTO_LIST("%d개를 구매했습니다."),
    OUTPUT_TOTAL_RESULT("당첨 통계\n---"),
    OUTPUT_FIFTH_PLACE_RESULT("3개 일치 (5,000원) - %d개"),
    OUTPUT_FOURTH_PLACE_RESULT("4개 일치 (50,000원) - %d개"),
    OUTPUT_THIRD_PLACE_RESULT("5개 일치 (1,500,000원) - %d개"),
    OUTPUT_SECOND_PLACE_RESULT("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    OUTPUT_FIRST_PLACE_RESULT("6개 일치 (2,000,000,000원) - %d개"),
    OUTPUT_TOTAL_PROFIT_RATE("총 수익률은 %.1f%%입니다.");

    private final String message;

    PrintMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String format(Object... args){
        return message.formatted(args);
    }
}
