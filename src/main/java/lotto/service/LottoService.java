package lotto.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.dto.LottoDTO;
import lotto.dto.LottoResultDTO;
import lotto.dto.LottoStatisticsDTO;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.WinningLotto;

public class LottoService {
    private final int INITIAL_VALUE = 0;

    public LottoResultDTO checkWinnings(Lottos userLottos, WinningLotto winningLotto) {
        List<LottoDTO> lottoDTOs = userLottos.toDtoList();

        List<Integer> winningCounts = new ArrayList<>(
                Arrays.asList(INITIAL_VALUE, INITIAL_VALUE, INITIAL_VALUE, INITIAL_VALUE, INITIAL_VALUE));
        int totalPrize = INITIAL_VALUE;

        for (LottoDTO lottoDTO : lottoDTOs) {
            Lotto lotto = new Lotto(lottoDTO.getNumbers());

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
        return Rank.fromRank(rank).getPrize();
    }

}
