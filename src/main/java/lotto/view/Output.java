package lotto.view;

import lotto.domain.Wallet;
import lotto.domain.lottos.RandomLottos;
import lotto.domain.lottos.user.WinningRank;

public class Output {
    private final static String PRINT_RATE_OF_RETURN_FORMAT = "총 수익률은 %.1f%%입니다.\n";

    public static void printError(String error) {
        System.out.printf("[ERROR] %s \n", error);
    }

    public static void printPurchasedLottoList(RandomLottos randomLottos) {
        System.out.println();
        System.out.printf("%s개를 구매했습니다.\n", randomLottos.getRandomLottoCount());
        System.out.print(randomLottos);
    }

    public static void printLottoWinningStatistics(WinningRank winningRank) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        WinningStatisticsPrinter.print(winningRank);
    }

    public static void printRateOfReturn(Wallet wallet) {
        System.out.printf(PRINT_RATE_OF_RETURN_FORMAT, wallet.getRateOfReturn());
    }

}
