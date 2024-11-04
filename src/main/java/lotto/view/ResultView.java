package lotto.view;

import static lotto.constants.ResultMessages.*;

import lotto.dto.LottoDTO;
import lotto.model.Lotto;
import lotto.model.Rank;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ResultView {

    public static void printLottos(List<LottoDTO> lottos) {
        System.out.printf(PURCHASED_COUNT + "%n", lottos.size());
        for (LottoDTO lottoDTO : lottos) {
            List<Integer> numbers = new ArrayList<>(lottoDTO.getNumbers());
            Collections.sort(numbers);
            System.out.println(numbers);
        }
    }

    public static void printResults(Map<Rank, Integer> results, double profitRate) {
        System.out.println(RESULT_HEADER);
        printRankResults(results);
        System.out.printf((TOTAL_PROFIT) + "%n", profitRate);
    }

    private static void printRankResults(Map<Rank, Integer> results) {
        for (Rank rank : Rank.values()) {
            if (rank == Rank.NONE) {
                continue;
            }
            int count = results.getOrDefault(rank, 0);
            printRankResult(rank, count);
        }
    }

    private static void printRankResult(Rank rank, int count) {
        String prize = String.format("%,d", rank.getPrize());
        if (rank == Rank.SECOND) {
            System.out.printf((MATCH_COUNT_WITH_BONUS_RESULT) + "%n", prize, count);
            return;
        }
        System.out.printf((MATCH_COUNT_RESULT) + "%n", rank.getMatchCount(), prize, count);
    }
}
