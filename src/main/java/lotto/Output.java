package lotto;

import java.util.List;
import java.util.Map;

public class Output {

    public void printPurchaseLotto(List<Lotto> lottos) {
        System.out.printf("\n%d개를 구매했습니다.\n", lottos.size());
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printWinningResult(Map<String, Integer> winningResult, double yield) {
        String result = """
                
                당첨 통계
                ---
                3개 일치 (5,000원) - %s개
                4개 일치 (50,000원) - %s개
                5개 일치 (1,500,000원) - %s개
                5개 일치, 보너스 볼 일치 (30,000,000원) - %s개
                6개 일치 (2,000,000,000원) - %s개
                총 수익률은 %s%%입니다.
                """
                .formatted(
                        winningResult.get("MATCH_3"),
                        winningResult.get("MATCH_4"),
                        winningResult.get("MATCH_5"),
                        winningResult.get("MATCH_5_BONUS"),
                        winningResult.get("MATCH_6"),
                        String.format("%.1f", yield)
                );
        System.out.println(result);
    }

    public void printErrorMessage(String message) {
        System.out.println("[ERROR] " + message);
    }
}
