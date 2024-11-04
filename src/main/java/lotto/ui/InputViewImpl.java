package lotto.ui;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.constants.InputMessage.*;

public class InputViewImpl implements InputView {

    @Override
    public String userInput() {
        System.out.print(PURCHASE_AMOUNT_PROMPT);
        return Console.readLine();
    }

    @Override
    public List<Integer> lottoWinningNumbers() {
        return convertStringsToIntegers(splitNumbers(winningNumbersInput()));
    }

    @Override
    public String bonusNumber() {
        System.out.println(BONUS_NUMBER_PROMPT);
        return Console.readLine();
    }

    private String winningNumbersInput() {
        System.out.println(WINNING_NUMBERS_PROMPT);
        return Console.readLine();
    }

    private String[] splitNumbers(String input) {
        return input.split(DELIMITER);
    }

    private List<Integer> convertStringsToIntegers(String[] numberStrings) {
        return Arrays.stream(numberStrings)
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
