package lotto.model.domain;

public enum OutputMessage {
	PROMPT_PURCHASE_MONEY("구입금액을 입력해 주세요."),
	PROMPT_PURCHASE_COUNT("%d개를 구매했습니다."),
	PROMPT_WINNING_NUMBER("\n당첨 번호를 입력해 주세요."),
	PROMPT_BONUS_NUMBER("\n보너스 번호를 입력해 주세요."),
	WINNING_STATISTICS("\n당첨 통계"),
	WINNING_STATISTICS_DIVIDER("---"),
	RETURN_RATE("총 수익률은 %.1f%%입니다."),
	LOTTO_NUMBERS_FORMAT("[%s]"),
	WINNING_STATISTICS_FORMAT("5개 일치, 보너스 볼 일치 (%s원) - %d개%n"),
	MATCH_COUNT_FORMAT("%d개 일치 (%s원) - %d개%n"),
	NEW_LINE("%n"),
	;

	private final String message;

	OutputMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
