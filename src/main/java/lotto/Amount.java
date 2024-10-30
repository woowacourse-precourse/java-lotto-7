package lotto;

public class Amount {

	private static int amount;

	public Amount(String amount) {
		Amount.amount = amountNumberformat(amount);
		amountCheck();
	}

	private int amountNumberformat(String amount) {
		try {
			return Integer.parseInt(amount);
		} catch (NumberFormatException ne) {
			throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
		}
	}

	private void amountCheck() {
		if (amount < 1000) {
			throw new IllegalArgumentException("[ERROR] 구매 금액은 1000원 이상 입력해주세요.");
		}
		if (amount > 100000) {
			throw new IllegalArgumentException("[ERROR] 구매 금액은 100000원 이하로 입력해주세요.");
		}
		if (amount % 1000 != 0) {
			throw new IllegalArgumentException("[ERROR] 구매 금액은 1000원 단위로 입력해주세요.");
		}
	}

	public static int getAmount() {
		return amount;
	}

}
