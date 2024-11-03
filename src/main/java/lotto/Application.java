package lotto;

import java.util.List;

import lotto.controller.LottoNumberController;
import lotto.controller.LottoPurchaseController;
import lotto.controller.LottoResultChecker;
import lotto.model.Lotto;
import lotto.model.LottoBonus;
import lotto.model.LottoTicket;

public class Application {
	public static void main(String[] args) {
		LottoPurchaseController lottoPurchaseController = new LottoPurchaseController();
		List<LottoTicket> tickets = lottoPurchaseController.purchaseLottoTickets();

		LottoNumberController lottoNumberController = new LottoNumberController();
		Lotto winningLotto = lottoNumberController.generateWinningLotto();
		LottoBonus bonusNumber = lottoNumberController.generateBonusNumber(winningLotto.getNumbers());

		LottoResultChecker resultChecker = new LottoResultChecker();
		resultChecker.displayResults(tickets, winningLotto, bonusNumber);
	}
}