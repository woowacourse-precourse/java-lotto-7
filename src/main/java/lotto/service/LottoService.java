package lotto.service;

import java.util.List;
import lotto.dto.LottoResultDTO;
import lotto.dto.LottoStatisticsDTO;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.WinningLotto;

/*
이거 하드코딩 값 포장해주고, 비즈니스 로직은 DTO 생성 후에 다시 손봐야함.
 */
public class LottoService {
    private final int INITIAL_VALUE = 0;

    public LottoResultDTO checkWinnings(Lottos userLottos, WinningLotto winningLotto) {
        List<Integer> winningCounts = List.of(INITIAL_VALUE, INITIAL_VALUE, INITIAL_VALUE, INITIAL_VALUE,
                INITIAL_VALUE);
        int totalPrize = INITIAL_VALUE;

        for (Lotto lotto : userLottos.getLottos()) {
            int matchCount = winningLotto.countMatches(lotto);
            boolean bonusMatch = winningLotto.isBonusMatched(lotto);

            int rank = calculateRank(matchCount, bonusMatch);
            int prize = calculatePrize(rank);
            totalPrize += prize;

            if (rank > 0) {
                winningCounts.set(rank - 1, winningCounts.get(rank - 1) + 1);
            }
        }

        return new LottoResultDTO(winningCounts, totalPrize);
    }

    public LottoStatisticsDTO calculateProfitRate(int purchaseAmount, int totalPrize) {
        double profitRate = ((double) totalPrize / purchaseAmount) * 100;
        return new LottoStatisticsDTO(purchaseAmount, totalPrize, profitRate);
    }

    private int calculateRank(int matchCount, boolean bonusMatch) {
        if (matchCount == 6) {
            return 1;
        }
        if (matchCount == 5 && bonusMatch) {
            return 2;
        }
        if (matchCount == 5) {
            return 3;
        }
        if (matchCount == 4) {
            return 4;
        }
        if (matchCount == 3) {
            return 5;
        }
        return 0;
    }

    private int calculatePrize(int rank) {
        switch (rank) {
            case 1:
                return 2_000_000_000;
            case 2:
                return 30_000_000;
            case 3:
                return 1_500_000;
            case 4:
                return 50_000;
            case 5:
                return 5_000;
            default:
                return 0;
        }
    }
}
