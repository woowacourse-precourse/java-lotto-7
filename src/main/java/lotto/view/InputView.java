package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputView {

    private final String PURCHASE_AMOUNT_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private final String WINNING_NUMBERS_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";

    public int inputPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_INPUT_MESSAGE);
        return readPurchaseAmount();
    }

    private int readPurchaseAmount() {
        String input = Console.readLine();
        try {
            int purchaseAmount = parsePurchaseAmount(input);
            validatePurchaseAmount(purchaseAmount);
            return purchaseAmount;
        } catch (IllegalArgumentException e) {
            return readPurchaseAmount();
        }
    }

    private int parsePurchaseAmount(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자를 입력해야 합니다.");
            return readPurchaseAmount();
        }
    }

    public void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위여야 합니다.");
        }
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println(WINNING_NUMBERS_INPUT_MESSAGE);
        return readWinningNumbers();
    }

    private List<Integer> readWinningNumbers() {
        String input = Console.readLine();
        try {
            List<Integer> winningNumbers = parseWinningNumbers(input);
            validateWinningNumbers(winningNumbers);
            return winningNumbers;
        } catch (IllegalAccessError e) {
            System.out.println("[ERROR]" + e.getMessage());
            return readWinningNumbers();
        }
    }

    private List<Integer> parseWinningNumbers(String input) {
        List<Integer> winningNumbers = new ArrayList<>();
        String[] splitWinningNumbers = input.split(",");
        if (splitWinningNumbers.length != 6) {
            throw new IllegalArgumentException("당첨 번호는 6개의 숫자여야 합니다.");
        }

        for (String number : splitWinningNumbers) {
            winningNumbers.add(parseNumber(number.trim()));
        }
    }

    private int parseNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력해야 합니다.");
        }
    }

    private void validateWinningNumbers(List<Integer> winningNumbers) {
        if (hasDuplicate(winningNumbers)) {
            throw new IllegalArgumentException("당첨 번호는 중복될 수 없습니다.");
        }
        if (!areNumbersInRange(winningNumbers)) {
            throw new IllegalArgumentException("당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private boolean hasDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        return uniqueNumbers.size() != numbers.size();
    }

    private boolean areNumbersInRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                return false;
            }
        }
        return true;
    }

    public int inputBonusNumber() {
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
        return readBonusNumber();
    }

    private int readBonusNumber() {
        String input = Console.readLine();
        try {
            int bonusNumber = parseBonusNumber(input);
            validateBonusNumberInRange(bonusNumber);
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            return readBonusNumber();
        }
    }

    private int parseBonusNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자를 입력해야 합니다.");
            return readBonusNumber();
        }
    }

    private void validateBonusNumberInRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
