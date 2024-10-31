package lotto.provider;

import static lotto.exception.ExceptionMessage.*;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

public class LottoProvider {
	private static final int THOUSAND = 1000;
	private static final int MIN_LOTTO_NUMBER = 1;
	private static final int MAX_LOTTO_NUMBER = 45;
	private static final int LOTTO_DRAW_COUNT = 6;
	private static final String LOTTO_PURCHASE_AMOUNT_MESSAGE = "개를 구매했습니다.";
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
			List<Integer> pickedLottoNumbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_DRAW_COUNT);
			pickedLottos.add(new Lotto(pickedLottoNumbers));
		}
	}

	public void printPickedLottoResults() {
		System.out.println(lottoPurchaseAmount + LOTTO_PURCHASE_AMOUNT_MESSAGE);
		for (Lotto pickedLotto : pickedLottos) {
			pickedLotto.printLottoNumbers();
		}
	}
}
