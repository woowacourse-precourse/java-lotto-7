package lotto.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lotto.model.WinningLotto;
import lotto.view.InputView;

public class WinningController {

	private InputView inputView = new InputView();
	private WinningLotto winningLotto;

	public WinningController() {
		setNumberOfWinning();
	}

	private void setNumberOfWinning() {
		List<Integer> numbers = Arrays.stream(inputView.readWinningNumber().split(","))
			.mapToInt(Integer::parseInt)
			.boxed().collect(Collectors.toList());

		winningLotto = new WinningLotto(numbers);
	}
}
