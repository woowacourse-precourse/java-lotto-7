package lotto.view;

import java.util.Arrays;
import java.util.Map;
import lotto.dto.LottoDto;
import lotto.dto.LottoStatisticsDto;
import lotto.dto.LottosDto;
import lotto.model.Rank;

public class OutputView {
    private OutputView() {
    }

    public static void printPurchaseAmountInputMessage() {
        printMessage("구입금액을 입력해 주세요.");
    }

    private static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printErrorMessage(String message) {
        printMessage(message);
    }

    public static void printPurchasedLottos(LottosDto lottosDto) {
        printErrorMessage(String.format("%s개를 구매했습니다.", lottosDto.lottos().size()));
        for (LottoDto lotto : lottosDto.lottos()) {
            System.out.println(lotto.numbers());
        }
    }

    public static void printWinningNumberInputMessage() {
        printMessage("당첨 번호를 입력해 주세요.");
    }

    public static void printBonusNumberInputMessage() {
        printMessage("보너스 번호를 입력해 주세요.");
    }

    public static void printStatistics(LottoStatisticsDto statisticsDto) {
        printMessage("\n당첨 통계\n---");

        Map<Rank, Integer> rankCounts = statisticsDto.getRankCounts();
        Arrays.stream(Rank.values())
                .filter(rank -> rank != Rank.NONE)
                .forEach(rank -> System.out.printf("%s - %d개%n", rank.getDescription(),
                        rankCounts.getOrDefault(rank, 0)));

        System.out.printf("총 수익률은 %.1f%%입니다.%n", statisticsDto.getProfitRate());
    }
}
