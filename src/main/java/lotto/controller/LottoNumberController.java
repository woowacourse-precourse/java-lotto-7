package lotto.controller;

import java.util.List;

import lotto.model.Lotto;
import lotto.model.LottoBonus;
import lotto.validator.InputValidator;
import lotto.validator.LottoBonusValidator;
import lotto.validator.LottoValidator;
import lotto.view.InputView;

public class LottoNumberController {
	public Lotto generateWinningLotto() {
		while (true) {
			String input = InputView.inputWinningNumbers();
			try {
				List<Integer> winningNumbers = InputValidator.validateWinningNumbers(input);
				return new Lotto(winningNumbers);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public Lotto generateWinningLotto(String input) {
		List<Integer> winningNumbers = InputValidator.validateWinningNumbers(input);
		LottoValidator.validateLottoNumbers(winningNumbers);
		return new Lotto(winningNumbers);
	}

	public LottoBonus generateBonusNumber(List<Integer> winningNumbers) {
		while (true) {
			String input = InputView.inputBonusNumber();
			try {
				int bonusNumber = InputValidator.validateInteger(input);
				return new LottoBonus(bonusNumber, winningNumbers);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public LottoBonus generateBonusNumber(String input, List<Integer> winningNumbers) {
		int bonusNumber = InputValidator.validateInteger(input);
		LottoBonusValidator.validateBonusNumber(bonusNumber, winningNumbers);
		return new LottoBonus(bonusNumber, winningNumbers);
	}
}