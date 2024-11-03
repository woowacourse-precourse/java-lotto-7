package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import lotto.io.request.LottoRequest;
import lotto.io.request.NumberRequest;

public class InputHandler {

    public NumberRequest getBudgets() {
        String budgets = Console.readLine();
        return new NumberRequest(budgets);
    }

    public LottoRequest getWinningNumbers() {
        String winningNumbers = Console.readLine();
        return new LottoRequest(winningNumbers);
    }

    public NumberRequest getBonusNumber() {
        String bonusNumber = Console.readLine();
        return new NumberRequest(bonusNumber);
    }
}
