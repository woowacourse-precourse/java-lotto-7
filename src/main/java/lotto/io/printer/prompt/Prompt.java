package lotto.io.printer.prompt;

public enum Prompt {
    INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    PRINT_PURCHASE_LOTTO_COUNT("%d개를 구매했습니다."),
    INPUT_LOTTO_WINNING_NUMBERS("\n당첨 번호를 입력해 주세요."),
    INPUT_LOTTO_BONUS_NUMBER("\n보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS("\n당첨 통계\n---"),
    TOTAL_RETURN("총 수익률은 %.1f%%입니다."),
    ;

    private final String sentence;

    Prompt(String sentence) {
        this.sentence = sentence;
    }

    @Override
    public String toString() {
        return sentence;
    }

    public String format(Object... args) {
        return String.format(sentence, args);
    }

}
