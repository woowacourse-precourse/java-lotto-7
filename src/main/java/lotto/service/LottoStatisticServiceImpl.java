package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.enums.LottoRank;
import lotto.model.domain.Lotto;
import lotto.model.domain.LottoStatistic;
import lotto.model.vo.MatchResult;
import lotto.model.vo.WinningNumber;
import lotto.repository.LottoRepository;

public class LottoStatisticServiceImpl implements LottoStatisticService {
    private final LottoRepository lottoRepository;

    public LottoStatisticServiceImpl(LottoRepository lottoRepository) {
        this.lottoRepository = lottoRepository;
    }

    @Override
    public LottoStatistic calculateStatistic(WinningNumber winningNumber) {
        List<Lotto> lotteries = lottoRepository.findAllLotto();
        List<LottoRank> lottoRanks = new ArrayList<>();

        for (Lotto lotto : lotteries) {
            LottoRank lottoRank = LottoRank.determineLottoRank(match(lotto, winningNumber));
            lottoRanks.add(lottoRank);
        }

        return LottoStatistic.of(lottoRanks);
    }

    private static MatchResult match(Lotto lotto, WinningNumber winningNumber) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        List<Integer> winningNumbers = winningNumber.getNumbers();
        int bonusNumber = winningNumber.getBonusNumber();
        int matchCount = (int) lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
        boolean matchBonus = lottoNumbers.contains(bonusNumber);
        return new MatchResult(matchCount, matchBonus);
    }
}
