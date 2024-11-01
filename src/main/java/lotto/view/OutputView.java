package lotto.view;

import lotto.Message.ViewMessage;
import lotto.model.Lotto;
import lotto.model.LottoRank;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class OutputView {

    public static void printAmount(int amount) {
        System.out.println(amount + "" + ViewMessage.OUTPUT_GET_AMOUNT);
    }

    // 나눠야 댐
    public static void printLottoNumbers(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            printLottoNumber(lotto);
        }
    }

    public static void printLottoNumber(Lotto lotto) {
        System.out.println(lotto.getNumbers());
    }

    // 나눠야 딤
    public static void printResults(Map<LottoRank, Integer> resultCounts) {
        System.out.println("당첨 통계\n---");
        List<LottoRank> ranks = Arrays.asList(LottoRank.values());
        Collections.reverse(ranks);

        for (LottoRank rank : ranks) {
            if (rank != LottoRank.MISS) {
                System.out.println(rank.toString() + " - " + resultCounts.getOrDefault(rank, 0) + "개");
            }
        }
    }

    public static void printRevenue(int sum, int amount) {
        double result =(double) sum / amount *100;
        System.out.println("총 수익률은 " + result + "%입니다.");
    }
}
