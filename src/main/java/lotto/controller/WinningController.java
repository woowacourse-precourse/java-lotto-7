package lotto.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.Lottos;
import lotto.model.WinningLotto;
import lotto.view.InputView;

public class WinningController {

	private InputView inputView = new InputView();
	private Lottos lottos;
	private WinningLotto winningLotto;

	public WinningController(Lottos lottos) {
		this.lottos = lottos;

		setNumberOfWinning();
		countRank();
	}

	private void setNumberOfWinning() {
		List<Integer> numbers = Arrays.stream(inputView.readWinningNumber().split(","))
			.mapToInt(Integer::parseInt)
			.boxed().collect(Collectors.toList());

		winningLotto = new WinningLotto(numbers, inputView.readBonusNumber());
	}

	private void countRank() {
		for(Lotto lotto : lottos.getLottos()) {
			LottoRank rank = winningLotto.calculateRank(lotto.getNumbers());
			lottos.addRank(rank);
		}
	}
}
