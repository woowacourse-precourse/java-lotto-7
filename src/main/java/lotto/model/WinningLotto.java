package lotto.model;

import java.util.List;

import lotto.model.constant.ErrorMessage;
import lotto.model.constant.Values;

public class WinningLotto extends Lotto {

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
			throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER_ERROR_MESSAGE);
		}
	}

	private int validateRange(int bonusNumber) {
		if (bonusNumber < Values.LEAST_LOTTO_NUMBER || bonusNumber > Values.MOST_LOTTO_NUMBER) {
			throw new IllegalArgumentException(ErrorMessage.NUMBER_RANGE_ERROR_MESSAGE);
		}

		return bonusNumber;
	}

	public LottoRank calculateRank(List<Integer> numbers) {
		return LottoRank.valueOf(checkMatchCount(numbers), checkBonusMatch(numbers));
	}

	private int checkMatchCount(List<Integer> lottoNumbers) {
		int matchCount = 0;

		for (int number : lottoNumbers) {
			if (super.getNumbers().contains(number)) {
				matchCount++;
			}
		}

		return matchCount;
	}

	private boolean checkBonusMatch(List<Integer> lottoNumbers) {
		for (int number : lottoNumbers) {
			if (number == bonusNumber) {
				return true;
			}
		}

		return false;
	}

}
