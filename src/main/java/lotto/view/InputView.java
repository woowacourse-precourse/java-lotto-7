package lotto.view;

import static lotto.message.ExceptionMessage.*;
import static lotto.message.ExceptionMessage.NOT_NUMBER_FORMAT;
import static lotto.message.ViewMessage.INPUT_BONUS_NUMBER;
import static lotto.message.ViewMessage.INPUT_PURCHASE_AMOUNT;
import static lotto.message.ViewMessage.INPUT_WINNING_NUMBERS;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lotto.Util.Validator;
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
            for (String splitString : splitBySeparator(Console.readLine(), LOTTO_NUMBER_SEPARATOR)) {
                int number = Integer.parseInt(splitString.trim());
                Validator.validateOutOfLottoNumberRange(number);
                Validator.validateExistNumber(numbers, number);
                numbers.add(number);
            }
            Validator.validateExactlySixNumber(numbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readNumbers();
        }
        return Collections.unmodifiableList(numbers);
    }

    public static int readBonusNumber(Lotto lotto) {
        System.out.println();
        System.out.println(INPUT_BONUS_NUMBER.getMessage());
        int bonusNumber;
        try {
            bonusNumber = Integer.parseInt(Console.readLine());
            Validator.validateDuplicatedBonusNumber(lotto, bonusNumber);
            Validator.validateOutOfLottoNumberRange(bonusNumber);
        } catch (NumberFormatException e) {
            System.out.println(INPUT_NOTHING.getMessage());
            return readBonusNumber(lotto);
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBonusNumber(lotto);
        }
        return bonusNumber;
    }

    private static List<String> splitBySeparator(String input, String separator) {
        Validator.validateInputString(input);
        return Arrays.asList(input.split(separator));
    }

}
