package lotto.view;

import lotto.model.lotto.Lotto;
import lotto.model.result.LottoResult;
import lotto.model.result.Rank;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String LINE_BREAK = "\n";

    public static void printLottoAmount(int input) {
        System.out.println(LINE_BREAK + input + "개를 구매했습니다.");
    }

    public static void printRateOfReturn(double rateOfReturn) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", rateOfReturn);
    }

    // 구매한 로또 리스트 출력
    public static void printPurchasedLottos(List<Lotto> purchasedLottos) {
        for (Lotto lotto : purchasedLottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printWinningStatisticHeader() {
        System.out.println("당첨 통계\n---");
    }

    // 당첨 결과 출력
    public static void printLottoResult(LottoResult lottoResult) {
        printWinningStatisticHeader();

        Map<Rank, Integer> rankResults = lottoResult.getRankResults();
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.KOREA);

        for (Rank rank : Rank.values()) {
            int prize = rank.getPrize();
            String formattedPrize = numberFormat.format(prize) + "원";
            int count = rankResults.getOrDefault(rank, 0);

            if (rank.getMatchCount() == 5 && rank.isBonusMatch()) {
                System.out.println("5개 일치, 보너스 볼 일치 (" + formattedPrize + ") - " + count + "개");
                continue;  // 5개 일치, 보너스 볼 일치가 출력되면 5개 일치 기본 출력은 건너뜁니다.
            }
            System.out.println(rank.getMatchCount() + "개 일치 (" + formattedPrize + ") - " + count + "개");
        }
    }
}