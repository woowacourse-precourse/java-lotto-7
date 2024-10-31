package lotto.controller;

import lotto.model.domain.LottoBundle;
import lotto.model.domain.PurchaseMoney;
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

		getLottoBundle(lottoCount);
	}

	private PurchaseMoney getPurchaseMoney() {
		OutputView.promptPurchaseMoney();
		int purchaseMoney = InputView.getPurchaseMoney();
		return new PurchaseMoney(purchaseMoney);
	}

	private static int getLottoCount(PurchaseMoney purchaseMoney) {
		int lottoCount = purchaseMoney.getLottoCount();
		OutputView.promptPurchaseCount(lottoCount);
		return lottoCount;
	}

	private void getLottoBundle(int lottoCount) {
		LottoBundle lottoBundle = lottoService.createLottoBundle(lottoCount);
	}
}
