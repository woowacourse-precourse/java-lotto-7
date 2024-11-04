package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.AmountValidate;
import lotto.util.BonusNumberValidate;
import lotto.util.WinningNumberValidate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class InputView extends View {

    private final String SPLIT_DELIMITER = ",";

    public int getAmount() {
        return doLoop(AMOUNT_PROMPT, AmountValidate::validate, this::stringToInt);
    }

    public List<Integer> getWinningNumber() {
        br();
        return doLoop(WINNING_NUMBER_PROMPT, WinningNumberValidate::validate, this::stringToList);
    }

    public int getBonusNumber(List<Integer> winningNumber) {
        br();
        return doLoop(BONUS_NUMBER_PROMPT,
                input -> BonusNumberValidate.validate(input, winningNumber),
                this::stringToInt);
    }

    private <T> T doLoop(String prompt, Consumer<String> validator, Function<String, T> converter) {
        System.out.println(prompt);
        String input = Console.readLine().trim();
        try {
            validator.accept(input);
            return converter.apply(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return doLoop(prompt, validator, converter);
        }
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
