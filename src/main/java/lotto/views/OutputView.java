package lotto.views;

import java.util.ArrayList;
import java.util.Map;

public class OutputView {
    public void displayPurchaseAmount (int amount) {
        System.out.println(amount + "개를 구매했습니다.");
    }

    public void displayIssuedNumbers(ArrayList<ArrayList<Integer>> allIssuedNumbers) {
        for (ArrayList<Integer> issuedNumbers : allIssuedNumbers) {
            System.out.println(issuedNumbers);
        }
    }

    public enum Prize {
        Three("3개 일치 (5,000원) - "),
        Four("4개 일치 (50,000원) - "),
        Five("5개 일치 (1,500,000원) - "),
        FiveAndBonus("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
        Six("6개 일치 (2,000,000,000원) - ")
        ;

        private final String prizePrompt;

        Prize(String prizePrompt) {
            this.prizePrompt = prizePrompt;
        }

        public String getWinningPrompt() {
            return prizePrompt;
        }
    }
    public void displayLottoStatic(Map<Prize, Integer> statistics) {
        System.out.println("당첨 통계");
        System.out.println("---");

        for (Map.Entry<Prize, Integer> entry : statistics.entrySet()) {
            Prize prize = entry.getKey();
            int count = entry.getValue();
            System.out.println(prize.getWinningPrompt() + " - " + count + "개");
        }
    }

    public void displayRateOfReturn (float rateOfReturn) {
        System.out.printf("총 수익률은 %f입니다.%n", rateOfReturn);
    }

}
