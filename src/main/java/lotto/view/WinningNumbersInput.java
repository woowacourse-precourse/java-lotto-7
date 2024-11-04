package lotto.view;

import static lotto.common.config.InstructionMessages.INPUT_WINNING_NUMBERS;
import static lotto.common.exception.ExceptionMessages.INVALID_WINNING_NUMBER_FORMAT;
import static lotto.common.exception.ExceptionMessages.NONE_NUMERIC_INPUT;
import static lotto.common.exception.ExceptionMessages.WINNING_NUMBERS_CONTAINS_WHITESPACE;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.common.exception.EmptyInputException;
import lotto.common.exception.InvalidInputException;
import lotto.domain.Lotto;

public class WinningNumbersInput implements Input<Lotto, String[]> {
    private InputValidator inputValidator = new InputValidator(); // TODO

    @Override
    public Lotto input() {
        Output.printMessage(INPUT_WINNING_NUMBERS.getMessage());
        while (true) {
            try {
                String[] winningNumbersInput = splitWinningNumbers(readInput());
                validate(winningNumbersInput);
                return new Lotto(convertToIntegerList(winningNumbersInput));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public void validate(String[] input) {
        for (String oneNumber : input) {
            if (inputValidator.isEmptyInput(oneNumber)) {
                throw new EmptyInputException(INVALID_WINNING_NUMBER_FORMAT.getMessage());
            }
            if (inputValidator.containsWhiteSpace(oneNumber)) {
                throw new InvalidInputException(WINNING_NUMBERS_CONTAINS_WHITESPACE.getMessage());
            }
            if (!inputValidator.isNumeric(oneNumber)) {
                throw new InvalidInputException(NONE_NUMERIC_INPUT.getMessage());
            }
        }
    }

    private String[] splitWinningNumbers(String input) {
        return input.split(",", -1);
    }

    private List<Integer> convertToIntegerList(String[] input) {
        return Arrays.stream(input)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
