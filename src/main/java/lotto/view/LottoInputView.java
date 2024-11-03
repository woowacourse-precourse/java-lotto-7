package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.LottoRule;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static lotto.domain.LottoRule.*;
import static lotto.config.message.LottoErrorMessage.*;
import static lotto.config.message.LottoInputMessage.*;

public class LottoInputView {

    public static final String WIN_NUMBER_DELIMITER = ",";


    public int getMoney() {
        while (true) {
            printInputMoney();
            try {
                int money = Integer.parseInt(Console.readLine());
                validateMoney(money);
                return money;
            } catch (NumberFormatException e) {
                System.out.println(INPUT_MONEY_ERROR.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void validateMoney(int money) {
        if (money % LOTTO_PRICE.getValue() != 0) {
            throw new IllegalArgumentException(INPUT_MONEY_DIVIDE_ERROR.getMessage());
        }
    }

    private void printInputMoney() {
        System.out.println(INPUT_MONEY.getMessage());
    }

    public List<Integer> getWinNumber() {
        while (true) {
            printWinNumber();
            try {
                List<Integer> winNumber = parseToIntegers(split(Console.readLine()));
                validateWinNumber(winNumber);
                return winNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateWinNumber(List<Integer> winNumber) {
        if (isNotRange(winNumber)) {
            throw new IllegalArgumentException(INPUT_WIN_NUMBER_RANGE_ERROR.getMessage());
        }

        if (isDuplicated(winNumber)) {
            throw new IllegalArgumentException(INPUT_WIN_NUMBER_DUPLICATE_ERROR.getMessage());
        }
    }

    private boolean isNotRange(List<Integer> winNumber) {
        return winNumber.stream()
                .anyMatch(number ->
                        number < LOTTO_MIN_NUMBER.getValue() ||
                        number > LOTTO_MAX_NUMBER.getValue()
                );
    }

    private boolean isDuplicated(List<Integer> winNumber) {
        return new HashSet<>(winNumber).size() != LottoRule.LOTTO_SIZE.getValue();
    }

    private void printWinNumber() {
        System.out.println(INPUT_WIN_NUMBER.getMessage());
    }

    private String[] split(String winNumber) {
        return winNumber.split(WIN_NUMBER_DELIMITER);
    }

    private List<Integer> parseToIntegers(String[] numbers) {
        try {
            return Arrays.stream(numbers)
                    .map(Integer::parseInt)
                    .toList();
        } catch (Exception e) {
            throw new IllegalArgumentException(INPUT_WIN_NUMBER_ERROR.getMessage());
        }
    }

    public int getBonusNumber(List<Integer> winNumber) {
        while (true) {
            printBonusNumber();
            try {
                int bonusNumber;
                try {
                    bonusNumber = Integer.parseInt(Console.readLine());
                } catch (Exception e) {
                    throw new IllegalArgumentException(INPUT_BONUS_NUMBER_ERROR.getMessage());
                }
                validateBonusNumber(winNumber, bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateBonusNumber(List<Integer> winNumber, int bonusNumber) {
        if (isContain(winNumber, bonusNumber)) {
            throw new IllegalArgumentException(INPUT_BONUS_DUPLICATE_WIN_NUMBER_ERROR.getMessage());
        }

        if (isNotRange(bonusNumber)) {
            throw new IllegalArgumentException(INPUT_BONUS_NUMBER_RANGE_ERROR.getMessage());
        }
    }

    private void printBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER.getMessage());
    }

    private boolean isContain(List<Integer> winNumber, int bonusNumber) {
        return winNumber.contains(bonusNumber);
    }

    private boolean isNotRange(int bonusNumber) {
        return bonusNumber < LOTTO_MIN_NUMBER.getValue() || bonusNumber > LOTTO_MAX_NUMBER.getValue();
    }

}
