package lotto.view;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import lotto.domain.LottoPrize;

public class LottoStatisticsDto {
    private static final String LINE_SEPARATOR = System.lineSeparator();

    private final Map<LottoPrize, Integer> prizeCount;
    private final double rateOfReturn;

    public LottoStatisticsDto(Map<LottoPrize, Integer> prizeCount, double rateOfReturn) {
        this.prizeCount = prizeCount;
        this.rateOfReturn = rateOfReturn;
    }


    @Override
    public String toString() {
        List<LottoPrize> sorted = Arrays.stream(LottoPrize.values())
                .sorted(Comparator.comparing(LottoPrize::getMoney))
                .toList();

        StringBuilder sb = new StringBuilder();
        for (LottoPrize lottoPrize : sorted) {
            if (lottoPrize == LottoPrize.NOTHING) {
                continue;
            }
            sb.append(lottoPrizeToPrintFormat(lottoPrize, prizeCount.get(lottoPrize)))
                    .append(LINE_SEPARATOR);
        }
        sb.append(String.format("총 수익률은 %,f%%입니다.", rateOfReturn));
        return sb.toString();
    }

    private String lottoPrizeToPrintFormat(LottoPrize lottoPrize, int count) {
        return String.format("%d개 일치%s (%,d원) - %,d개",
                lottoPrize.getMatchCount(),
                hasBonus(lottoPrize),
                lottoPrize.getMoney(),
                count);
    }

    private String hasBonus(LottoPrize lottoPrize) {
        if (lottoPrize.doesBonusNumberMatters()) {
            return ", 보너스 볼 일치";
        }
        return "";
    }
}
