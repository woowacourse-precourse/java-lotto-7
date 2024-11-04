package lotto;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int buyingPrice = InputHandler.getBuyingPrice();
        MyLottos myLottos = new MyLottos(buyingPrice);

        Lotto winningNumber = InputHandler.getWinningNumber();

        int bonusNumber = InputHandler.getBonusNumber(winningNumber);

        LottoChecker lottoChecker = new LottoChecker(winningNumber.getNumbers(), bonusNumber);
        for (Lotto lotto : myLottos.getMyLottos()) {
            lottoChecker.recordLottoRank(lotto);
        }
        lottoChecker.printRankResult();
        System.out.printf("총 수익률은 %.1f%%입니다.\n", 1.0 * lottoChecker.getTotalPrize() / buyingPrice * 100);
    }
}
