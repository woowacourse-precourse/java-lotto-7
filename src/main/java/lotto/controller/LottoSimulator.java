package lotto.controller;

import lotto.model.LottoDispenser;
import lotto.model.LottoHolder;
import lotto.view.InputView;

public class LottoSimulator {
    
    LottoDispenser lottoDispenser = new LottoDispenser();
    LottoHolder lottoHolder = new LottoHolder();
    
    public LottoSimulator() {
    }
    
    public void startSimulation() {
        purchaseLottoTickets();
        verifyLottoWins();
        showLottoResults();
    }
    
    private void purchaseLottoTickets() {
        String inputMoney = InputView.receiveLottoPayment();
        System.out.println(inputMoney);
    }
    
    private void verifyLottoWins() {
        
    }
    
    private void showLottoResults() {
        
    }
}
