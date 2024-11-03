package lotto;

import java.util.EnumMap;
import java.util.List;

public class Application {
    static final int LOTTO_PRICE = 1000;

    public static void main(String[] args) {
        LottoPrice lottoPrice = new LottoPrice();
        LottoGenerator lottoGenerator = new LottoGenerator();
        LottoWinningManager lottoWinningManager = new LottoWinningManager();
       
        final int totalLottoPrice = lottoPrice.getLottoPrice();
        final int numberOfLotto = totalLottoPrice / LOTTO_PRICE;

        lottoGenerator.pickSortedLotto(numberOfLotto);
        final List<Lotto> purchasedLotto = lottoGenerator.getpurchasedLotto();
        lottoGenerator.printPurchasedLotto(numberOfLotto);
        
        final Lotto winningLotto = lottoWinningManager.getWinningLotto();
        System.out.println("");
        final int bonusNumber = lottoWinningManager.getBonusNumber(winningLotto);

        EnumMap<MatchCount, Integer> winningResult = lottoWinningManager.WinningResult(purchasedLotto, winningLotto, bonusNumber);
        lottoWinningManager.showWinningResult(winningResult);
        lottoWinningManager.showTotalYield(totalLottoPrice, winningResult);
        
    }
}
