package lotto.view;

import java.util.List;
import java.text.NumberFormat;
import java.util.Locale;

public class LottoOutputView {
    public String getLottoCountMessage(int count) {
        return count + "개를 구매했습니다.";
    }

    public String getLottoNumbersMessage(List<Integer> numbers) {
        return numbers.toString();
    }

    public String getWinningStatisticsHeader() {
        return "당첨 통계\n---\n";
    }

    public String getWinningResultMessage(int matchCount, int prize, int count) {
        String result = matchCount + "개 일치";
        if (matchCount == 5 && prize == 30000000) {
            result += ", 보너스 볼 일치";
        }
        return result + " (" + formatPrize(prize) + "원) - " + count + "개";
    }

    private String formatPrize(int prize) {
        return NumberFormat.getNumberInstance(Locale.KOREA).format(prize);
    }

    public String getProfitRateMessage(double profitRate) {
        return String.format("총 수익률은 %.1f%%입니다.", profitRate);
    }
}