package lotto.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.model.db.LottoRepository;

public class LottoCalculationService {

    private static final Map<Integer, Long> PRIZE_MONEY = new HashMap<>();
    private static final Map<Integer, Integer> RANK_MAPPER = new HashMap<>();

    private final LottoRepository lottoRepository = LottoRepository.getInstance();

    static {
        PRIZE_MONEY.put(1, 2_000_000_000L);
        PRIZE_MONEY.put(2, 30_000_000L);
        PRIZE_MONEY.put(3, 1_500_000L);
        PRIZE_MONEY.put(4, 50_000L);
        PRIZE_MONEY.put(5, 5_000L);

        RANK_MAPPER.put(6, 1);
        RANK_MAPPER.put(5, 3);
        RANK_MAPPER.put(4, 4);
        RANK_MAPPER.put(3, 5);
    }

    public int[] getMatchCnts() {
        List<Lotto> userLotties = lottoRepository.getBuyerLotties();
        Lotto winningLotto = lottoRepository.getWinningLotto();

        int[] matchCnts = new int[6];
        for (Lotto lotto : userLotties) {
            int rank = RANK_MAPPER.getOrDefault(lotto.getMatchCnt(winningLotto), -1);
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
