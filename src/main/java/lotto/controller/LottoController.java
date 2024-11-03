package lotto.controller;

import java.util.List;
import lotto.domain.InputConverter;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.PurchasedLotto;
import lotto.domain.WinningNumber;
import lotto.ui.InputView;
import lotto.ui.OutputView;

public class LottoController {
    private InputConverter convertValidValue;
    private LottoGenerator lottoGenerator;
    private PurchasedLotto purchasedLotto;
    private int ticketCount;
    private WinningNumber winningNumber;

    public LottoController(InputConverter inputConverter, LottoGenerator lottoGenerator, PurchasedLotto purchasedLotto) {
        convertValidValue = inputConverter;
        this.lottoGenerator = lottoGenerator;
        this.purchasedLotto = purchasedLotto;
        ticketCount = 0;
    }

    public void run(){
        lottoAmount();
        purchaseLotto();
        getWinningNumber();
        showSummary();
    }

    private void lottoAmount() {
        String purchaseAmount = InputView.purchase();
        int ticket = 0;

        try {
            ticket = convertValidValue.purchaseAmount(purchaseAmount);
            ticketCount = ticket;
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            lottoAmount();
        }
    }

    private void purchaseLotto() {
        for(int i = 0; i< ticketCount; i++){
            purchasedLotto.addLotto(lottoGenerator.generate());
        }
        OutputView.showPurchasedNumbers(purchasedLotto.getLottos());
    }

    private Lotto getWinningLotto(){
        String userInput = InputView.winningNumber();
        Lotto lotto = null;

        try{
            List<Integer> li = convertValidValue.winningNumbers(userInput);
            lotto = new Lotto(li);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
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
            System.out.println(e.getMessage());
            return getBonusNumber();
        }

        return bonusNumber;
    }

    private void getWinningNumber(){
        Lotto winningLotto = getWinningLotto();
        int bonusNumber = getBonusNumber();

        try{
            winningNumber = new WinningNumber(winningLotto, bonusNumber);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            getWinningNumber();
        }
    }

    private void showSummary(){
        purchasedLotto.matchLotto(winningNumber);

        OutputView.summaryWinning(purchasedLotto.getPrizes(), purchasedLotto.getRateOfReturn());
    }
}
