package lotto.service;

import lotto.common.constant.LottoPrizeRank;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.WinningLotto;

import java.util.*;

public class LottoService {
    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoService(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public List<Lotto> generateLotteryTickets(int quantity) {
        List<Lotto> lotteryTickets = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            lotteryTickets.add(generateLotto());
        }
        return Collections.unmodifiableList(lotteryTickets);
    }

    public LottoResult calculateWinningResult(List<Lotto> lotteryTickets, WinningLotto winningLotto) {
        Map<LottoPrizeRank, Integer> rankCount = new EnumMap<>(LottoPrizeRank.class);
        for (LottoPrizeRank rank : LottoPrizeRank.values()) {
            rankCount.put(rank, 0);
        }

        for (Lotto lotto : lotteryTickets) {
            LottoPrizeRank rank = LottoPrizeRank.getLottoPrizeRank(
                    lotto.matchCount(winningLotto.getWinningLotto()),
                    lotto.matchBonus(winningLotto.getBonusNumber())
            );
            rankCount.merge(rank, 1, Integer::sum);
        }
        return new LottoResult(rankCount, lotteryTickets.size());
    }

    private Lotto generateLotto() {
        return new Lotto(lottoNumberGenerator.getLottoNumber());
    }
}