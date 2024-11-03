package lotto.io;

import lotto.dto.LottoPrize;

import java.util.List;
import java.util.Map;

import static lotto.Utils.Convertor.convert;

public class OutputHandler {
    public static void printLottoCount(int lottoCount) {
        System.out.println();
        System.out.printf("%d개를 구매했습니다.", lottoCount);
        System.out.println();
    }

    public static void printLottos(List<String> lottoNumbers) {
        System.out.print("[");
        System.out.print(String.join(", ", lottoNumbers));
        System.out.println("]");
    }

    public static void printWinningStatistics() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public static void printWinningCount(Map<LottoPrize, Integer> result) {
        for (LottoPrize lottoPrize : LottoPrize.values()) {
            if (lottoPrize == LottoPrize.BONUS) {
                System.out.printf("%d개 일치, 보너스 볼 일치 (%s) - %d개\n", lottoPrize.getCount(), convert(lottoPrize.getPrice()), result.get(lottoPrize));
            }
            System.out.printf("%d개 일치 (%s) - %d개\n", lottoPrize.getCount(), convert(lottoPrize.getPrice()), result.get(lottoPrize));
        }
    }

    public static void printYield(double yield) {
        System.out.printf("총 수익률은 %.2f%%입니다.", yield);
    }

    private OutputHandler() {}
}
