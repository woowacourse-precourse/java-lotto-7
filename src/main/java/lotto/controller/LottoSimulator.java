package lotto.controller;

import lotto.model.LottoCollection;
import lotto.model.LottoDispenser;
import lotto.model.LottoHolder;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoSimulator {
    
    private LottoDispenser lottoDispenser = new LottoDispenser();
    private LottoHolder lottoHolder;

    
    public LottoSimulator() {
    }
    
    public void startSimulation() {
        purchaseLottoTickets();
        showPurchasedLottos();
        verifyLottoWins();
        showLottoResults();
    }
    
    private void purchaseLottoTickets() {
        String inputMoney = InputView.receiveLottoPayment();
        LottoCollection lottoCollection = lottoDispenser.executeTransactionAndDispense(inputMoney);
        lottoHolder = new LottoHolder(lottoCollection);
    }
    
    private void showPurchasedLottos() {
        OutputView.printPurchasedLottos(lottoHolder.getLottos());
    }
    
    private void verifyLottoWins() {
        
    }
    
    private void showLottoResults() {
        
    }
}
