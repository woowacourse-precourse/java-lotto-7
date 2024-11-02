package lotto.view;

public class OutputView {

    public void printBuyLottoCount(int buyLottoCount) {
        System.out.println(buyLottoCount + "개를 구매했습니다.");
    }

    public void printLottoNumbers(String lottoNumber) {
        System.out.println("[" + lottoNumber + "]");
    }

    public void printBeforeWinningLottoInfo() {
        System.out.println("당첨 통계");
        System.out.println("----");
    }

    public void printWinningLottoInfo(int matchedCount, String prize, int count) {
        System.out.println(matchedCount + "개 일치 (" + prize + "원) - " + count + "개");
    }

    public void printReteOfReturn(String rateOfReturn) {
        System.out.println(rateOfReturn);
    }
}
