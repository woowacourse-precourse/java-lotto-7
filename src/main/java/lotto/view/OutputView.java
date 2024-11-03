package lotto.view;

import java.util.Map;
import lotto.model.LottoResult;
import lotto.model.LottoTicket;

public class OutputView {
    public static void printPurchaseMessage(int lottoCount) {
        System.out.println("\n" + lottoCount + "개를 구매했습니다.");
    }

    public static void printLottos(LottoTicket lottoTicket) {
        lottoTicket.getLottos().forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public static void printWinningStatistics(Map<LottoResult, Integer> lottoResultCount) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        for (LottoResult lottoResult : LottoResult.values()) {
            if (lottoResult == LottoResult.FIVE_BONUS) {
                System.out.printf("%d개 일치, 보너스 볼 일치 (%,d원) - %d개%n",
                        lottoResult.getMatchCount(), lottoResult.getPrizeMoney(),
                        lottoResultCount.getOrDefault(lottoResult, 0));
                continue;
            }
            System.out.printf("%d개 일치 (%,d원) - %d개%n", lottoResult.getMatchCount(),
                    lottoResult.getPrizeMoney(), lottoResultCount.getOrDefault(lottoResult, 0));
        }
    }

    public static void printRateEarning(double rateEarning) {
        System.out.printf("총 수익률은 %.1f%%입니다.", rateEarning);
    }

    public static void printErrorMessage(String message) {
        System.out.println(message);
    }
}
