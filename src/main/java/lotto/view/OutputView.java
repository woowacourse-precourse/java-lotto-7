package lotto.view;

import java.util.List;

public class OutputView {

    public void getMoney() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void buyLotto(int lottoCount) {
        System.out.println("\n" + lottoCount + "개를 구매했습니다.");
    }

    public void displayLotto(List<Integer> lotto) {
        System.out.println(lotto);
    }

    public void getWinningNumber() {
        System.out.println(System.lineSeparator() + "당첨 번호를 입력해 주세요.");
    }

    public void getBonusNumber() {
        System.out.println(System.lineSeparator() + "보너스 번호를 입력해 주세요.");
    }

    public void guideStatistics() {
        System.out.println(System.lineSeparator() + "당첨 통계" + System.lineSeparator() + "---");
    }

    public void showWinningResult(int lottoCount, String lottoRankMoney, int lottoRankCount, boolean isBonus) {
        if (isBonus) {
            System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개" + System.lineSeparator(), lottoCount, lottoRankMoney,
                    lottoRankCount);
        }
        System.out.printf("%d개 일치 (%s원) - %d개" + System.lineSeparator(), lottoCount, lottoRankMoney, lottoRankCount);
    }

    public void showReturnRate(double returnRate) {
        System.out.println("총 수익률은 " + returnRate + "%입니다.");
    }

    public void showError(String error) {
        System.out.println(error);
    }
}
