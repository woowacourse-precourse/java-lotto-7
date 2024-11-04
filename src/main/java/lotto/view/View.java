package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.LottoRank;

public class View {
    private static final String EMPTY_LINE = "";

    public String getUserInput() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public void printPurchaseMessage(int tickets) {
        System.out.println(EMPTY_LINE);
        System.out.println(tickets + "개를 구매했습니다.");
    }

    public void printLottoNumbers(List<Lotto> lottoNumbers) {
        for (int i = 0; i < lottoNumbers.size(); i++) {
            System.out.println(lottoNumbers.get(i));
        }
    }

    public String getWinningNumbers() {
        System.out.println(EMPTY_LINE);
        System.out.println("당첨 번호를 입력해 주세요.");

        return Console.readLine();
    }

    public String getBonusNumbers() {
        System.out.println(EMPTY_LINE);
        System.out.println("보너스 번호를 입력해 주세요.");

        return Console.readLine();
    }

    public void displayResults(Map<LottoRank, Integer> results, double profitRate) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + results.get(LottoRank.THREE_MATCH) + "개");
        System.out.println("4개 일치 (50,000원) - " + results.get(LottoRank.FOUR_MATCH) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + results.get(LottoRank.FIVE_MATCH) + "개");
        System.out.println(
                "5개 일치, 보너스 볼 일치 (30,000,000원) - " + results.get(LottoRank.FIVE_MATCH_BONUS) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + results.get(LottoRank.SIX_MATCH) + "개");

        System.out.println("총 수익률은 " + String.format("%.1f", profitRate) + "%입니다.");
    }
}

