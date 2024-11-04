package lotto.view;

public class OutputView {

    public void printBuyLottoCount(int buyLottoCount) {
        System.out.println();
        System.out.println(buyLottoCount + "개를 구매했습니다.");
    }

    public void printLottoNumbers(String lottoNumber) {
        System.out.println("[" + lottoNumber + "]");
    }

    public void printBeforeWinningLottoStatistics() {
        System.out.println("당첨 통계");
        System.out.println("----");
    }

    public void printWinningLottoStatistics(int matchedCount, String prize, int count) {
        System.out.println(matchedCount + "개 일치 (" + prize + "원) - " + count + "개");
    }

    public void printWinningLottoStatisticsHasBonus(int matchedCount, String prize, int count) {
        System.out.println(matchedCount + "개 일치, 보너스 볼 일치 (" + prize + "원) - " + count + "개");

    }

    public void printRateOfReturn(double rateOfReturn) {
        System.out.println("총 수익률은 " + rateOfReturn + "%입니다.");
    }

    public void printWhiteSpace() {
        System.out.println();
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }
}
