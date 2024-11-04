package lotto.io.reader;

import camp.nextstep.edu.missionutils.Console;

import lotto.exception.InputException;
import lotto.io.printer.DefaultPrinter;
import lotto.util.validator.InputValidator;

import java.util.List;
import java.util.Arrays;


public final class LottoNumberReader {

    private static final String MESSAGE_FOR_REQUEST_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String MESSAGE_FOR_REQUEST_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String AVAILABLE_SEPARATOR = ",";


    private LottoNumberReader() {
    }

    public static List<Integer> readWinningNumbers() {
        String input;
        do {
            DefaultPrinter.printLine(MESSAGE_FOR_REQUEST_WINNING_NUMBERS);
            input = Console.readLine();
        } while (!isAvailableNumbers(input));

        return Arrays.stream(input.split(AVAILABLE_SEPARATOR))
                .map(Integer::parseInt)
                .toList();
    }

    public static Integer readBonusNumber() {
        String input;
        do {
            DefaultPrinter.printLine(MESSAGE_FOR_REQUEST_BONUS_NUMBER);
            input = Console.readLine();
        } while (!isAvailableNumber(input));

        return Integer.parseInt(input);
    }

    private static boolean isAvailableNumber(String numberInput) {
        try {
            InputValidator.validateLottoNumberInput(numberInput);
            return true;
        } catch (InputException exception) {
            DefaultPrinter.printLine(exception.getMessage());
            return false;
        }
    }

    private static boolean isAvailableNumbers(String numbersInput) {
        for (String numberInput : numbersInput.split(AVAILABLE_SEPARATOR)) {
            if (!isAvailableNumber(numberInput)) {
                return false;
            }
        }
        return true;
    }

}
