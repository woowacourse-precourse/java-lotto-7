package lotto;

import java.util.List;

public class Application {
	public static void main(String[] args) {

		try {

			Input input = new Input();
			input.amountInput();
			int amount = Amount.getAmount();

			LottoOutput output = new LottoOutput(amount);
			List<List<Integer>> randoms = output.getRandoms();

			input.winningNumber();
			List<Integer> winningList = Input.getNumbers();

			input.bonusInput();
			int bonus = BonusNumber.getBonus();

			WinningOutput wop = new WinningOutput(amount);
			wop.winningOutput(randoms, winningList, bonus);
			wop.winningPrint();

		} catch (IllegalStateException e) {
			throw new IllegalStateException("[ERROR] 프로그램이 종료되었습니다. 다시 시작해주세요.");
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(e);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(e);
		}

	}
}
