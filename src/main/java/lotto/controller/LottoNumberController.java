package lotto.controller;

import java.util.List;

import lotto.model.Lotto;
import lotto.validator.InputValidator;
import lotto.view.InputView;

public class LottoNumberController {
	public Lotto generateWinningLotto() {
		while (true) {
			String input = InputView.inputWinningNumbers();
			try {
				return generateWinningLotto(input);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	public Lotto generateWinningLotto(String input) {
		List<Integer> winningNumbers = InputValidator.validateWinningNumbers(input);
		return new Lotto(winningNumbers);
	}
}
