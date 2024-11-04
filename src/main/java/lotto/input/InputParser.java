package lotto.input;

import lotto.validation.Validation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputParser {
    public List<Integer> splitWinningNumbers(String winningNumber) {
        List<Integer> winningNumbers = Arrays.stream(winningNumber.split(","))
                .map(Integer::parseInt)
                .toList();
        Validation.validatedWinnigNumbers(winningNumbers);


        return winningNumbers;
    }
}
