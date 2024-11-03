package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.BonusNumberValidate;
import lotto.util.PriceValidate;
import lotto.util.WinningNumberValidate;

import java.util.Arrays;
import java.util.List;

public class InputView extends View {

    private final String SPLIT_DELIMITER = ",";

    public int getPrice() {
        System.out.println(PRICE_PROMPT);
        String price = Console.readLine().trim();
        PriceValidate.validate(price);
        return stringToInt(price);
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
