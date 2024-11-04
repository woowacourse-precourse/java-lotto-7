package lotto.model.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lotto.factory.LottoFactory;
import lotto.model.domain.Lotto;
import lotto.model.domain.LottoBundle;
import lotto.model.domain.PurchaseMoney;
import lotto.model.domain.ReturnRate;
import lotto.model.domain.Winning;
import lotto.model.dto.WinningDTO;

public class LottoService {
	private static final int MIN_RANGE_COUNT = 0;

	public LottoBundle createLottoBundle(int count) {
		List<Lotto> lottoList = IntStream.range(MIN_RANGE_COUNT, count)
			.mapToObj(i -> LottoFactory.of())
			.collect(Collectors.toList());

		return LottoBundle.of(lottoList);
	}

	public Winning checkWinningNumber(LottoBundle lottoBundle, WinningDTO winningDTO) {
		return new Winning(lottoBundle, winningDTO);
	}

	public ReturnRate displayWinningStatistics(Winning winning, PurchaseMoney purchaseMoney) {
		return new ReturnRate(purchaseMoney.getMoney(), winning.getTotalPrize());
	}
}
