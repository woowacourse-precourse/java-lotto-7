package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.util.Validator;

public class InputView {
    public static List<Integer> convertToList(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public String getPurchaseAmount() {
        return Console.readLine();
    }

    public List<Integer> getWinningNumbers() {
        String winningNumbers = Console.readLine();
        Validator.validateCommaSeparated(winningNumbers);
        return convertToList(winningNumbers);
    }

    public int getBonusNumber() {
        String bonusNumber = Console.readLine();
        Validator.validateBonusNumber(bonusNumber);
        return Integer.parseInt(bonusNumber);
    }
}
