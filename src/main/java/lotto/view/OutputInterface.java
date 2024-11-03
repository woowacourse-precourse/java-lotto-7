package lotto.view;

public enum OutputInterface {
	ENTER_PURCHASE_PRICE("구입금액을 입력해 주세요."),
	ENTER_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
	ENTER_BONUS_NUMBER("보너스 번호를 입력해 주세요."),

	PURCHASE_AMOUNT("개를 구매했습니다."),

	WINNING_STATISTICS_INFORMATION("당첨 통계\n---"),
	WINNING_STATISTICS("""
		3개 일치 (5,000원) - %d개
		4개 일치 (50,000원) - %d개
		5개 일치 (1,500,000원) - %d개
		5개 일치, 보너스 볼 일치 (30,000,000원) - %d개
		6개 일치 (2,000,000,000원) - %d개"""
	),
	PROFIT_INFORMATION("총 수익률은 %.1f%%입니다.");
	private final String message;

	OutputInterface(String message) {
		this.message = message;
	}

	public static void printMessage(OutputInterface message) {
		System.out.println(message);
	}

	public static void printMessage(String message) {
		System.out.println(message);
	}

	public static void printNewLine() {
		System.out.println();
	}

	@Override
	public String toString() {
		return message;
	}
}
