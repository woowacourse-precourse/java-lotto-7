package lotto.view;

import java.util.Map;
import lotto.domain.Winning;

public class OutputView {
    public void askBuyingPriceView() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void responseBuyingQuantity(int lottoNum) {
        System.out.println();
        System.out.println(lottoNum + "개를 구매했습니다.");
    }

    public void askWinningLotto() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void askBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    /*public void responseWinningHistory(Map<Winning, Integer> countOfWinning) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + countOfWinning.getOrDefault(Winning.THIRD, 0) + "개");
        System.out.println("4개 일치 (50,000원) - " + countOfWinning.getOrDefault(Winning.FOURTH, 0) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + countOfWinning.getOrDefault(Winning.FIFTH, 0) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + countOfWinning.getOrDefault(Winning.FIFTH_WITH_BONUS, 0) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + countOfWinning.getOrDefault(Winning.FI, 0) + "개");
    }*/

    public void responseRateOfReturn(String rateOfReturn) {
        System.out.println("총 수익률은 " + rateOfReturn + "%입니다.");
    }

}
