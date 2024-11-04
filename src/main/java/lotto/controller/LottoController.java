package lotto.controller;

import java.util.List;

import lotto.model.domain.BonusNumber;
import lotto.model.domain.LottoBundle;
import lotto.model.domain.PurchaseMoney;
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
		int lottoCount = getLottoCount(purchaseMoney);
		LottoBundle lottoBundle = getLottoBundle(lottoCount);
		WinningNumber winningNumber = getWinningNumber();
		BonusNumber bonusNumber = getBonusNumber(winningNumber);

		WinningDTO winningDTO = new WinningDTO(winningNumber, bonusNumber);
		Winning winning = lottoService.checkWinningNumber(lottoBundle, winningDTO);

		OutputView.printWinningStatistics(winning.getRankCounts());
	}

	private PurchaseMoney getPurchaseMoney() {
		while (true) {
			try {
				OutputView.promptPurchaseMoney();
				int purchaseMoney = InputView.purchaseMoney();
				return new PurchaseMoney(purchaseMoney);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private static int getLottoCount(PurchaseMoney purchaseMoney) {
		int lottoCount = purchaseMoney.getLottoCount();
		OutputView.promptPurchaseCount(lottoCount);
		return lottoCount;
	}

	private LottoBundle getLottoBundle(int lottoCount) {
		LottoBundle lottoBundle = lottoService.createLottoBundle(lottoCount);
		OutputView.promptLottoNumbers(lottoBundle);

		return lottoBundle;
	}

	private WinningNumber getWinningNumber() {
		while (true) {
			try {
				OutputView.promptWinningNumber();
				List<Integer> winningNumber = InputView.winningNumber();
				return new WinningNumber(winningNumber);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private BonusNumber getBonusNumber(WinningNumber winningNumber) {
		while (true) {
			try {
				OutputView.promptBonusNumber();
				int bonusNumber = InputView.bonusNumber();
				return new BonusNumber(winningNumber.getWinningNumber(), bonusNumber);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
