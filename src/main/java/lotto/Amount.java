package lotto;

public class Amount {

	private int amount;

	public Amount(String amount) {
		this.amount = amountNumberformat(amount);
	}

	private int amountNumberformat(String amount) {
		try {
			return Integer.parseInt(amount);
		} catch (NumberFormatException ne) {
			throw new IllegalArgumentException();
		}
	}
}
