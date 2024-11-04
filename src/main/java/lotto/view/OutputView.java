package lotto.view;

public class OutputView {
    public void printRequirePurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printRequireWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printRequireBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printWinningStatistics() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public void printLottoPurchaseAmount(final int lottoPurchaseAmount) {
        System.out.println();
        System.out.println(lottoPurchaseAmount + "개를 구매했습니다.");
    }
}
