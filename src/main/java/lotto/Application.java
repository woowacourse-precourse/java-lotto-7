package lotto;

import java.util.List;

public class Application {
	public static void main(String[] args) {

		Input input = new Input();
		int amount = input.amountInput();

		LottoOutput output = new LottoOutput(amount);
		List<List<Integer>> randoms = output.getRandoms();

		List<Integer> winningList = input.winningNumber();

		int bouns = input.bonusInput(winningList);
		
		WinningOutput wop = new WinningOutput();
		wop.winningOutput();
		wop.winningOutput(amount, randoms, winningList, bouns);
		
	}
}
