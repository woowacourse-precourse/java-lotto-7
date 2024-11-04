package lotto.view;

import java.util.List;

public class OutputView {
    public void showTotalEarningRatio(String formatEarningRatio) {
        System.out.println("총 수익률은 " + formatEarningRatio + "%입니다.");
    }

    public void showWinningResult(int threeMatched, int fourMatched, int fiveMatched, int bonusMatched,
                                  int allMatched) {
        System.out.println("3개 일치 (5,000원) - " + threeMatched + "개");
        System.out.println("4개 일치 (50,000원) - " + fourMatched + "개");
        System.out.println("5개 일치 (1,500,000원) - " + fiveMatched + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + bonusMatched + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + allMatched + "개");
    }

    public void showWinningStatistics() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public void showRequestBonusNumberComment() {
        System.out.println("보너스 번호를 입력해주세요.");
    }

    public void showRequestLottoNumberComment() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void showPurchaseResult(int purchaseCount) {
        System.out.println(purchaseCount + "개를 구매했습니다.");
    }

    public void showLottoNumbers(int i, List<List<Integer>> lottoNumbers) {
        System.out.println(lottoNumbers.get(i));
    }

    public void showInsertNewLine() {
        System.out.println();
    }

    public void showStartComment() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void showErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    public void showBonusNumberErrorMessage() {
        System.out.println("[ERROR] 보너스 번호는 숫자만 입력할 수 있습니다.");
    }

    public void showCostErrorMessage() {
        System.out.println("[ERROR] 금액은 숫자만 입력할 수 있습니다.");
    }

    public void showLottoNumberErrorMessage() {
        System.out.println("[ERROR] 로또 번호는 숫자만 입력할 수 있습니다.");
    }
}
