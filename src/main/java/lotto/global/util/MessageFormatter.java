package lotto.global.util;

import java.util.Map;
import lotto.winningNumber.domain.LottoResult;

public abstract class MessageFormatter {

    public static String getLotteryResults(Map<LottoResult, Integer> matchResults) {
        StringBuilder sb = new StringBuilder();
        for (int i = LottoResult.values().length - 1; i > 0; i--) {
            LottoResult lottoResult = LottoResult.values()[i];
            sb.append(lottoResult.getDescription())
                    .append(matchResults.get(lottoResult))
                    .append("개").append("\n");
        }
        return sb.toString();

    }

    public static String getReturnRate(Map<LottoResult, Integer> matchResults, int amount) {
        int sum = matchResults.entrySet().stream().mapToInt(m -> m.getKey().getPrice() * m.getValue()).sum();

        double earning = (double) (sum - amount) / amount * 100;
        return String.format("총 수익률은 %.2f%% 입니다.", earning);
    }
}
