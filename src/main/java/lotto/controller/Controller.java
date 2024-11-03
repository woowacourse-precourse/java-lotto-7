package lotto.controller;

import lotto.service.*;
import lotto.view.PrintResult;
import lotto.view.UserInput;

public class Controller {

    private UserInput userInput = new UserInput();
    private CreateNumbers createNumbers = new CreateNumbers();
    private LottoLogic lottoLogic = new LottoLogic();
    private PrintResult printResult = new PrintResult(createNumbers);

    public void start() {
        Money money = userInput.inputMoney();

        createNumbers.numbersList(money.getNumber());

        printResult.printMyLotto(money.getNumber());

        userInput.inputWinningNumbers();
        Bonus bonus = userInput.inputBonusNumber();

        Lotto lotto = new Lotto(userInput.getWinningNumbers());
        printResult.result(lottoLogic.winning(createNumbers.getNumbers(), bonus.getBonusNumber(), lotto.getNumbers()), money.getNumber());
    }
}
