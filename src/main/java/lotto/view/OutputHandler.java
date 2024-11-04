package lotto.view;

import lotto.PrizeRank;
import lotto.dto.LottoDto;
import lotto.dto.LottosDto;
import lotto.dto.RankResultDto;

import java.util.*;

import static lotto.Constants.*;

public class OutputHandler {

    public void outputPurchaseInfo(final LottosDto lottosDto) {
        List<LottoDto> lottos = lottosDto.lottos();
        System.out.printf(PURCHASE_INFO_TEMPLATE, lottos.size());
        lottos.forEach(System.out::println);
    }

    public void outputResults(List<RankResultDto> winningResults) {
        Map<Integer, Integer> rankCounts = new HashMap<>();

        for (RankResultDto resultDto : winningResults) {
            int rank = resultDto.rank();
            rankCounts.put(rank, rankCounts.getOrDefault(rank, 0) + 1);
        }

        System.out.printf(WINNING_STATISTICS_HEADER);

        EnumSet.allOf(PrizeRank.class).stream()
                .filter(rank -> rank != PrizeRank.NONE)
                .forEach(rank -> {
                    int count = rankCounts.getOrDefault(rank.getRank(), 0);
                    String resultText = rank.getMatchCount() + MATCH_COUNT_SUFFIX;

                    if (rank.isSecondRank()) {
                        resultText += BONUS_BALL_MATCH;
                    }

                    String formattedPrize = String.format("%,d", rank.getPrize());
                    System.out.printf(RESULT_FORMAT, resultText, formattedPrize, count);
                });
    }

    public void outputWinningStatics(double profitRate) {
        System.out.printf(PROFIT_RATE_TEMPLATE, profitRate);
    }
}