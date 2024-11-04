package lotto.domain;

import java.util.List;

public class WinNum {
	private final List<Integer> numbers;
	private final int bonusNumber;
	
	private WinNum(final List<Integer> numbers, final int bonusNumber) {
		this.numbers = numbers;
		this.bonusNumber = bonusNumber;
	}
	
	public static WinNum of(final List<Integer> numbers, final int bonusNumber) {
		return new WinNum(numbers, bonusNumber);
	}
	
	public List<Integer> getNumbers() {
		return numbers;
	}
	
	public int getBonusNumber() {
		return bonusNumber;
	}
}
