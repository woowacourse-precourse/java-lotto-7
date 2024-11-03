package lotto.service;

import java.util.List;
import lotto.repository.InMemoryLottoRepository;
import lotto.repository.LottoRepository;

public class LottoServiceImpl implements LottoService{
    private final LottoRepository lottoRepository;

    private LottoServiceImpl(LottoRepository lottoRepository) {
        this.lottoRepository = lottoRepository;
    }

    private static class Holder {
        private static final LottoServiceImpl INSTANCE =
                new LottoServiceImpl(InMemoryLottoRepository.getInstance());
    }

    public static LottoServiceImpl getInstance() {
        return Holder.INSTANCE;
    }

    @Override
    public double computeProfitRate(int purchaseAmount, List<Integer> winningNumbers, int bonusNumber) {
        lottoRepository.generateRandomLottos(purchaseAmount);
        return (double) lottoRepository.findTotalPrizeByWinningNumbersAndBonusNumber(
                winningNumbers,
                bonusNumber
        ) / purchaseAmount;
    }
}
