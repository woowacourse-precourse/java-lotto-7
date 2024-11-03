package lotto.controller;

import lotto.model.LottoCollection;
import lotto.model.LottoDispenser;
import lotto.model.LottoHolder;
import lotto.view.InputView;

public class LottoSimulator {
    
    private LottoDispenser lottoDispenser = new LottoDispenser();
    private LottoHolder lottoHolder;

    
    public LottoSimulator() {
    }
    
    public void startSimulation() {
        purchaseLottoTickets();
        verifyLottoWins();
        showLottoResults();
    }
    
    private void purchaseLottoTickets() {
        String inputMoney = InputView.receiveLottoPayment();
        LottoCollection lottoCollection = lottoDispenser.executeTransactionAndDispense(inputMoney);
        lottoHolder = new LottoHolder(lottoCollection);
    }
    
    private void verifyLottoWins() {
        
    }
    
    private void showLottoResults() {
        
    }
}
