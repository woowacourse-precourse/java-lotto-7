package lotto.view;

import java.util.List;

public class OutputView {

    public static void showBuyLottos(int numberOfTickets, List<String> lottoNumbers) {
        System.out.println(numberOfTickets + "개를 구매했습니다.");
        for (String lottoNumber : lottoNumbers) {
            System.out.println(lottoNumber);
        }
    }

    public static void showLottoResult(int match3Count,int match4Count,int match5Count,
        int match5WithBonusCount,int match6Count,double money) {
        System.out.println("\n당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - " + match3Count + "개");
        System.out.println("4개 일치 (50,000원) - " + match4Count + "개");
        System.out.println("5개 일치 (1,500,000원) - " + match5Count + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + match5WithBonusCount + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + match6Count + "개");
        System.out.printf("총 수익률은 %.1f%%입니다.%n", money);
    }

}
