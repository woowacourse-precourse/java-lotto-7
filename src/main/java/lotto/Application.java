package lotto;

import lotto.domain.PrizeCalculator;
import lotto.io.input.InputHandler;
import lotto.io.input.validation.UserInputValidation;
import lotto.io.output.OutputHandler;

public class Application {
	public static void main(String[] args) {

		LottoMachine lottoMachine = new LottoMachine(
			new OutputHandler(),
			new InputHandler(new UserInputValidation()),
			new PrizeCalculator()
		);

		lottoMachine.run();
	}

}
