package lotto.controller;

import java.awt.Window;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.InputConverter;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.WinningNumber;
import lotto.ui.InputView;

public class LottoController {
    private InputConverter convertValidValue;
    private LottoGenerator lottoGenerator;
    private List<Lotto> lottos;
    private int ticketCount;
    private WinningNumber winningNumber;

    public LottoController(){
        convertValidValue = new InputConverter();
        lottoGenerator = new LottoGenerator();
        lottos = new ArrayList<Lotto>();
        ticketCount = 0;
    }

    public void run(){
        lottoAmount();
        purchaseLotto();
        winningNumber = new WinningNumber(getWinningLotto(), getBonusNumber());

    }

    private void lottoAmount() {
        String purchaseAmount = InputView.purchase();
        int ticket = 0;

        try {
            ticket = convertValidValue.purchaseAmount(purchaseAmount);
            ticketCount = ticket;
        }catch (IllegalArgumentException e){
            System.out.println(e.toString());
            lottoAmount();
        }
    }

    private void purchaseLotto() {
        for(int i = 0; i< ticketCount; i++){
            lottos.add(lottoGenerator.generate());
        }
    }

    private Lotto getWinningLotto(){
        String userInput = InputView.winningNumber();
        Lotto lotto = null;

        try{
            List<Integer> li = convertValidValue.winningNumbers(userInput);
            lotto = new Lotto(li);
        }catch (IllegalArgumentException e){
            System.out.println(e.toString());
            return getWinningLotto();
        }

        return lotto;
    }

    private int getBonusNumber(){
        String UserInput = InputView.bonusNumber();
        int bonusNumber = 0;

        try {
            bonusNumber = convertValidValue.bonusNumber(UserInput);
        }catch (IllegalArgumentException e){
            System.out.println(e.toString());
            return getBonusNumber();
        }

        return bonusNumber;
    }
}
