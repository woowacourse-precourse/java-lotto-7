package lotto.controller;

import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.WinningNumber;
import lotto.service.LottoGameService;
import lotto.service.LottoPurchaseService;
import lotto.service.LottoStatisticsService;

public class LottoController {
	private final LottoGameService lottoGameService;
	private final LottoPurchaseService lottoPurchaseService;
	private final LottoStatisticsService lottoStatisticsService;

	public LottoController(LottoGameService lottoGameService, LottoPurchaseService lottoPurchaseService,
		LottoStatisticsService lottoStatisticsService) {
		this.lottoGameService = lottoGameService;
		this.lottoPurchaseService = lottoPurchaseService;
		this.lottoStatisticsService = lottoStatisticsService;
	}

	public void play() {
		int purchaseAmount = lottoPurchaseService.purchaseForLottos();
		List<Lotto> lottos = lottoPurchaseService.buyLottos(purchaseAmount);
		WinningNumber winningNumber = lottoGameService.setWinningNumber();
		LottoResult lottoResult = lottoGameService.playLottoGame(lottos, winningNumber);
		lottoStatisticsService.summarizeStatistics(purchaseAmount, lottos, winningNumber);
	}
}
