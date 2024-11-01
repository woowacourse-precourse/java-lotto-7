package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;
import lotto.Messages.ErrorMessage;
import lotto.Messages.StateMessage;
import lotto.WinningDetails;

import java.util.Arrays;
import java.util.stream.Collectors;

import static lotto.View.InputView.*;

public class Controller {

    private Integer lottoCount;

    public Integer gainPurchaseAmount(){
        Integer purchasePrice = 0;
        try {
            OutputView.printPurchaseAmount();
            purchasePrice = InputView.readPurchaseAmount();
            OutputView.printBlank();
            this.lottoCount = this.countLotto(purchasePrice);
        }
        catch(IllegalArgumentException e){
            OutputView.printError(ErrorMessage.ONLY_NUMBER.getError());
            return gainPurchaseAmount();
        }
        return purchasePrice;
    }

    public Integer countLotto(Integer input){
        Integer lottoCount = input/1000;
        if (input % 1000 != 0) {
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

    public Integer gainBonusInput(Lotto answer){
        OutputView.printBonus();
        Integer bonus = 0;
        try{
            String rawBonus  = InputView.readBonus(answer);
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
