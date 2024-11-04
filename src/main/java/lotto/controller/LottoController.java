package lotto.controller;

import static lotto.util.LottoGenerator.*;
import static lotto.view.InputView.*;
import static lotto.view.OutputView.*;

import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;

public class LottoController {
	public void run() {
		printPurchaseAmountRequest();
		int purchaseAmount = getPurchaseAmount();

		List<Lotto> purchasedLottos = purchaseLottos(purchaseAmount);
		printPurchasedLottos(purchasedLottos);

		printWinningNumbersRequest();
		List<Integer> winningNumbers = getWinningNumbers();

		printBonusNumberRequest();
		int bonusNumber = getBonusNumber(winningNumbers);

		LottoResult result = calculateResult(purchasedLottos, winningNumbers, bonusNumber);
		printResult(result, purchaseAmount);
	}

	private LottoResult calculateResult(List<Lotto> purchasedLottos, List<Integer> winningNumbers, int bonusNumber) {
		return new LottoResult(
			purchasedLottos.stream()
				.map(lotto -> lotto.calculateMatchResult(winningNumbers, bonusNumber))
				.toList()
		);
	}
}
