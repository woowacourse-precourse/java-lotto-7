package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.Money;
import lotto.service.LottoBonusDuplicateCheckerService;
import lotto.util.Parser;
import lotto.view.InputView;
import lotto.view.OutputView;

public class InputHandler {
    public static int getMoneyUntilValid(String inputMoney) {
        try{
            Money money = new Money(Parser.stringToInt(inputMoney));
            return money.getUserInputMoney();
        }catch (IllegalArgumentException e){
            OutputView.printErrorMessage(e);
            OutputView.printInputAgainPrompt();
            return getMoneyUntilValid(Console.readLine());
        }
    }

    public static Lotto generateLotto() {
        InputView.printRequestLotto();
        return getLottoUntilValid(InputView.makeArrayToList(InputView.getUserInputSplitByComma()));
    }

    public static Lotto getLottoUntilValid(List<Integer> numbers) {
        try {
            return new Lotto(numbers);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            OutputView.printInputAgainPrompt();
            return generateLotto();
        }
    }

    public static BonusNumber generateBonusNumber(Lotto lotto){
        InputView.printRequestBonusNumber();
        return getBosNumberUntilValid(lotto, InputView.getUserInput());
    }

    public static BonusNumber getBosNumberUntilValid(Lotto lotto, String bonusNumberInput) {
        try {
            BonusNumber bonusNumber = new BonusNumber(Parser.stringToInt(bonusNumberInput));
            LottoBonusDuplicateCheckerService.checkForDuplicates(lotto, Integer.parseInt(bonusNumberInput));
            return bonusNumber;
        }catch (IllegalArgumentException e){
            OutputView.printErrorMessage(e);
            OutputView.printInputAgainPrompt();
            return generateBonusNumber(lotto);
        }
    }

}
