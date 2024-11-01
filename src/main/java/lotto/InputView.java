package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.Set;

public class InputView {
    private int purchaseAmount;
    private Set<Integer> winningNumbers;
    private int bonusNumber;

    public void inputPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String inputAmount = Console.readLine();
                purchaseAmount = Integer.parseInt(inputAmount);
                validatePurchaseAmount(purchaseAmount);
                break;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 구입 금액은 숫자여야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validatePurchaseAmount(int amount) {
        if (amount < 1000 || amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
    }

    public void inputWinningNumbers() {
        while (true) {
            try {
                System.out.println();
                System.out.println("당첨 번호를 입력해 주세요.");
                String input = Console.readLine();
                winningNumbers = parseWinningNumbers(input);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Set<Integer> parseWinningNumbers(String input) {
        String[] splitNumbers = input.split(",");
        if (splitNumbers.length != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
        Set<Integer> numbers = new HashSet<>();
        for (String numStr : splitNumbers) {
            int number = Integer.parseInt(numStr.trim());
            validateNumberRange(number);
            if (!numbers.add(number)) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복되지 않아야 합니다.");
            }
        }
        return numbers;
    }

    public void inputBonusNumber() {
        while (true) {
            try {
                System.out.println();
                System.out.println("보너스 번호를 입력해 주세요.");
                String input = Console.readLine();
                bonusNumber = Integer.parseInt(input.trim());
                validateBonusNumber(bonusNumber, winningNumbers);
                break;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 보너스 번호는 숫자여야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateBonusNumber(int bonusNumber, Set<Integer> winningNumbers) {
        validateNumberRange(bonusNumber);
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    private void validateNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public Set<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
