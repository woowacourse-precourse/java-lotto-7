package lotto.util;

import lotto.domain.LottoNumber;
import lotto.domain.Lottos;

import java.util.stream.Collectors;

public class StringMaker {

    public static String make(Lottos lottos) {
        StringBuilder result = new StringBuilder();

        result.append("\n").append(lottos.size()).append("개를 구매했습니다.\n");
        lottos.getValue().forEach(lotto -> {
            result.append("[");
            result.append(lotto.getValue().stream().map(LottoNumber::getValue).map(String::valueOf).collect(Collectors.joining(", ")));
            result.append("]\n");
        });

        return result.toString();
    }

    public static String make(Double earningRate, int[] countPerWinningRank) {
        StringBuilder result = new StringBuilder();

        result.append("\n당첨 통계\n---\n")
                .append("3개 일치 (5,000원) - ").append(countPerWinningRank[5]).append("\n")
                .append("4개 일치 (50,000원) - ").append(countPerWinningRank[4]).append("\n")
                .append("5개 일치 (1,500,000원) - ").append(countPerWinningRank[3]).append("\n")
                .append("5개 일치, 보너스 볼 일치 (30,000,000원) - ").append(countPerWinningRank[2]).append("\n")
                .append("6개 일치 (2,000,000,000원) - ").append(countPerWinningRank[1]).append("\n")
                .append("총 수익률은 ").append(earningRate).append("%입니다.");

        return result.toString();
    }
}
