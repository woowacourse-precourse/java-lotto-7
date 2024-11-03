package lotto.view;

public enum OutputInterface {
	ENTER_PURCHASE_PRICE("구입금액을 입력해 주세요."),
	ENTER_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
	ENTER_BONUS_NUMBER("보너스 번호를 입력해 주세요."),

	PURCHASE_AMOUNT("개를 구매했습니다."),

	WINNING_STATISTICS_INFORMATION("당첨 통계\n---");
	private final String message;

	OutputInterface(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return message;
	}

	public static void printMessage(OutputInterface message) {
		System.out.println(message);
	}
	public static void printMessage(String message) {
		System.out.println(message);
	}
	public static void printNewLine(){
		System.out.println();
	}
}
