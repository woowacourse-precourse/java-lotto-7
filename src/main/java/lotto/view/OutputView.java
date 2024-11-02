package lotto.view;

public class OutputView {

    public void printBuyLottoCount(int buyLottoCount) {
        System.out.println(buyLottoCount + "개를 구매했습니다.");
    }

    public void printLottoNumbers(String lottoNumber) {
        System.out.println("[" + lottoNumber + "]");
    }

    public void printWinningData(String agreementCount, String winningMoney, String winningCount) {
        System.out.println("당첨 통계");
        System.out.println("----");
        System.out.print(agreementCount + "개 일치 (" + winningMoney + ") - " + "개");
    }

    public void printReteOfReturn(String rateOfReturn) {
        System.out.println(rateOfReturn);
    }
}
