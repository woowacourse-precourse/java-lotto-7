package lotto;

import lotto.controller.LottoController;

public class Application {
    public static void main(String[] args) {

        LottoController lottoController = new LottoController();

        //로또 구매
        lottoController.getPurchasePrice();
        lottoController.purchaseLotto();

        //당첨 번호 입력
        lottoController.getWinningNumbers();

        //보너스 번호 입력
        lottoController.getBonusNumber();

        //매칭 및 결과 출력
        lottoController.printResult();

        //수익률 출력
        lottoController.printProfitRate();
    }
}
