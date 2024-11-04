package lotto.View;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class InputView {

    public static int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseAmount = Console.readLine();
        return validatePurchaseAmount(purchaseAmount);
    }

    private static int validatePurchaseAmount(String input) {
        try {
            int purchaseAmount = Integer.parseInt(input);
            if (purchaseAmount < 1000 || purchaseAmount % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
            }
            return purchaseAmount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 숫자로 입력해야 합니다.");
        }

    }

    public static List<Integer> getWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String[] winNumbers = Console.readLine().split(",");
        return validateWinningNumbers(winNumbers);
    }

    private static List<Integer> validateWinningNumbers(String[] input) {
        try {
            List<Integer> winningNumbers = new ArrayList<>();
            for (String s : input) {
                int winningNumber = Integer.parseInt(s.trim());
                if (winningNumber < 1 || winningNumber > 45) {
                    throw new IllegalArgumentException("[ERROR] 당첨 숫자는 1부터 45 사이의 숫자여야 합니다.");
                }
                winningNumbers.add(winningNumber);
            }
            if (new HashSet<>(winningNumbers).size() != winningNumbers.size()) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
            }
            return winningNumbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자여야 합니다.");
        }
    }

    public static int getBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();
        return validateBonusNumber(bonusNumber);
    }

    private static int validateBonusNumber (String input) {
        try {
            int bonusNumber = Integer.parseInt(input);
            if (bonusNumber  < 1 || bonusNumber > 45) {
                throw new IllegalArgumentException("[ERROR] 보너스 숫자는 1부터 45 사이의 숫자여야 합니다.");
            }
            return bonusNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 숫자는 숫자로 입력해야 합니다.");
        }
    }
}
