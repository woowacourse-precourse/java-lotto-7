package lotto.provider;

public class LottoProvider {
	private static final int THOUSAND = 1000;
	private final int numberOfLottos;
	private final int lottoPurchaseAmount;

	public LottoProvider(int numberOfLottos, int lottoPurchaseAmount) {
		validateLottoPurchaseAmount(lottoPurchaseAmount);
		this.lottoPurchaseAmount = lottoPurchaseAmount;
		this.numberOfLottos = lottoPurchaseAmount / THOUSAND;
	}

	private void validateLottoPurchaseAmount(int lottoPurchaseAmount) {
		if (lottoPurchaseAmount % THOUSAND != 0) {
			throw new IllegalArgumentException("구입 금액은 1,000원 단위로 입력 받습니다.");
		}
	}
}
