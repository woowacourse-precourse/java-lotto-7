package lotto.view;

import static lotto.config.LottoErrorMessage.INPUT_BONUS_DUPLICATE_WIN_NUMBER_ERROR;
import static lotto.config.LottoErrorMessage.INPUT_BONUS_NUMBER_RANGE_ERROR;
import static lotto.config.LottoErrorMessage.INPUT_MONEY_DIVIDE_ERROR;
import static lotto.config.LottoErrorMessage.INPUT_MONEY_ERROR;
import static lotto.config.LottoErrorMessage.INPUT_WIN_NUMBER_DUPLICATE_ERROR;
import static lotto.config.LottoMessage.INPUT_MONEY;
import static lotto.config.LottoMessage.INPUT_WIN_NUMBER;
import static lotto.config.LottoRule.LOTTO_MAX_NUMBER;
import static lotto.config.LottoRule.LOTTO_MIN_NUMBER;
import static lotto.config.LottoRule.LOTTO_PRICE;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import lotto.config.LottoErrorMessage;
import lotto.config.LottoMessage;
import lotto.config.LottoRule;

public class LottoInputView {

    public static final String WIN_NUMBER_DELIMITER = ",";

    private LottoInputView() {
    }

    public static int getMoney() {
        while (true) {
            printInputMoney();
            try {
                int money = Integer.parseInt(Console.readLine());
                if (money % LOTTO_PRICE.getValue() != 0) {
                    throw new IllegalArgumentException(INPUT_MONEY_DIVIDE_ERROR.getMessage());
                }
                return money;
            } catch (NumberFormatException e) {
                System.out.println(INPUT_MONEY_ERROR.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void printInputMoney() {
        System.out.println(INPUT_MONEY.getMessage());
    }

    public static List<Integer> getWinNumber() {
        while (true) {
            printWinNumber();
            try {
                List<Integer> winNumber = parseToIntegers(split(Console.readLine()));

                if (isNotRange(winNumber)) {
                    throw new IllegalArgumentException(LottoErrorMessage.INPUT_WIN_NUMBER_RANGE_ERROR.getMessage());
                }

                if (isDuplicated(winNumber)) {
                    throw new IllegalArgumentException(INPUT_WIN_NUMBER_DUPLICATE_ERROR.getMessage());
                }

                return winNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static boolean isNotRange(List<Integer> winNumber) {
        return winNumber.stream().anyMatch(number -> number < LOTTO_MIN_NUMBER.getValue() || number > LOTTO_MAX_NUMBER.getValue());
    }

    private static boolean isDuplicated(List<Integer> winNumber) {
        return new HashSet<>(winNumber).size() != LottoRule.LOTTO_SIZE.getValue();
    }

    private static void printWinNumber() {
        System.out.println(INPUT_WIN_NUMBER.getMessage());
    }

    private static String[] split(String winNumber) {
        return winNumber.split(WIN_NUMBER_DELIMITER);
    }

    private static List<Integer> parseToIntegers(String[] numbers) {
        try {
            return Arrays.stream(numbers).map(Integer::parseInt).toList();
        } catch (Exception e) {
            throw new IllegalArgumentException(LottoErrorMessage.INPUT_WIN_NUMBER_ERROR.getMessage());
        }
    }

    public static int getBonusNumber(List<Integer> winNumber) {
        while (true) {
            printBonusNumber();
            try {
                int bonusNumber;
                try {
                    bonusNumber = Integer.parseInt(Console.readLine());
                } catch (Exception e) {
                    throw new IllegalArgumentException(LottoErrorMessage.INPUT_BONUS_NUMBER_ERROR.getMessage());
                }

                if (isContain(winNumber, bonusNumber)) {
                    throw new IllegalArgumentException(INPUT_BONUS_DUPLICATE_WIN_NUMBER_ERROR.getMessage());
                }

                if (isNotRange(bonusNumber)) {
                    throw new IllegalArgumentException(INPUT_BONUS_NUMBER_RANGE_ERROR.getMessage());
                }

                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void printBonusNumber() {
        System.out.println(LottoMessage.INPUT_BONUS_NUMBER.getMessage());
    }

    private static boolean isContain(List<Integer> winNumber, int bonusNumber) {
        return winNumber.contains(bonusNumber);
    }

    private static boolean isNotRange(int bonusNumber) {
        return bonusNumber < LOTTO_MIN_NUMBER.getValue() || bonusNumber > LOTTO_MAX_NUMBER.getValue();
    }

}
