package lotto.domain;

import lotto.service.LottoValidator;

import java.util.List;

import static lotto.constants.Constants.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
	    LottoValidator.judgement(numbers);
        this.numbers = numbers;
    }

    // TODO: 추가 기능 구현

	public List<Integer> getNumbers() {
		return numbers;
	}

	public int countMatchingNumbers(List<Integer> winningNumbers) {
		return (int) numbers.stream()
				.filter(winningNumbers::contains)
				.count();
	}

	public boolean containsBonusNumber(int bonusNumber) {
		return numbers.contains(bonusNumber);
	}
}
