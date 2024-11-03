package lotto.game;

import lotto.Lottos;
import lotto.Prize;
import lotto.number.LottoNumber;
import lotto.purchase.Purchase;
import lotto.purchase.PurchaseNumber;
import lotto.statistics.Statistics;
import lotto.strategy.LottoNumberStrategyImpl;
import lotto.winner.WinnerLottoNumber;

import java.util.Map;

import static lotto.view.InputView.*;
import static lotto.view.ResultView.*;

public class LottoGame {

    public static void gamePlay() {
        Purchase purchase = null;
        purchase = getLottoPurchase(purchase);

        WinnerLottoNumber winnerLottoNumber = null;
        winnerLottoNumber = getWinnerLottoNumber(winnerLottoNumber);

        LottoNumber bonusLottoNumber = null;
        bonusLottoNumber = getLottoBonusNumber(bonusLottoNumber);
        purchase.getLottos().hitLottoNumbers(winnerLottoNumber, bonusLottoNumber);

        Map<Prize, Integer> prizes = purchase.getLottos().getPrizes();
        hitLottoNumberResultView(prizes);

        Statistics statistics = new Statistics();
        double rate = statistics.rateOfReturn(prizes, purchase.getLottos().getLottos().size());
        ratioResultView(rate);
    }

    private static LottoNumber getLottoBonusNumber(LottoNumber bonusLottoNumber) {
        while(bonusLottoNumber == null) {
            try{
                bonusLottoNumber = new LottoNumber(bonusLottoNumberQuestion());
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
        return bonusLottoNumber;
    }

    private static WinnerLottoNumber getWinnerLottoNumber(WinnerLottoNumber winnerLottoNumber) {
        while(winnerLottoNumber == null) {
            try{
                winnerLottoNumber = WinnerLottoNumber.createOfWinnerLottoNumber(winnerLottoNumberQuestion());
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
        return winnerLottoNumber;
    }

    private static Purchase getLottoPurchase(Purchase purchase) {
        while(purchase == null) {
            try{
                purchase = new Purchase(new PurchaseNumber(purchaseQuestion()), new Lottos());
                purchase.purchaseLottos(new LottoNumberStrategyImpl());
                purchaseLottoResultView(purchase.getLottos().getLottos());
            } catch(IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
        return purchase;
    }


}
