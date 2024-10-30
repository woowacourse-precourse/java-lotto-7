package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public abstract class InputHandler {

    public static List<Integer> getLottoWinningNumber(String input) {
        List<Integer> winningNumber = Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .toList();
        Validator.validateInput(winningNumber);
        return winningNumber;
    }
    public static int getBonusNumber(String input,List<Integer> winningNumber) {
        Validator.validateInput(input,winningNumber);
        return Integer.parseInt(Console.readLine());
    }
}
