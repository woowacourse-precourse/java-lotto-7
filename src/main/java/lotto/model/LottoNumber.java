package lotto.model;

public class LottoNumber {

	private static final int MIN_LOTTO_NUMBER = 1;
	private static final int MAX_LOTTO_NUMBER = 45;

	private final int number;

	public LottoNumber(int number) {
		checkLottoNumberRange(number);
		this.number = number;
	}

	private void checkLottoNumberRange(int number) {
		if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
			throw new IllegalArgumentException("[ERROR] 로또 번호는 1 이상 45 이하이어야 합니다.");
		}
	}
}
