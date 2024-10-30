package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.InputConverter;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.ui.InputView;

public class LottoController {
    private InputConverter convertValidValue;
    private LottoGenerator lottoGenerator;
    private List<Lotto> lottos;
    private int ticketCount;

    public LottoController(){
        convertValidValue = new InputConverter();
        lottoGenerator = new LottoGenerator();
        lottos = new ArrayList<Lotto>();
        ticketCount = 0;
    }

    public void run(){
        lottoAmount();
    }

    private void lottoAmount() {
        String purchaseAmount = InputView.purchase();
        int ticket = 0;

        try {
            ticket = convertValidValue.purchaseAmount(purchaseAmount);
        }catch (IllegalArgumentException e){
            System.out.println(e.toString());
            lottoAmount();
        }

        ticketCount = ticket;
    }

    private void purchaseLotto() {
        for(int i = 0; i< ticketCount; i++){
            lottos.add(lottoGenerator.generate());
        }
    }
}
