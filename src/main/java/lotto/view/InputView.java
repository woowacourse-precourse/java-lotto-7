package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.AmountValidate;
import lotto.util.BonusNumberValidate;
import lotto.util.WinningNumberValidate;

import java.util.Arrays;
import java.util.List;

public class InputView extends View {

    private final String SPLIT_DELIMITER = ",";

    public int getAmount() {
        System.out.println(AMOUNT_PROMPT);
        String amount = Console.readLine().trim();
        AmountValidate.validate(amount);
        return stringToInt(amount);
    }

    public List<Integer> getWinningNumber() {
        br();
        System.out.println(WINNING_NUMBER_PROMPT);
        String winningNumber = Console.readLine();
        WinningNumberValidate.validate(winningNumber);
        return stringToList(winningNumber);
    }

    public int getBonusNumber(List<Integer> winningNumber) {
        br();
        System.out.println(BONUS_NUMBER_PROMPT);
        String bonusNumber = Console.readLine().trim();
        BonusNumberValidate.validate(bonusNumber, winningNumber);
        return stringToInt(bonusNumber);
    }

    private int stringToInt(String string) {
        return Integer.parseInt(string);
    }

    private List<Integer> stringToList(String winningNumber) {
        return Arrays.stream(winningNumber.split(SPLIT_DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }

}
