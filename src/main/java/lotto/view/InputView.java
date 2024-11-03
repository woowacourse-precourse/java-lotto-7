package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.SplitNumbers;
import java.util.List;

public class InputView {
    public String inputAmount(){
        return Console.readLine();
    }
    public List<Integer> inputWinningNumbers() {
        String inputWinningNumbers = Console.readLine();
        return SplitNumbers.splitWinningNumbers(inputWinningNumbers);
    }
    public String inputBonusNumber(){
        return Console.readLine();
    }
}
