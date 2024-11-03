package lotto.view;

import lotto.domain.Consumer;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;

import java.util.HashMap;

public class OutputView {

    private final static String LOTTO_RESULT = "당첨 통계\n ---";

    public static void ErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public static void printLottoCount(int number) {
        System.out.println("\n" + number + "개를 구매했습니다.");
    }

    public static void printLottoes(Consumer lottoes) {
        for (Lotto lotto : lottoes.getLottoes()) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printLottoMessage() {
        System.out.println(LOTTO_RESULT);
    }

    public static void printLottoRank(HashMap<LottoRank, Integer> lottoRank) {
        for (LottoRank rank : LottoRank.values()) {
            if (rank.getCount() >= 3) {
                printRank(lottoRank, rank);
            }
        }
    }

    private static void printRank(HashMap<LottoRank, Integer> lottoRank, LottoRank rank) {
        String bonusMessage = "";

        if (rank.getBonus()) {
            bonusMessage = ", 보너스 볼 일치";
        }

        System.out.printf("%d개 일치%s (%s원) - %d개%n",
                rank.getCount(),
                bonusMessage,
                rank.getStringPrice(),
                lottoRank.get(rank));
    }

    public static void printTotalYield(double yield) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", yield);
    }

}
