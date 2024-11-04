package lotto;

import java.util.List;

public class ConsoleOutput {
    public static void printPurchasedLottos(List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다.%n", lottos.size());
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public static void printResults(LottoResult result) {
        System.out.println("당첨 통계\n---");
        String[] prizeText = {
                "6개 일치 (2,000,000,000원) - ",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - ",
                "5개 일치 (1,500,000원) - ",
                "4개 일치 (50,000원) - ",
                "3개 일치 (5,000원) - "
        };

        int minLength = Math.min(prizeText.length, result.getResults().length);
        for (int i = 0; i < minLength; i++) {
            System.out.println(prizeText[i] + result.getResults()[i] + "개");
        }

        System.out.printf("총 수익률은 %.1f%%입니다.%n", result.getRateOfReturn());
    }

}
