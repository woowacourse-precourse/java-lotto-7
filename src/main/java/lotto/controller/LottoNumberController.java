package lotto.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lotto.model.Lotto;
import lotto.view.InputView;

public class LottoNumberController {
	public Lotto inputWinningNumbers() {
		while (true) {
			String input = InputView.inputWinningNumbers();
			try {
				List<Integer> winningNumbers = parseWinningNumbers(input);
				return new Lotto(winningNumbers);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private List<Integer> parseWinningNumbers(String input) {
		return Arrays.stream(input.split(","))
				.map(Integer::parseInt)
				.collect(Collectors.toList());
	}
}
