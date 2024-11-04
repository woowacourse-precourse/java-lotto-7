package lotto.view;

import static lotto.domain.Lotto.*;
import static lotto.message.ExceptionMessage.DUPLICATED_NUMBER;
import static lotto.message.ExceptionMessage.DUPLICATED_WITH_WINNING_NUMBERS;
import static lotto.message.ExceptionMessage.INVALID_LOTTO_NUMBER_COUNT;
import static lotto.message.ExceptionMessage.OUT_OF_RANGE_LOTTO_NUMBER;
import static lotto.message.ExceptionMessage.NOT_NUMBER_FORMAT;
import static lotto.message.ViewMessage.INPUT_BONUS_NUMBER;
import static lotto.message.ViewMessage.INPUT_PURCHASE_AMOUNT;
import static lotto.message.ViewMessage.INPUT_WINNING_NUMBERS;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
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

    public static List<Integer> readAndSplitNumber() {
        System.out.println(INPUT_WINNING_NUMBERS.getMessage());
        List<Integer> numbers = new ArrayList<>();

        for (String splitString : Console.readLine().split(LOTTO_NUMBER_SEPARATOR)) {
            try {
                int number = Integer.parseInt(splitString.trim());

                if (number < 1 && number > 45) {
                    throw new IllegalArgumentException(OUT_OF_RANGE_LOTTO_NUMBER.getMessage());
                }

                if (numbers.contains(number)) {
                    throw new IllegalArgumentException(DUPLICATED_NUMBER.getMessage());
                }
                numbers.add(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(NOT_NUMBER_FORMAT.getMessage());
            }
        }

        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_COUNT.getMessage());
        }

        return Collections.unmodifiableList(numbers);
    }

    public static int readBonusNumber(Lotto LottoNumbers) {
        System.out.println(INPUT_BONUS_NUMBER.getMessage());
        int bonusNumber;
        try {
            bonusNumber = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_FORMAT.getMessage());
        }

        if (LottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATED_WITH_WINNING_NUMBERS.getMessage());
        }
        if (bonusNumber < 1 && bonusNumber > 45) {
            throw new IllegalArgumentException(OUT_OF_RANGE_LOTTO_NUMBER.getMessage());
        }
        return bonusNumber;
    }
}
