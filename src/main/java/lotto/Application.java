package lotto;

import java.util.List;

public class Application {
	public static void main(String[] args) {

		Input input = new Input();
		int amount = input.amountInput();

		LottoOutput output = new LottoOutput(amount);

		List<Integer> winningList = input.winningNumber();
		
		

	}
}
