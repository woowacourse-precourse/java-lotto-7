package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {
    public static final String ERROR_MESSAGE_NON_NUMERIC = "[ERROR] 숫자를 입력해 주세요.";
    public static final String ERROR_MESSAGE_NOT_DIVISIBLE_BY_1000 = "[ERROR] 1000원 단위로 입력해 주세요.";
    public static final String ERROR_MESSAGE_TRAILING_COMMA = "[ERROR] 쉼표 뒤에 당첨 번호를 입력해 주세요.";
    public static final String ERROR_MESSAGE_NON_COMMA_DELIMITER = "[ERROR] 쉼표를 구분자로 사용해 주세요.";
    public static final String ERROR_MESSAGE_OUT_OF_RANGE = "[ERROR] 1부터 45 사이의 숫자를 입력해 주세요.";
    public static final String ERROR_MESSAGE_DUPLICATE_BONUS_NUMBER = "[ERROR] 당첨 번호에 없는 번호를 입력해 주세요.";
    private List<Integer> lottoWinningNumber;

    public int readLottoPurchasePrice() {
        while (true) {
            try {
                String userInput = Console.readLine();
                validateIsNumeric(userInput);
                int lottoPurchasePrice = Integer.parseInt(userInput);
                validatePurchasePriceByThousand(lottoPurchasePrice);
                return lottoPurchasePrice;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> readLottoWinningNumber() {
        while (true) {
            try {
                String userInput = Console.readLine();
                validateLastCharComma(userInput);
                validateNonCommaDelimiter(userInput);
                List<Integer> lottoWinningNumber = splitStringToList(userInput);
                this.lottoWinningNumber = lottoWinningNumber;
                new Lotto(lottoWinningNumber);
                return lottoWinningNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int readLottoBonusNumber() {
        while (true) {
            try {
                String userInput = Console.readLine();
                validateIsNumeric(userInput);
                int lottoBonusNumber = Integer.parseInt(userInput);
                validateLottoRange(lottoBonusNumber);
                validateBonusNumberDuplicate(lottoWinningNumber, lottoBonusNumber);
                return lottoBonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> splitStringToList(String userInput) {
        String[] splitInput = userInput.split(",");
        List<Integer> lottoWinningNumber = new ArrayList<>();
        for (String s : splitInput) {
            lottoWinningNumber.add(Integer.parseInt(s));
        }
        return lottoWinningNumber;
    }

    public void validateBonusNumberDuplicate(List<Integer> winningNumber, int bonusNumber) {
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_DUPLICATE_BONUS_NUMBER);
        }
    }

    public void validateLottoRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ERROR_MESSAGE_OUT_OF_RANGE);
        }
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

    public void validateIsNumeric(String userInput) {
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
