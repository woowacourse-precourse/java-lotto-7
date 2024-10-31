package lotto.view;

import lotto.domain.Wallet;
import lotto.domain.lottos.RandomLottos;
import lotto.domain.lottos.user.WinningLotto;

public class Output {
    private final static String PRINT_RANK_FORMAT = "%d개 일치 (%s원) - %d개\n";
    private final static String PRINT_SECOND_RANK_FORMAT = "%d개 일치, 보너스 볼 일치 (%s원) - %d개\n";
    private final static String PRINT_RATE_OF_RETURN_FORMAT = "총 수익률은 %.1f%%입니다.\n";


    public static void printError(String error) {
        System.out.printf("[ERROR] %s \n", error);
    }

    public static void printPurchasedLottoList(Wallet wallet, RandomLottos randomLottos) {
        System.out.println();
        System.out.printf("%s개를 구매했습니다.\n", wallet);
        System.out.println(randomLottos);
    }

    public static void printLottoWinningStatistics(WinningLotto winningLottos) {
        System.out.println("당첨 통계");
        System.out.println("---");
        WinningStatisticPrinter.print(winningLottos);
    }

    public static void printRateOfReturn(Wallet wallet) {
        System.out.printf(PRINT_RATE_OF_RETURN_FORMAT, wallet.getRateOfReturn());
    }


}
