package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.Domain.Lotto;

public class InputView {
    final static String ERROR_MESSAGE_EMPTY_OR_NULL = "[ERROR] 빈 문자열 입력할 수 없습니다.";
    final static String ERROR_MESSAGE_NOT_NUMBER = "[ERROR] 숫자만 입력할 수 있습니다.";
    final static String ERROR_MESSAGE_NOT_DIVISION = "[ERROR] 1000으로 나눌 수 없습니다.";
    final static String ERROR_MESSAGE_NOT_UNIQUE = "[ERROR] 당첨번호와 보너스번호는 같을 수 없습니다.";
    final static String ERROR_MESSAGE_NOT_POSITIVE_NUMBER = "[ERROR] 구입금액이 올바르지 않습니다.";

    final static Integer DIVISOR = 1000;
    static OutputView outputView = new OutputView();


    public String getPurchasePrice() {
        while (true) {
            try {
                outputView.askPurchase();
                String userInput = Console.readLine();
                validatePurchasePrice(userInput);
                return userInput;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String getJackpotNumbers() {
        while (true) {
            try {
                outputView.askJackpotNumbers();
                String userInput = Console.readLine();
                validateJackpotNumber(userInput);
                return userInput;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String getBonusNumber(Lotto numbers) {
        while (true) {
            try {
                String userInput = Console.readLine();
                validateBonusNumber(userInput, numbers);
                return userInput;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validatePurchasePrice(String userInput) {
        isZero(userInput);
        isNumber(userInput);
        isPositiveNumber(userInput);
        isPossibleDivide(userInput);
    }

    private void validateJackpotNumber(String userInput) {
        isZero(userInput);
        isPossibleSplit(userInput);
    }

    private void validateBonusNumber(String userInput, Lotto numbers) {
        isZero(userInput);
        isNumber(userInput);
        isUnique(userInput, numbers);
    }

    private void isZero(String userInput) {
        if (userInput == null || userInput.isEmpty()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_EMPTY_OR_NULL);
        }
    }

    private void isNumber(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_NUMBER);
        }
    }

    private void isPositiveNumber(String userInput) {
        if (Integer.parseInt(userInput) < 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_POSITIVE_NUMBER);
        }

    }

    private void isPossibleDivide(String userInput) {
        int number = Integer.parseInt(userInput);
        if (number % DIVISOR != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_DIVISION);
        }
    }

    private void isPossibleSplit(String userInput) {
        String[] splits = userInput.split(",", -1);
        for (String split : splits) {
            isZero(split);
            isNumber(split);
        }
    }

    private void isUnique(String userInput, Lotto numbers) {
        if (numbers.getNumbers().contains(Integer.parseInt(userInput))) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_UNIQUE);
        }
    }

}
