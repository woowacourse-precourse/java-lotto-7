package lotto;

import model.LottoManager;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoManager lottoManager = new LottoManager();
        lottoManager.purchaseLotto();
        lottoManager.drawWinningNumbers();
        lottoManager.checkWinningResult();
        lottoManager.displayWinningResult();
        lottoManager.displayReturnRate();
    }
}
