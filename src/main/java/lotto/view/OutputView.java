package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class OutputView {

    public static void printLottoAmount(int lottoAmount) {
        System.out.println(lottoAmount + "개를 구매했습니다.");
    }

    public static void printMyLottoNumber(List<Lotto> myLottos) {
        for (Lotto lotto : myLottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printResultMessage() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public static void printLottoResult(String message, int count) {
        System.out.println(message + " - " + count + "개");
    }

    public static void printTotalProfit(double totalProfit) {
        System.out.println("총 수익률은 " + String.format("%.1f",totalProfit) + "%입니다.");
    }
}
