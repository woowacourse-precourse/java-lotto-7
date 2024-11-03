package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;
import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private static List<Integer> winningNumbers;

    public LottoController(){
        inputView = new InputView();
        outputView = new OutputView();
    }
    public void run(){
        int quantity = purchaseLotto();
        MyLotto myLotto = new MyLotto(quantity);
        buyingLotto(quantity, myLotto);
        Lotto lotto = inputWinningNumbers();
        BonusNumber bonusNumber = inputBonusNumber();
        LottoRanking lottoRanking = new LottoRanking(myLotto, lotto, bonusNumber);
        LottoStatistic lottoStatistic = new LottoStatistic(lottoRanking, quantity);
        gameResult(lottoRanking, lottoStatistic);
    }
    private int purchaseLotto(){
        while(true){
            try{
                outputView.printPurchaseAmount();
                String amount = inputView.inputAmount();
                PurchaseAmount purchaseAmount = new PurchaseAmount(amount);
                return purchaseAmount.getQuantity();
            }
            catch (IllegalArgumentException e){
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
    private void buyingLotto(int quantity, MyLotto myLotto){
        outputView.printPurchaseQuantity(quantity, myLotto.getMyLottos());
    }
    private Lotto inputWinningNumbers(){
        while(true){
            try {
                outputView.printInputWinningNumbers();
                winningNumbers = inputView.inputWinningNumbers();
                return new Lotto(winningNumbers);
            }catch (IllegalArgumentException e){
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
    private BonusNumber inputBonusNumber(){
        while(true){
            try{
                outputView.printInputBonusNumber();
                String bonus = inputView.inputBonusNumber();
                return new BonusNumber(bonus, winningNumbers);
            }catch (IllegalArgumentException e){
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
    private void gameResult(LottoRanking lottoRanking,LottoStatistic lottoStatistic){
        outputView.printResultStatistics(lottoRanking.getLottoRanking());
        outputView.printTotalReturn(lottoStatistic.getLottoStatistics());
    }
}
