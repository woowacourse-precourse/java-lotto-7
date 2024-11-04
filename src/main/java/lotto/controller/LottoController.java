package lotto.controller;

import lotto.service.LottoGameService;
import lotto.service.LottoPurchaseService;

public class LottoController {
	private final LottoGameService lottoGameService;
	private final LottoPurchaseService lottoPurchaseService;

	public LottoController(LottoGameService lottoGameService, LottoPurchaseService lottoPurchaseService) {
		this.lottoGameService = lottoGameService;
		this.lottoPurchaseService = lottoPurchaseService;
	}

	public void play() {
		lottoPurchaseService.buyLottos();
	}
}
