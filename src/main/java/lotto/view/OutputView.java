package lotto.view;

import lotto.domain.Money;
import lotto.domain.type.LottoRank;
import lotto.dto.response.LottoCalculateResponse;
import lotto.dto.response.LottoNumResponseList;

import static lotto.util.ConstantVariables.*;

public class OutputView {
    public static void printMoney(Money money) {
        int value = money.getValue();
        System.out.println(value);
    }

    public static void printLottoNum(LottoNumResponseList lottoList) {
        StringBuilder sb = new StringBuilder();

        int lottoNumCount = lottoList.lottoNumCount();

        sb.append(String.format(LOTTO_BUY_COUNT.value(), lottoNumCount));
        lottoList.lottoList().forEach(lotto -> sb.append(lotto.toString()).append("\n"));

        System.out.println(sb);
    }

    public static void printLottoResult(LottoCalculateResponse result) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(RESULT_START_FORMAT.value(), OUTPUT_START.value()));

        for (LottoRank rank : LottoRank.values()) {
            if (rank != LottoRank.NONE) {
                int count = result.prizeCounts().getOrDefault(rank, 0);
                sb.append(makePerLottoResult(rank, count));
            }
        }

        sb.append(String.format(LOTTO_PROFIT.value(), result.earningRate()));
        System.out.print(sb);
    }

    private static String makePerLottoResult(LottoRank rank, int count) {
        if (rank == LottoRank.FIVE_WITH_BONUS) {
            return String.format(LOTTO_RESULT_BONUS.value(),
                    rank.getMatchCount(),
                    rank.getFormattedPrize(),
                    count);
        }

        return String.format(LOTTO_RESULT.value(),
                rank.getMatchCount(),
                rank.getFormattedPrize(),
                count);
    }
}
