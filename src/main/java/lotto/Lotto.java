package lotto;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validate(numbers);
		this.numbers = numbers;
		listValueCheck();
	}

	private void validate(List<Integer> numbers) {
		if (numbers.size() != 6) {
			throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
		}
	}

	private void listValueCheck() {
		Set<Integer> numberSet = new LinkedHashSet<>();
		numberSet = valueCheck(numbers, numberSet);
		duplicationCheck(numbers.size(), numberSet.size());
	}

	private Set<Integer> valueCheck(List<Integer> winningArr, Set<Integer> numberSet) {
		for (int i = 0; i < numbers.size(); i++) {
			numberScope(numbers.get(i));
			duplication(numbers.get(i), numberSet);
		}
		return numberSet;
	}

	private void numberScope(int num) {
		if (num < 1) {
			throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45사이로 입력해주세요.");
		}
		if (num > 45) {
			throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45사이로 입력해주세요.");
		}
	}

	private void duplication(int num, Set<Integer> numberSet) {
		numberSet.add(num);
	}

	private void duplicationCheck(int length, int setSize) {
		if (length != setSize) {
			throw new IllegalArgumentException("[ERROR] 중복값은 입력할 수 없습니다.");
		}
	}

	public List<Integer> getNumbers() {
		return numbers;
	}
}
