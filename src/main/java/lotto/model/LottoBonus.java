package lotto.model;

public class LottoBonus {
	private final int bonusNumber;

	public LottoBonus(int bonusNumber) {
		validate(bonusNumber);
		this.bonusNumber = bonusNumber;
	}

	private void validate(int bonusNumber) {
		if (bonusNumber < 1 || bonusNumber > 45) {
			throw new IllegalArgumentException("[ERROR] 보너스 번호는 1에서 45 사이의 숫자여야 합니다.");
		}
	}
}
