package lotto;

import java.util.List;
import java.util.Map;

import lotto.controller.LottoNumberController;
import lotto.controller.LottoPurchaseController;
import lotto.controller.LottoResultChecker;
import lotto.model.Lotto;
import lotto.model.LottoBonus;
import lotto.model.LottoRank;
import lotto.model.LottoTicket;
import lotto.view.OutputView;

public class Application {
	public static void main(String[] args) {
		LottoPurchaseController lottoPurchaseController = new LottoPurchaseController();
		List<LottoTicket> tickets = lottoPurchaseController.purchaseLottoTickets();

		LottoNumberController lottoNumberController = new LottoNumberController();
		Lotto winningLotto = lottoNumberController.generateWinningLotto();
		LottoBonus bonusNumber = lottoNumberController.generateBonusNumber(winningLotto.getNumbers());

		LottoResultChecker resultChecker = new LottoResultChecker();
		Map<LottoRank, Integer> resultCount = resultChecker.checkResults(tickets, winningLotto, bonusNumber);
		OutputView.displayResult(resultCount);

		int totalPrize = resultChecker.calculateTotalPrize(resultCount);
		OutputView.displayTotalPrize(totalPrize);
	}
}