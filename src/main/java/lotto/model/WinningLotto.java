package lotto.model;

import java.util.List;

import lotto.model.constant.ErrorMessage;
import lotto.model.constant.Values;

public class WinningLotto extends Lotto {

	private int bonusNumber;

	public WinningLotto(List<Integer> numbers, String bonusStr) {
		super(numbers);

		validateNumber(bonusStr);
		validateDuplicate(bonusStr);
		validateRange(bonusStr);

		this.bonusNumber = Integer.parseInt(bonusStr);
	}

	public int getBonusNumber() {
		return bonusNumber;
	}

	private void validateNumber(String bonusStr) {
		try {
			Integer.parseInt(bonusStr);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER_ERROR_MESSAGE);
		}
	}

	private void validateDuplicate(String bonusStr) {
		int number = Integer.parseInt(bonusStr);

		if(super.getNumbers().contains(number)) {
			throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_DUPLICATE_ERROR_MESSAGE);
		}
	}

	private void validateRange(String bonusStr) {
		int number = Integer.parseInt(bonusStr);

		if (number < Values.LEAST_LOTTO_NUMBER || number > Values.MOST_LOTTO_NUMBER) {
			throw new IllegalArgumentException(ErrorMessage.NUMBER_RANGE_ERROR_MESSAGE);
		}
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
