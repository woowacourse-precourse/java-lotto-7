package lotto.view;

public class OutputView {

    public void printBuyLottoCount(int buyLottoCount) {
        System.out.println(buyLottoCount + "개를 구매했습니다.");
    }

    public void printLottoNumbers(String lottoNumber) {
        System.out.println("[" + lottoNumber + "]");
    }
}
