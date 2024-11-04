package lotto.io;

import lotto.domain.Lotto;
import lotto.domain.statistic.Statistic;

public class OutputHandler {

    public void showPurchaseCostInputComments() {
        System.out.println("구입금액을 입력해주세요.");
    }

    public void showWinningLottoInputComment() {
        System.out.println("당첨 번호를 입력해주세요");
    }

    public void showWinningLottoBonusNumberInputComment() {
        System.out.println("보너스 번호를 입력해주세요");
    }

    public void showErrorMessage(String message) {
        System.out.println(message);
    }

    public void showPurchaseLottoCount(long purchaseCost) {
        System.out.println(purchaseCost + "개를 구매했습니다.");
    }

    public void showWinningStatistics(Statistic statistic) {

        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + statistic.getFifth() + "개");
        System.out.println("4개 일치 (50,000원) - " + statistic.getFourth() + "개");
        System.out.println("5개 일치 (1,500,000원) - " + statistic.getThird() + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + statistic.getSecond() + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + statistic.getFirst() + "개");

    }

    public void showNumber(Lotto lotto) {
        System.out.println(lotto.getNumbers());
    }

    public void showInterestRate(double interestRate) {
        System.out.println("총 수익률은 " + interestRate + "%입니다.");
    }
}
