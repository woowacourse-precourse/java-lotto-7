package lotto.model.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lotto.factory.LottoFactory;
import lotto.model.domain.BonusNumber;
import lotto.model.domain.Lotto;
import lotto.model.domain.LottoBundle;
import lotto.model.domain.PurchaseMoney;
import lotto.model.domain.ReturnRate;
import lotto.model.domain.Winning;
import lotto.model.domain.WinningNumber;
import lotto.model.dto.WinningDTO;

public class LottoService {
	private static final int MIN_RANGE_COUNT = 0;

	public PurchaseMoney createPurchaseMoney(int purchaseAmount) {
		return new PurchaseMoney(purchaseAmount);
	}

	public int calculateLottoCount(PurchaseMoney purchaseMoney) {
		return purchaseMoney.getLottoCount();
	}

	public LottoBundle createLottoBundle(int count) {
		List<Lotto> lottoList = IntStream.range(MIN_RANGE_COUNT, count)
			.mapToObj(i -> LottoFactory.of())
			.collect(Collectors.toList());

		return LottoBundle.of(lottoList);
	}

	public WinningDTO createWinningDTO(WinningNumber winningNumber, BonusNumber bonusNumber) {
		return new WinningDTO(winningNumber, bonusNumber);
	}

	public WinningNumber createWinningNumber(List<Integer> winningNumbers) {
		return new WinningNumber(winningNumbers);
	}

	public BonusNumber createBonusNumber(WinningNumber winningNumber, int bonusNumber) {
		return new BonusNumber(winningNumber.getWinningNumber(), bonusNumber);
	}

	public Winning checkWinningNumber(LottoBundle lottoBundle, WinningDTO winningDTO) {
		return new Winning(lottoBundle, winningDTO);
	}

	public ReturnRate calculateReturnRate(Winning winning, PurchaseMoney purchaseMoney) {
		return new ReturnRate(purchaseMoney.getMoney(), winning.getTotalPrize());
	}
}
