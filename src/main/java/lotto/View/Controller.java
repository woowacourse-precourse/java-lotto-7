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
    public static final String DELIMITER = ",";

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
        String rawWinningInput = Console.readLine();
        OutputView.printBlank();
        Lotto answer;
        try {
            answer = new Lotto(Arrays.asList(rawWinningInput.split(DELIMITER)).stream()
                    .map(InputView::parseInt)
                    .collect(Collectors.toList()));
        }
        catch (IllegalArgumentException e){
            OutputView.printError(ErrorMessage.WIN_INPUT.getError());
            return getWinningInput();
        }
        return answer;
    }

    public Integer gainBonusInput(Lotto answer){
        OutputView.printBonus();
        String rawBonus  = Console.readLine();
        OutputView.printBlank();
        Integer bonus = 0;
        try{
            bonus = parseInt(rawBonus);
            checkBonus(bonus, answer);
            checkRange(bonus);
        }
        catch (IllegalArgumentException e){
            OutputView.printError(ErrorMessage.BONUS.getError());
            return gainBonusInput(answer);
        }
        return bonus;
    }

    public Integer getLottoCount(){
        return this.lottoCount;
    }
}
