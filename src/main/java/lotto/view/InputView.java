package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.Set;
import lotto.utils.ErrorMessage;

public class InputView implements Input {

    @Override
    public int getPurchaseAmount() {
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            try {
                return validatePurchaseAmount(Console.readLine());
            } catch (NumberFormatException e) {
                System.out.println(ErrorMessage.NON_NUMERIC_PURCHASE_AMOUNT);
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
                System.out.println(ErrorMessage.NON_NUMERIC_BONUS_NUMBER);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // 유효성 검증 메서드들
    private int validatePurchaseAmount(String input) {
        int amount = Integer.parseInt(input);
        if (amount < 1000 || amount % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_AMOUNT);
        }
        return amount;
    }

    private String validateWinningNumbers(String input) {
        String[] numbers = input.split(",");
        if (numbers.length != 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBERS_FORMAT);
        }
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (String number : numbers) {
            int num = Integer.parseInt(number.trim());
            if (num < 1 || num > 45) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE);
            }
            if (!uniqueNumbers.add(num)) {
                throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LOTTO_NUMBER);
            }
        }
        return input;
    }

    private int validateBonusNumber(String input) {
        int bonusNumber = Integer.parseInt(input);
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER_RANGE);
        }
        return bonusNumber;
    }
}
