package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.StringParser;
import lotto.validation.Validation;

import java.util.List;


public class InputView {
    private static final String MONEY_INPUT = "구입 금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_INPUT = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT = "보너스 번호를 입력해 주세요.";

    private static String input(String message) {
        System.out.println(message);
        return Console.readLine();
    }

    private static String moneyInput() {
        return input(MONEY_INPUT);
    }

    private static String winningNumbersInput() {
        return input(WINNING_NUMBERS_INPUT);
    }

    private static String bonusNumberInput() {
        return input(BONUS_NUMBER_INPUT);
    }

    public static int getMoney() {
        String inputMoney = InputView.moneyInput();
        if (isValidMoney(inputMoney)) {
            return getValidMoney(inputMoney);
        } else {
            return getMoney();
        }
    }

    private static boolean isValidMoney(String input) {
        try {
            getValidMoney(input);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static List<Integer> getWinningNumbers() {
        String inputWinningNumbers = InputView.winningNumbersInput();
        if (isValidWinningNumbers(inputWinningNumbers)) {
            return StringParser.parseStringToIntegerList(inputWinningNumbers);
        } else {
            return getWinningNumbers();
        }
    }

    private static boolean isValidWinningNumbers(String input) {
        try {
            StringParser.parseStringToIntegerList(input);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static Integer getBonusNumber(List<Integer> winningNumbers) {
        String inputBonusNumber = InputView.bonusNumberInput();
        if (isValidBonusNumber(winningNumbers, inputBonusNumber)) {
            return getValidBonusNumber(winningNumbers, inputBonusNumber);
        } else {
            return getBonusNumber(winningNumbers);
        }
    }

    private static boolean isValidBonusNumber(List<Integer> winningNumbers, String inputBonusNumber) {
        try {
            getValidBonusNumber(winningNumbers, inputBonusNumber);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static Integer getValidMoney(String inputMoney) {
        return StringParser.parseStringToInt(inputMoney);
    }

    private static Integer getValidBonusNumber(List<Integer> winningNumbers, String inputBonusNumber) {
        Integer bonusNumber = StringParser.parseStringToInt(inputBonusNumber);
        Validation.validateDuplicateNumbersWithBonusNumber(winningNumbers, bonusNumber);
        return bonusNumber;
    }
}
