package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.constant.LottoConst;
import lotto.model.Rank;

public class OutputView {

    public static void printLottoCount(int count) {
        System.out.printf("%d개를 구매했습니다.%n", count);
    }

    public static void printLottoNumbers(List<String> convertedNumbers) {
        convertedNumbers.stream()
            .forEach(System.out::println);
    }

    public static void printResult(Map<Rank, Integer> result) {
        for (Map.Entry<Rank, Integer> entry : result.entrySet()) {
            Rank rank = entry.getKey();
            Integer count = entry.getValue();
            if (rank == Rank.NONE) continue;
            if (rank.getCountNumber() == LottoConst.BONUS_NUMBER_THRESHOLD
                && rank.isNeedBonusNumber()) {
                System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개%n",
                    rank.getCountNumber(), format(rank.getPrice()), count);
                continue;
            }
            System.out.printf("%d개 일치 (%s원) - %d개%n",
                rank.getCountNumber(), format(rank.getPrice()), count);
        }
    }

    private static String format(int price) {
        return String.format("%,d", price);
    }

    public static void printRateOfReturn(String rateOfReturn) {
        System.out.printf("총 수익률은 %s%%입니다.", rateOfReturn);
    }
}
