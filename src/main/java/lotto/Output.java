package lotto;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

import static lotto.Constant.*;

public class Output {
    public static void printLottoPaper(List<Lotto> values) {
        System.out.println("\n" + values.size() + "개를 구매했습니다.");
        values.forEach(value -> System.out.println(Arrays.toString(value.getNumbers().toArray())));
    }

    public static void printWinningList(double cost) {
        System.out.println("당첨 통계\n---");

        Arrays.stream(LottoEnum.values())
                .filter(value -> value.getPrize().compareTo(BigDecimal.ZERO) > 0)
                .forEach(Output::printLottoResult);

        System.out.println("총 수익률은 " +
                formatDecimal(LottoEnum.sum()
                        .divide(BigDecimal.valueOf(cost))
                        .multiply(BigDecimal.valueOf(100)), "#,###.0"
                ) + "%입니다.");

    }

    private static void printLottoResult(LottoEnum value) {
        if (value.getMatchCount() == LOTTO_BONUS_HIT) {
            System.out.println("5개 일치, 보너스 볼 일치 (" +
                    formatDecimal(value.getPrize(), "#,###") + "원) - " +
                    formatDecimal(value.getWinnerCount(), "#,###") + "개");
            return;
        }

        System.out.println(value.getMatchCount() + "개 일치 (" +
                formatDecimal(value.getPrize(), "#,###") + "원) - " +
                formatDecimal(value.getWinnerCount(), "#,###") + "개");
    }

    private static String formatDecimal(BigDecimal number, String pattern) {
        return new DecimalFormat(pattern).format(number);
    }
}
