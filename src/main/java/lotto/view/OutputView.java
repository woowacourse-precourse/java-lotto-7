package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.constant.LottoConst;
import lotto.domain.Rank;

public class OutputView {

    private class OutputMessage {

        public static String LOTTOCOUNT_MESSAGE = "%d개를 구매했습니다.%n";
        public static String SECOND_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
        public static String THIRD_MESSAGE = "%d개 일치 (%s원) - %d개";
        public static String RETURN_RATE_MESSAGE = "총 수익률은 %s%%입니다.";
        public static String PRICE_FORMAT = "%,d";
    }

    public static void printLottoCount(int count) {
        System.out.printf(OutputMessage.LOTTOCOUNT_MESSAGE, count);
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
            System.out.println(generateResultMessage(rank, count));
        }
    }

    private static String generateResultMessage(Rank rank, Integer count) {
        if (rank.getCountNumber() == LottoConst.BONUS_NUMBER_THRESHOLD
            && rank.isNeedBonusNumber()) {
            return String.format(OutputMessage.SECOND_MESSAGE,
                rank.getCountNumber(), format(rank.getPrice()), count);
        }
        return String.format(OutputMessage.THIRD_MESSAGE,
            rank.getCountNumber(), format(rank.getPrice()), count);
    }

    private static String format(int price) {
        return String.format(OutputMessage.PRICE_FORMAT, price);
    }

    public static void printRateOfReturn(String rateOfReturn) {
        System.out.printf(OutputMessage.RETURN_RATE_MESSAGE, rateOfReturn);
    }
}
