package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputView {
    private static String getInputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine().trim();
    }

    public static int getPurchaseAmount() {
        while (true) {
            try {
                String input = getInputPurchaseAmount();
                return validatePurchaseAmount(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int validatePurchaseAmount(String input) {
        try {
            int amount = Integer.parseInt(input);
            if ((amount % 1000) != 0) {
                throw new IllegalArgumentException("[ERROR] 숫자는 1,000원 단위로 입력해 주세요.");
            }
            return amount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
        }
    }

    private static String getInputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine().trim();
    }

    public static List<Integer> getWinningNumbers() {
        while (true) {
            try {
                String input = getInputWinningNumbers();
                return validateWinningNumbers(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static List<Integer> validateWinningNumbers(String input) {
        String[] inputNumbers = input.split(",");
        if (inputNumbers.length != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }

        List<Integer> winningNumbers = new ArrayList<>();
        Set<Integer> uniqueNumbers = new HashSet<>(winningNumbers);
        for (String number : inputNumbers) {
            try {
                int winningNumber = Integer.parseInt(number.trim());
                if (winningNumber < 1 || winningNumber > 45) {
                    throw new IllegalArgumentException("[ERROR] 1부터 45 사이의 숫자여야 합니다.");
                }
                if (!uniqueNumbers.add(winningNumber)) {
                    throw new IllegalArgumentException("[ERROR] 번호는 중복될 수 없습니다.");
                }
                winningNumbers.add(winningNumber);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
            }
        }
        return winningNumbers;
    }

    private static String getInputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine().trim();
    }

    public static int getBonusNumber() {
        while (true) {
            try {
                String input = getInputBonusNumber();
                return validateBonusNumber(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int validateBonusNumber(String input) {
        try {
            int bonusNumber = Integer.parseInt(input);
            if (bonusNumber < 1 || bonusNumber > 45) {
                throw new IllegalArgumentException("[ERROR] 1부터 45 사이의 숫자여야 합니다.");
            }
            return bonusNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
        }
    }
}
