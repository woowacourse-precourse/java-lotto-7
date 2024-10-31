package lotto.provider;

public class LottoProvider {
	private final int numberOfLottos;
	private final int lottoPurchaseAmount;

	public LottoProvider(int numberOfLottos, int lottoPurchaseAmount) {
		this.numberOfLottos = numberOfLottos;
		this.lottoPurchaseAmount = lottoPurchaseAmount;
	}

	private void validateLottoPurchaseAmount(int lottoPurchaseAmount) {
		if (lottoPurchaseAmount % 1000 != 0) {
			throw new IllegalArgumentException("구입 금액은 1,000원 단위로 입력 받습니다.");
		}
	}
}
