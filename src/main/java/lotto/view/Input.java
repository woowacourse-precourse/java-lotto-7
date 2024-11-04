package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Bonus;
import lotto.domain.Purchase;
import lotto.domain.Winning;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Input {
    private final String SYSTEM_PURCHASE_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private final String SYSTEM_WINNING_NUMBER_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private final String SYSTEM_BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";
    private final String DELIMITER = ",";

    public Input() {

    }

    public Purchase getPurchaseAmountInput() {
        System.out.println(SYSTEM_PURCHASE_INPUT_MESSAGE);
        String userInput = Console.readLine();
        try {
            validatePurchaseAmount(userInput);
            int purchaseAmount = parsePurchaseAmount(userInput);
            return new Purchase(purchaseAmount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPurchaseAmountInput();
        }
    }

    public Winning getWinningNumberInput() {
        System.out.println(SYSTEM_WINNING_NUMBER_INPUT_MESSAGE);
        String userInput = Console.readLine();
        return parseWinningNumber(userInput);
    }

    public Bonus getBonusNumberInput() {
        System.out.println(SYSTEM_BONUS_NUMBER_INPUT_MESSAGE);
        String userInput = Console.readLine();
        return parseBonusNumber(userInput);
    }

    private int parsePurchaseAmount (String userInput) {
        int purchaseAmount = convertToInteger(userInput);
        Purchase purchase = new Purchase(purchaseAmount);
        return purchase.getPurchaseAmount();
    }

    private Winning parseWinningNumber(String userInput) {
        String[] numbers = userInput.split(DELIMITER);
        validateWinningNumbers(numbers);
        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : numbers) {
            int convertedNumber = convertToInteger(number);
            validateWinningNumber(convertedNumber);
            winningNumbers.add(convertedNumber);
        }
        Winning winning = new Winning(winningNumbers);
        return winning;
    }

    private void validateWinningNumbers(String[] numbers) {
        if (numbers.length != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 여섯 개를 입력해야 합니다.");
        }

        HashSet<Integer> uniqueNumbers = new HashSet<>();
        for (String number : numbers) {
            int num = Integer.parseInt(number);
            if (num < 1 || num > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
            uniqueNumbers.add(num);
        }

        if (uniqueNumbers.size() != numbers.length) {
            throw new IllegalArgumentException("[ERROR] 중복된 로또 번호가 존재합니다.");
        }
    }
    private Bonus parseBonusNumber(String userInput) {
        int bonusNumber = convertToInteger(userInput);
        validateBonusNumber(bonusNumber);
        Bonus bonus = new Bonus(bonusNumber);
        return bonus;
    }

    private int convertToInteger(String userInput) {
        return Integer.parseInt(userInput);
    }
    private void validatePurchaseAmount(String userInput) {
        try {
            int amount = Integer.parseInt(userInput);
            if (amount <= 0 || amount % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.");
        }
    }



    private void validateWinningNumber(int number) {
        if (number < 1 || number > 45)
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1 이상 45 이하 숫자여야 합니다.");

    }

    private void validateBonusNumber(int number) {
        if (number < 1 || number > 45)
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1 이상 45 이하 숫자여야 합니다.");
    }
}
