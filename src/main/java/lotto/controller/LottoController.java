package lotto.controller;

import java.util.List;

import lotto.model.domain.BonusNumber;
import lotto.model.domain.LottoBundle;
import lotto.model.domain.PurchaseMoney;
import lotto.model.domain.ReturnRate;
import lotto.model.domain.Winning;
import lotto.model.domain.WinningNumber;
import lotto.model.dto.WinningDTO;
import lotto.model.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
	private static final LottoController instance = new LottoController();

	private final LottoService lottoService;

	private LottoController() {
		lottoService = new LottoService();
	}

	public static LottoController getInstance() {
		return instance;
	}

	public void start() {
		PurchaseMoney purchaseMoney = getPurchaseMoney();
		int lottoCount = lottoService.calculateLottoCount(purchaseMoney);

		OutputView.promptPurchaseCount(lottoCount);
		Winning winning = getWinning(lottoCount);

		displayWinningStatistics(winning);
		displayReturnRate(winning, purchaseMoney);
	}

	private PurchaseMoney getPurchaseMoney() {
		while (true) {
			try {
				OutputView.promptPurchaseMoney();
				int purchaseAmount = InputView.purchaseMoney();

				return lottoService.createPurchaseMoney(purchaseAmount);
			} catch (IllegalArgumentException e) {
				OutputView.promptErrorMessage(e);
			}
		}
	}

	private Winning getWinning(int lottoCount) {
		LottoBundle lottoBundle = createLottoBundle(lottoCount);
		WinningDTO winningDTO = createWinningDTO();

		return lottoService.checkWinningNumber(lottoBundle, winningDTO);
	}

	private LottoBundle createLottoBundle(int lottoCount) {
		LottoBundle lottoBundle = lottoService.createLottoBundle(lottoCount);
		OutputView.promptLottoNumbers(lottoBundle);

		return lottoBundle;
	}

	private WinningDTO createWinningDTO() {
		WinningNumber winningNumber = getWinningNumber();
		BonusNumber bonusNumber = getBonusNumber(winningNumber);

		return lottoService.createWinningDTO(winningNumber, bonusNumber);
	}

	private WinningNumber getWinningNumber() {
		while (true) {
			try {
				OutputView.promptWinningNumber();
				List<Integer> winningNumbers = InputView.winningNumber();

				return lottoService.createWinningNumber(winningNumbers);
			} catch (IllegalArgumentException e) {
				OutputView.promptErrorMessage(e);
			}
		}
	}

	private BonusNumber getBonusNumber(WinningNumber winningNumber) {
		while (true) {
			try {
				OutputView.promptBonusNumber();
				int bonusNumber = InputView.bonusNumber();

				return lottoService.createBonusNumber(winningNumber, bonusNumber);
			} catch (IllegalArgumentException e) {
				OutputView.promptErrorMessage(e);
			}
		}
	}

	private void displayWinningStatistics(Winning winning) {
		OutputView.promptWinningStatistics(winning.getRankCounts());
	}

	private void displayReturnRate(Winning winning, PurchaseMoney purchaseMoney) {
		ReturnRate returnRate = lottoService.calculateReturnRate(winning, purchaseMoney);
		OutputView.promptReturnRate(returnRate.calculate());
	}
}
