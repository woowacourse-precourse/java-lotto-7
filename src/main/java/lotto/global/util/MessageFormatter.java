package lotto.global.util;

import java.util.Map;
import lotto.winningNumber.domain.LottoResult;

public abstract class MessageFormatter {

    public static String getLotteryResults(Map<LottoResult, Integer> matchResults) {
        StringBuilder sb = new StringBuilder();
        for (int i = LottoResult.values().length - 2; i >= 0; i--) {
            LottoResult lottoResult = LottoResult.values()[i];
            sb.append(lottoResult.getDescription())
                    .append(matchResults.get(lottoResult))
                    .append("개").append("\n");
        }
        return sb.toString();
    }

    public static String getReturnRate(Map<LottoResult, Integer> matchResults, int amount) {
        long sum = matchResults.entrySet().stream().mapToInt(m -> m.getKey().getPrice() * m.getValue()).sum();

        double earning = (double) sum / amount * 100;
        return String.format("%.1f%%", Math.round(earning * 100.0) / 100.0);
    }

}
