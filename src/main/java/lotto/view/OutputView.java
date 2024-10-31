package lotto.view;
public class OutputView {

    public void printMoneyInputMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printPurchasedLottoCount(int lottoCount) {
        System.out.println("\n" + lottoCount + "개를 구매했습니다.");
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printWinnerNumbersInputMessage() {
        System.out.println("\n당첨 번호를 입력해주세요.");
    }

    public void printBonusNumberInputMessage() {
        System.out.println("\n보너스 번호를 입력해주세요.");
    }

    public void printLottoResultHeader() {
        System.out.println("\n당첨 통계");
        System.out.println("---");
    }

    public void printRateOfReturn(double rateOfReturn) {
        System.out.println(String.format("총 수익률은 %.1f%%입니다.", rateOfReturn));
    }
}
