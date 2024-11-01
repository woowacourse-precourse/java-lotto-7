package lotto.view;

import lotto.Message.ViewMessage;
import lotto.model.Lotto;
import lotto.model.LottoRank;


public class OutputView {

    public static void printAmount(int amount) {
        System.out.println(amount + "" + ViewMessage.OUTPUT_GET_AMOUNT);
    }

    public static void printLottoNumber(Lotto lotto) {
        System.out.println(lotto.getNumbers());
    }

    public static void printSuccess() {
        System.out.println("당첨 통계\n---");
    }

    public static void printResults(LottoRank rank, int count) {
        System.out.println(rank.toString() + " - " + count + "개");
    }

    public static void printRevenue(double revenue) {
        System.out.println("총 수익률은 " + String.format("%.1f", revenue) + "%입니다.");
    }
}