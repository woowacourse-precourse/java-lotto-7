package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.Set;

public class InputView implements Input {

    @Override
    public int getPurchaseAmount() {
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            try {
                return validatePurchaseAmount(Console.readLine());
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 구입 금액은 숫자로 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public String getWinningNumbers() {
        while (true) {
            System.out.println("당첨 번호를 입력해 주세요.");
            try {
                return validateWinningNumbers(Console.readLine().trim());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public int getBonusNumber() {
        while (true) {
            System.out.println("보너스 번호를 입력해 주세요.");
            try {
                return validateBonusNumber(Console.readLine());
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 보너스 번호는 숫자로 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // 유효성 검증 메서드들
    private int validatePurchaseAmount(String input) {
        int amount = Integer.parseInt(input);
        if (amount < 1000 || amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위의 양수여야 합니다.");
        }
        return amount;
    }

    private String validateWinningNumbers(String input) {
        String[] numbers = input.split(",");
        if (numbers.length != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 쉼표로 구분된 6개의 숫자로 입력해야 합니다.");
        }
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (String number : numbers) {
            int num = Integer.parseInt(number.trim());
            if (num < 1 || num > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
            if (!uniqueNumbers.add(num)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 있습니다.");
            }
        }
        return input;
    }

    private int validateBonusNumber(String input) {
        int bonusNumber = Integer.parseInt(input);
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        return bonusNumber;
    }
}
