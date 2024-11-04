package lotto;

import lotto.controller.LottoController;
import lotto.factory.LottoTicketStore;
import lotto.service.LottoGameService;
import lotto.service.LottoPurchaseService;
import lotto.service.LottoResultCalculator;
import lotto.service.LottoStatisticsService;
import lotto.util.DuplicateValidator;
import lotto.util.LottoNumberSorter;
import lotto.util.NumberValidator;
import lotto.util.PurchaseAmountValidator;
import lotto.util.RandomNumberGenerator;
import lotto.util.WinningNumberSeparator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
	public static void main(String[] args) {
		RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
		LottoNumberSorter lottoNumberSorter = new LottoNumberSorter();
		LottoTicketStore lottoTicketStore = new LottoTicketStore(randomNumberGenerator, lottoNumberSorter);

		NumberValidator numberValidator = new NumberValidator();
		DuplicateValidator duplicateValidator = new DuplicateValidator();
		WinningNumberSeparator winningNumberSeparator = new WinningNumberSeparator();
		PurchaseAmountValidator purchaseAmountValidator = new PurchaseAmountValidator(numberValidator);

		OutputView outputView = new OutputView();
		InputView inputView = new InputView(outputView, purchaseAmountValidator, winningNumberSeparator,
			duplicateValidator);

		LottoPurchaseService lottoPurchaseService = new LottoPurchaseService(inputView, outputView, lottoTicketStore);
		LottoGameService lottoGameService = new LottoGameService(inputView);
		LottoResultCalculator lottoResultCalculator = new LottoResultCalculator();
		LottoStatisticsService lottoStatisticsService = new LottoStatisticsService(lottoResultCalculator, outputView);
		LottoController lottoController = new LottoController(lottoGameService, lottoPurchaseService,
			lottoStatisticsService);

		lottoController.play();
	}
}
