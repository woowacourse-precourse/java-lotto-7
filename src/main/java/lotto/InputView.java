package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {
    public static final String ERROR_MESSAGE_NON_NUMERIC = "[ERROR] 숫자를 입력해 주세요.";
    public static final String ERROR_MESSAGE_NOT_DIVISIBLE_BY_1000 = "[ERROR] 1000원 단위로 입력해 주세요.";
    public static final String ERROR_MESSAGE_TRAILING_COMMA = "[ERROR] 쉼표 뒤에 당첨 번호를 입력해 주세요.";
    public static final String ERROR_MESSAGE_NON_COMMA_DELIMITER = "[ERROR] 쉼표를 구분자로 사용해 주세요.";

    public int readLottoPurchasePrice() {
        String userInput = Console.readLine();
        validatePurchasePriceIsNumber(userInput);
        int lottoPurchasePrice = Integer.parseInt(userInput);
        validatePurchasePriceByThousand(lottoPurchasePrice);
        return lottoPurchasePrice;
    }

    public List<Integer> readLottoWinningNumber() {
        String userInput = Console.readLine();
        validateLastCharComma(userInput);
        validateNonCommaDelimiter(userInput);
        String[] splitInput = userInput.split(",");
        List<Integer> lottoWinningNumber = new ArrayList<>();
        for (int i = 0; i < splitInput.length; i++) {
            lottoWinningNumber.add(Integer.parseInt(splitInput[i]));
        }
        return lottoWinningNumber;
    }

    public void validateLastCharComma(String userInput) {
        if (userInput.charAt(userInput.length() - 1) == ',') {
            throw new IllegalArgumentException(ERROR_MESSAGE_TRAILING_COMMA);
        }
    }

    public void validateNonCommaDelimiter(String userInput) {
        userInput = String.join("", userInput.split(","));
        if (!userInput.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NON_COMMA_DELIMITER);
        }
    }

    public void validatePurchasePriceIsNumber(String userInput) {
        if (!userInput.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NON_NUMERIC);
        }
    }

    public void validatePurchasePriceByThousand(int lottoPurchasePrice) {
        if (lottoPurchasePrice % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_DIVISIBLE_BY_1000);
        }
    }
}
