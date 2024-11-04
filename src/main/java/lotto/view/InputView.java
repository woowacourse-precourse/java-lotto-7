package lotto.view;

import static lotto.domain.Lotto.LOTTO_NUMBER_COUNT;
import static lotto.message.ExceptionMessage.DUPLICATED_NUMBER;
import static lotto.message.ExceptionMessage.DUPLICATED_WITH_WINNING_NUMBERS;
import static lotto.message.ExceptionMessage.INVALID_LOTTO_NUMBER_COUNT;
import static lotto.message.ExceptionMessage.NOT_NUMBER_FORMAT;
import static lotto.message.ExceptionMessage.OUT_OF_RANGE_LOTTO_NUMBER;
import static lotto.message.ViewMessage.INPUT_BONUS_NUMBER;
import static lotto.message.ViewMessage.INPUT_PURCHASE_AMOUNT;
import static lotto.message.ViewMessage.INPUT_WINNING_NUMBERS;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;

public class InputView {
    public static final String LOTTO_NUMBER_SEPARATOR = ",";
    public static int readInputMoney() {
        System.out.println(INPUT_PURCHASE_AMOUNT.getMessage());
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            System.out.println(NOT_NUMBER_FORMAT.getMessage());
            return readInputMoney();
        }
    }

    public static List<Integer> readNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS.getMessage());
        List<Integer> numbers = new ArrayList<>();
        try {
            for (String splitString : splitInputStirngByComma(Console.readLine())) {
                int number = Integer.parseInt(splitString.trim());
                validateOutOfLottoNumberRange(number);
                checkAlreadyExistNumber(numbers, number);
                numbers.add(number);
            }
            validateExactlySixNumber(numbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readNumbers();
        }
        return Collections.unmodifiableList(numbers);
    }

    public static int readBonusNumber(Lotto lotto) {
        System.out.println(INPUT_BONUS_NUMBER.getMessage());
        int bonusNumber;
        try {
            bonusNumber = Integer.parseInt(Console.readLine());
            checKDuplicatedWithWinningNumber(lotto, bonusNumber);
            validateOutOfLottoNumberRange(bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBonusNumber(lotto);
        }
        return bonusNumber;
    }

    private static List<String> splitInputStirngByComma(String input) {
        return Arrays.asList(input.split(LOTTO_NUMBER_SEPARATOR));
    }
    private static void validateExactlySixNumber(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_COUNT.getMessage());
        }
    }

    private static void checkAlreadyExistNumber(List<Integer> numbers, int number) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER.getMessage());
        }
    }

    private static void validateOutOfLottoNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(OUT_OF_RANGE_LOTTO_NUMBER.getMessage());
        }
    }
    private static void checKDuplicatedWithWinningNumber(Lotto lotto, int bonusNumber) {
        if (lotto.isContain(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATED_WITH_WINNING_NUMBERS.getMessage());
        }
    }
}
