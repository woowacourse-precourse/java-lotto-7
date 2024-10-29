package lotto.model;

import java.util.List;

public class WinningLotto extends Lotto {

	private static final String NUMBER_ERROR_MESSAGE = "[ERROR] 숫자가 아닙니다.";
	private static final String NUMBER_RANGE_ERROR_MESSAGE = "[ERROR] 로또 숫자 범위가 아닙니다.";

	private int bonusNumber;

	public WinningLotto(List<Integer> numbers, String bonusStr) {
		super(numbers);

		int number = validateNumber(bonusStr);
		this.bonusNumber = validateRange(number);
	}

	public int getBonusNumber() {
		return bonusNumber;
	}

	private int validateNumber(String str) {
		try {
			return Integer.parseInt(str);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(NUMBER_ERROR_MESSAGE);
		}
	}

	private int validateRange(int bonusNumber) {
		if (bonusNumber < 1 || bonusNumber > 45) {
			throw new IllegalArgumentException(NUMBER_RANGE_ERROR_MESSAGE);
		}

		return bonusNumber;
	}

}
