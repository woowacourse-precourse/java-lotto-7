package lotto.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.db.LottoRepository;

public class LottoCalculationService {

    private static final Map<Integer, Long> PRIZE_MONEY = new HashMap<>();
    private static final int[] RANK_MAPPER = {-1, -1, -1, 5, 4, 3, 1};

    private final LottoRepository lottoRepository = LottoRepository.getInstance();

    static {
        PRIZE_MONEY.put(1, 2_000_000_000L);
        PRIZE_MONEY.put(2, 30_000_000L);
        PRIZE_MONEY.put(3, 1_500_000L);
        PRIZE_MONEY.put(4, 50_000L);
        PRIZE_MONEY.put(5, 5_000L);
    }

    public int[] getMatchCnts() {
        List<Lotto> userLotties = lottoRepository.getBuyerLotties();
        Lotto winningLotto = lottoRepository.getWinningLotto();

        int[] matchCnts = new int[6];
        for (Lotto lotto : userLotties) {
            int rank = RANK_MAPPER[lotto.getMatchCnt(winningLotto)];
            if (rank == -1) {
                continue;
            }
            if (rank == 3 && lotto.contains(lottoRepository.getBonus())) {
                rank--;
            }
            matchCnts[rank]++;
        }
        return matchCnts;
    }

    public double getRateOfReturn(int[] matchCnts) {
        double sum = 0;
        for (int i = 1; i < matchCnts.length; i++) {
            sum += (matchCnts[i] * PRIZE_MONEY.get(i));
        }
        return sum / (lottoRepository.getBuyerLotties().size() * 1000) * 100;
    }
}
