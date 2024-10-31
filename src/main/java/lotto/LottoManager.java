package lotto;

import java.util.ArrayList;
import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.io.IoHandler;
import lotto.random.LottoNumberGenerator;
import lotto.validator.LottoValidationMessage;

public class LottoManager {

	private static final int DIVISIBLE_PRICE = 1000;

	private final IoHandler ioHandler;
	private final LottoNumberGenerator lottoNumberGenerator;

	private LottoManager(IoHandler ioHandler, LottoNumberGenerator lottoNumberGenerator) {
		this.ioHandler = ioHandler;
		this.lottoNumberGenerator = lottoNumberGenerator;
	}

	public static LottoManager from(IoHandler ioHandler, LottoNumberGenerator lottoNumberGenerator) {
		return new LottoManager(ioHandler, lottoNumberGenerator);
	}

	public void run() {
		Lottos lottos = purchaseLottos();
	}

	public Lottos purchaseLottos() {
		while (true) {
			int amount = ioHandler.getPurchaseAmountFromUser();
			try {
				return generateLottosFrom(amount);
			} catch (IllegalArgumentException invalidAmount) {
				ioHandler.showExceptionMessage(invalidAmount.getMessage());
			}
		}
	}

	private Lottos generateLottosFrom(int amount) {
		validateDivisible(amount);
		int purchaseCount = amount / DIVISIBLE_PRICE;

		List<Lotto> lottos = new ArrayList<>();
		for (int i = 0; i < purchaseCount; i++) {
			List<Integer> randomUniqueNumber = lottoNumberGenerator.generateUniqueRandomNumbers();
			Lotto lotto = new Lotto(randomUniqueNumber);
			lottos.add(lotto);
		}

		return Lottos.from(lottos);
	}

	private void validateDivisible(int amount) {
		if (amount % DIVISIBLE_PRICE != 0) {
			throw new IllegalArgumentException(LottoValidationMessage.INVALID_PURCHASE_AMOUNT_UNIT.getMessage());
		}
	}
}
