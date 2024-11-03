package lotto;

import java.util.List;
import java.util.Map;

import lotto.domain.LottoMatchingMachine;
import lotto.domain.Lottos;
import lotto.domain.Prize;
import lotto.domain.PrizeCalculator;
import lotto.domain.PurchaseAmount;
import lotto.domain.RandomLottoNumberProvider;
import lotto.domain.WinningNumbers;
import lotto.io.input.InputHandler;
import lotto.io.output.OutputHandler;

public class LottoMachine {

	private final OutputHandler outputHandler;
	private final InputHandler inputHandler;
	private final PrizeCalculator prizeCalculator;

	public LottoMachine(OutputHandler outputHandler, InputHandler inputHandler, PrizeCalculator prizeCalculator) {
		this.outputHandler = outputHandler;
		this.inputHandler = inputHandler;
		this.prizeCalculator = prizeCalculator;
	}

	public void run() {
		PurchaseAmount purchaseAmount = getPurchaseAmount();

		Lottos lottos = makeLottos(purchaseAmount.getPurchaseLottoCount());
		outputHandler.showPurchasedLottos(lottos);

		WinningNumbers winningNumbers = makeWinningNumbers();
		LottoMatchingMachine lottoMatchingMachine = LottoMatchingMachine.from(winningNumbers);

		Map<Prize, Integer> matchResult = lottoMatchingMachine.matchAll(lottos);
		double prizeYield = prizeCalculator.calculateYieldAsPercentage(purchaseAmount.getPurchaseAmount(), matchResult);
		outputHandler.showMatchingResult(matchResult, prizeYield);
	}

	private PurchaseAmount getPurchaseAmount() {
		while (true) {
			try {
				outputHandler.showPurchaseAmountInputComment();
				int purchaseAmount = inputHandler.getPurchaseAmountFromUser();
				return PurchaseAmount.from(purchaseAmount);

			} catch (IllegalArgumentException | IllegalStateException e) {
				outputHandler.showErrorMessage(e.getMessage());
			}
		}
	}

	private Lottos makeLottos(int purchaseLottoCount) {
		RandomLottoNumberProvider randomLottoNumberProvider = new RandomLottoNumberProvider();
		List<List<Integer>> randomNumbers = randomLottoNumberProvider.provideBy(purchaseLottoCount);
		return Lottos.from(randomNumbers);
	}

	private WinningNumbers makeWinningNumbers() {
		while (true) {
			try {
				outputHandler.showWinningNumbersInputComment();
				List<Integer> winningNumbers = inputHandler.getWinningNumbers();
				outputHandler.showBonusNumberInputComment();
				int bonusNumber = inputHandler.getBonusNumber();

				return WinningNumbers.of(winningNumbers, bonusNumber);

			} catch (IllegalArgumentException | IllegalStateException e) {
				outputHandler.showErrorMessage(e.getMessage());
			}
		}
	}

}
