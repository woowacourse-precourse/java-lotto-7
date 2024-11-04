package lotto.IO;

import camp.nextstep.edu.missionutils.Console;
import lotto.Validator;
import lotto.constants.ErrorMessage;
import lotto.constants.SystemMessage;

import java.util.Arrays;
import java.util.List;

public abstract class InputHandler {

    public static int getPrice() {
        String input = Console.readLine();
        Validator.validateInput(input);
        Validator.validateLottoPrice(input);
        return convertToInt(input);
    }

    public static List<Integer> getWinningLottoNumber() {
        System.out.println(SystemMessage.INPUT_WINNING_NUMBER.getMessage());
        String input = Console.readLine();
        List<Integer> winningNumber = Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .toList();
        Validator.validateInput(winningNumber);
        return winningNumber;
    }

    public static int getBonusNumber(List<Integer> winningNumber) {
        System.out.println(SystemMessage.INPUT_BONUS_NUMBER.getMessage());
        String input = Console.readLine();
        Validator.validateInput(input);
        return Validator.checkBonusNumberDuplication(convertToInt(input), winningNumber);
    }

    public static int convertToInt(String input) {
        return Integer.parseInt(input);
    }
}
