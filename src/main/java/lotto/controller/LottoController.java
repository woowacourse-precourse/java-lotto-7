package lotto.controller;

import java.util.List;
import lotto.util.LottoValidator;
import lotto.util.MoneyValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();

    private String getPurchaseAmount(){
        try{
            String input = inputView.enterPurchaseAmount();
            MoneyValidator.validate(input);
            return input;
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return getPurchaseAmount();
        }
    }

    private String getWinningNumbers(){
        try{
            String input = inputView.enterWinningNumbers();
            LottoValidator.validateNumbers(input);
            return input;
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return getWinningNumbers();
        }
    }

    private String getBonusNumber(List<Integer> winningNumbers){
        try{
            String input = inputView.enterBonusNumber();
            LottoValidator.validateBonusNumber(input,winningNumbers);
            return input;
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return getBonusNumber(winningNumbers);
        }
    }
}
