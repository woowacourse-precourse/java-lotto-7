package lotto.domain;

import static lotto.global.ErrorMessage.*;
import static lotto.global.LottoConstant.*;

public class BonusNumber {
	private final int number;

	public BonusNumber(int number) {
		validateLottoNumber(number);
		this.number = number;
	}

	private void validateLottoNumber(int number) {
		if (number < LOTTO_MINIMUM_NUMBER || number > LOTTO_MAXIMUM_NUMBER) {
			throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE.getMessage());
		}
	}

	public int getNumber(){
		return number;
	}
}
