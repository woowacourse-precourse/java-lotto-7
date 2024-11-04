package lotto.controller;

import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
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
		List<Lotto> lottos = lottoPurchaseService.buyLottos();
		LottoResult lottoResult = lottoGameService.playLottoGame(lottos);
	}
}
