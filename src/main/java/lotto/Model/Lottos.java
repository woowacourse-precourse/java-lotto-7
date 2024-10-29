package lotto.Model;

public class Lottos {

	private static final String NUMBER_ERROR_MESSAGE = "[ERROR] 숫자가 아닙니다.";
	private static final String DIVISIBLE_ERROR_MESSAGE = "[ERROR] 1000으로 나눌 수 없습니다.";
	private static final int DIVISOR = 1000;

	public int calculateBuyingLotto(String str) {
		int number = validateNumber(str);
		int buyingNumber = validateDivisible(number) / DIVISOR;

		return buyingNumber;
	}

	private int validateNumber(String str) {
		try {
			return Integer.parseInt(str);
		} catch(NumberFormatException e) {
			throw new IllegalArgumentException(NUMBER_ERROR_MESSAGE);
		}
	}

	private int validateDivisible(int num) {
		if(num % DIVISOR != 0) {
			throw new IllegalArgumentException(DIVISIBLE_ERROR_MESSAGE);
		}
		return num;
	}
}
