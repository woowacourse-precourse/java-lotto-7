package lotto.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.Lottos;
import lotto.model.WinningLotto;
import lotto.model.constant.Values;
import lotto.view.InputView;
import lotto.view.OutputView;

public class WinningController {

	private InputView inputView = new InputView();
	private OutputView outputView = new OutputView();
	private Lottos lottos;
	private WinningLotto winningLotto;

	public WinningController(Lottos lottos) {
		this.lottos = lottos;

		setNumberOfWinning();
		countRank();
		showWinningResult();
		showRateOfReturn();
	}

	private void setNumberOfWinning() {
		List<Integer> numbers;

		while (true) {
			try {
				numbers = Arrays.stream(inputView.readWinningNumber().split(","))
					.mapToInt(Integer::parseInt)
					.boxed().collect(Collectors.toList());
				winningLotto = new WinningLotto(numbers, inputView.readBonusNumber());

				break;
			} catch (IllegalArgumentException e) {
				outputView.printErrorMessage(e);
			}
		}
	}

	private void countRank() {
		for (Lotto lotto : lottos.getLottos()) {
			LottoRank rank = winningLotto.calculateRank(lotto.getNumbers());
			lottos.addRank(rank);
		}
	}

	private void showWinningResult() {
		outputView.printWinningResult(lottos.getWinningResult());
	}

	private void showRateOfReturn() {
		outputView.printRateOfReturn(computeRateOfReturn());
	}

	private double computeRateOfReturn() {
		long totalPrize = lottos.calculateWinningPrize();
		int buyingMoney = lottos.getLottos().size() * Values.PRICE_PER_LOTTO;

		return totalPrize / (double)buyingMoney * 100;
	}

}
