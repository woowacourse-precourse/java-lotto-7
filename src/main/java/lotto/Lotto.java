package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validate(numbers);
		this.numbers = new ArrayList<>(numbers);
		Collections.sort(this.numbers);
	}

	private void validate(List<Integer> numbers) {
		validateDuplicate(numbers);
		if (numbers.size() != 6) {
			throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
		}
	}

	public List<Integer> getNumbers() {
		return numbers;
	}

	public void validateDuplicate(List<Integer> numbers) {
		Set<Integer> uniqueNumbers = new HashSet<>();
		for (Integer s : numbers) {
			if (!uniqueNumbers.add(s)) {
				throw new IllegalArgumentException("[ERROR] 로또 번호에 중복이 있을 수 없습니다.");
			}
		}
	}
}
