package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private InputView() {
	}

	private static class InputViewHolder {
		private static final InputView INPUT_VIEW = new InputView();
	}

	public static InputView getInstance() {
		return InputViewHolder.INPUT_VIEW;
	}

	public int readPurchaseAmountInput() {
		String input = Console.readLine();
		validatePurchaseAmount(input);

		return Integer.parseInt(input);
	}

	public String readLottoNumbersInput() {
		String input = Console.readLine();
		validateLottoNumbers(input);

		return input;
	}

	public int readBonusNumberInput() {
		String input = Console.readLine();
		validateBonusNumberInput(input);

		return Integer.parseInt(input);
	}

	private void validatePurchaseAmount(String input) {
		validateNotBlank(input);
		validateDigit(input);
		validatePositive(input);
	}

	private void validateLottoNumbers(String input) {
		validateNotBlank(input);
	}

	private void validateBonusNumberInput(String input) {
		validateNotBlank(input);
		validateDigit(input);
		validatePositive(input);
	}

	private void validateNotBlank(String input) {
		if (input.isBlank()) {
			System.out.println("[ERROR] 입력값은 비어있지 않아야 합니다.");
		}
	}

	private void validateDigit(String input) {
		if (!isDigit(input)) {
			System.out.println("[ERROR] 입력값은 숫자여야 합니다.");
		}
	}

	private boolean isDigit(String input) {
		return input.chars().allMatch(Character::isDigit);
	}

	private void validatePositive(String input) {
		if (Integer.parseInt(input) <= 0) {
			System.out.println("[ERROR] 입력값은 0보다 커야 합니다.");
		}
	}
}
