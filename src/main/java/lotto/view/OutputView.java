package lotto.view;

public class OutputView {
    public void promptPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void promptLottoNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void promptBonusNumber() {
        System.out.println("보너스 번호을 입력해 주세요.");
    }

    public void printPurchasableLottoCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }
}
