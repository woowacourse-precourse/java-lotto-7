package lotto;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoPurchase lottoPurchase = new LottoPurchase();
        lottoPurchase.purchase();
        lottoPurchase.printPurchaseLottoList();

        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers();
        lottoWinningNumbers.inputWinningNumbers();
        lottoWinningNumbers.inputBonusNumber();

        ArrayList<Lotto> purchaseList = lottoPurchase.purchaseLottoList;

        List<Integer> winnerNumbers = lottoWinningNumbers.getWinningNumbers();
        int bonusNumber = lottoWinningNumbers.getBonusNumber();

        LottoResult lottoResult = new LottoResult(purchaseList, winnerNumbers, bonusNumber);
        lottoResult.checkLottoResult();
    }
}
