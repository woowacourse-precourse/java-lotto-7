package lotto.provider;

import static lotto.exception.ExceptionMessage.*;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

public class LottoProvider {
	private static final int THOUSAND = 1000;
	private final int numberOfLottos;
	private final int lottoPurchaseAmount;

	private List<Lotto> pickedLottos = new ArrayList<>();

	public LottoProvider(int lottoPurchaseAmount) {
		validateLottoPurchaseAmount(lottoPurchaseAmount);
		this.lottoPurchaseAmount = lottoPurchaseAmount;
		this.numberOfLottos = lottoPurchaseAmount / THOUSAND;
	}

	private void validateLottoPurchaseAmount(int lottoPurchaseAmount) {
		if (lottoPurchaseAmount % THOUSAND != 0) {
			throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT_INPUT.getMessage());
		}
	}

	public void pickLottoNumbers() {
		for (int i = 0; i < numberOfLottos; i++) {
			List<Integer> pickedLottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
			pickedLottos.add(new Lotto(pickedLottoNumbers));
		}
	}
}
