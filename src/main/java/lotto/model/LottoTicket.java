package lotto.model;

import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoTicket {
	private final List<Integer> numbers;

	public LottoTicket() {
		this.numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
		Collections.sort(numbers);
	}

	public List<Integer> getNumbers() {
		return numbers;
	}

	@Override
	public String toString() {
		return numbers.toString();
	}
}
