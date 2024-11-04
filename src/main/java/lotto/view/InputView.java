package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.SplittingWinningNumbers;

public class InputView {
    public String inputMoney(){
        return Console.readLine();
    }

    public String[] inputWinningNumbers(){
        String winningNumbers = Console.readLine();
        return SplittingWinningNumbers.splitWinningNumbers(winningNumbers);
    }
}
