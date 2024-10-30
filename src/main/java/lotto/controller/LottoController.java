package lotto.controller;

import java.lang.ModuleLayer.Controller;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.ConvertValidValue;
import lotto.domain.Lotto;
import lotto.ui.InputView;

public class LottoController {
    private ConvertValidValue convertValidValue;
    private List<Lotto> lottos;
    private int ticketCount;

    public LottoController(){
        lottos = new ArrayList<Lotto>();
        convertValidValue = new ConvertValidValue();
        ticketCount = 0;
    }

    public void run(){
        purchaseLotto();
    }

    private void purchaseLotto() {
        String purchaseAmount = InputView.purchase();
        int ticket = 0;

        try {
            ticket = convertValidValue.purchaseAmount(purchaseAmount);
        }catch (IllegalArgumentException e){
            System.out.println(e.toString());
            purchaseLotto();
        }

        ticketCount = ticket;
    }

    
}
