package lotto.view;

import lotto.Lotto;

import java.util.List;

public class OutputView {
    private final String LOTTO_COUNT = "개를 구매했습니다.";

    public void printLottoNumber(int number){
        System.out.println();
        System.out.println(number + LOTTO_COUNT);
    }

    public void printLottos(List<Lotto> lottos){
        for(Lotto l : lottos){
            System.out.println(l);
        }
    }

    public static void printSuccessMessage(String message, int count){
        System.out.println(message + count + "개");
    }

    public static void printSuccessResult() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public static void printRevenueRate(double earning){
        System.out.println("총 수익률은 " + String.format("%.1f", earning) + "%입니다.");
    }

}
