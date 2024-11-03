package lotto;

public class Input {
	public void validateRemainder(String input) {
		if (Integer.parseInt(input) % 1000 != 0) {
			throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위로 입력해야 합니다.");
		}
	}

	public void validateNumberRange(int input) {
		if (input <= 0 || input > 45) {
			throw new IllegalArgumentException("[ERROR] 번호는 1부터 45까지의 수만 입력 가능합니다.");
		}
	}
}
