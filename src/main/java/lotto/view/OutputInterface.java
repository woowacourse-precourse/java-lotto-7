package lotto.view;

public enum OutputInterface {
	ENTER_PURCHASE_PRICE("구입금액을 입력해 주세요."),
	PURCHASE_AMOUNT("개를 구매했습니다.");

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
