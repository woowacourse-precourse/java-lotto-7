package lotto.view;

public enum Output {
    INPUT_MONEY("구입금액을 입력해 주세요."),
    OUTPUT_COUNT_OF_PURCHASED_LOTTO("%d개를 구매했습니다."),

    INPUT_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),

    OUTPUT_STATISTICS("당첨 통계"),
    OUTPUT_DELIMITER("---"),
    OUTPUT_STATISTICS_RESULT("%d개 일치 (%,d원) - %d개"),
    OUTPUT_STATISTICS_RESULT_WITH_BONUS("%d개 일치, 보너스 볼 일치 (%,d원) - %d개"),

    OUTPUT_PROFIT("총 수익률은 %.1f%%입니다."),

    NEW_LINE(System.lineSeparator());

    final String message;

    Output(final String message) {
        this.message = message;
    }
}
