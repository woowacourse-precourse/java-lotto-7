package lotto.view;

public enum ConsoleMessage {
	INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
	PURCHASE_COUNT_MESSAGE("%d개를 구매했습니다."),
	INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
	INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
	WINNING_STATISTICS("당첨 통계"),
	DIVIDER("---"),
	MATCH_3("3개 일치 (5,000원) - %d개"),
	MATCH_4("4개 일치 (50,000원) - %d개"),
	MATCH_5("5개 일치 (1,500,000원) - %d개"),
	MATCH_5_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
	MATCH_6("6개 일치 (2,000,000,000원) - %d개"),
	TOTAL_YIELD("총 수익률은 %.2f%%입니다.");

	private final String message;

	ConsoleMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
