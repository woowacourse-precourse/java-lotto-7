package lotto;

import lotto.Messages.ErrorMessage;
import lotto.View.InputView;
import lotto.View.OutputView;

public class Controller {

    private Integer lottoCount;

    public int gainPurchaseAmount(){
        int purchasePrice = 0;
        try {
            OutputView.printPurchaseAmount();
            purchasePrice = InputView.readPurchaseAmount();
            this.lottoCount = this.countLotto(purchasePrice);
        }
        catch(IllegalArgumentException e){
            OutputView.printError(ErrorMessage.ONLY_NUMBER.getError());
            return gainPurchaseAmount();
        }
        OutputView.printBlank();
        return purchasePrice;
    }

    public int countLotto(Integer purchasePrice){
        int lottoCount = purchasePrice/1000;
        if (purchasePrice % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_DIV.getError());
        }
        OutputView.printCount(lottoCount);
        return lottoCount;
    }

    public Lotto getWinningInput(){
        OutputView.printWinning();
        Lotto answer;
        try {
            answer = InputView.readWinningNum();
        }
        catch (IllegalArgumentException e){
            OutputView.printError(ErrorMessage.WIN_INPUT.getError());
            return getWinningInput();
        }
        OutputView.printBlank();
        return answer;
    }

    public int gainBonusInput(Lotto answer){
        OutputView.printBonus();
        int bonus = 0;
        try{
            bonus  = InputView.readBonus(answer);
        }
        catch (IllegalArgumentException e){
            OutputView.printError(ErrorMessage.BONUS.getError());
            return gainBonusInput(answer);
        }
        OutputView.printBlank();
        return bonus;
    }

    public Integer getLottoCount(){
        return this.lottoCount;
    }
}
