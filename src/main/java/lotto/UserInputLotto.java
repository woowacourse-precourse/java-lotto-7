package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class UserInputLotto {   // 사용자가 입력하는 값에 대한 클래스
    public int purchaseAmount() {
        // 사용자가 구입 금액 입력
        while (true) {
            try {
                int amount = purchaseAmountRead();
                validatePurchaseAmount(amount);

                return amount;
            } catch (NumberFormatException e) {
                printErrorMessage("[ERROR] 올바른 숫자를 입력하세요.");
            } catch (IllegalArgumentException e) {
                printErrorMessage(e.getMessage());
            }
        }
    }

    public List<Integer> inputPrizeNumbers() {
        // 사용자가 당첨 번호를 입력
        while (true) {
            try {
                List<Integer> numbers = inputPrizeNumbersRead();
                validateInputPrizeNumbers(numbers);

                return numbers;
            } catch (IllegalArgumentException e) {
                printErrorMessage(e.getMessage());
            }
        }
    }

    public int inputBonusNumber(List<Integer> prizeNumbers) {
        // 사용자가 보너스 번호 입력
        while (true) {
            try {
                int bonusNumber = inputBonusNumberRead();
                validateInputBonusNumber(prizeNumbers, bonusNumber);

                return bonusNumber;
            } catch (IllegalArgumentException e) {
                printErrorMessage(e.getMessage());
            }
        }
    }

    private int purchaseAmountRead() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    private List<Integer> inputPrizeNumbersRead() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();

        return delimiterNumber(input);
    }

    private int inputBonusNumberRead() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    private List<Integer> delimiterNumber(String input) {
        // 문자열을 쉽표로 구분하여 숫자로 반환
        String[] inputNumbers = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String number : inputNumbers) {
            numbers.add(Integer.parseInt(number));
        }

        return numbers;
    }

    private void validatePurchaseAmount(int amount) {
        // 구입 금액 유효성 검사
        ErrorMessage.INVALID_PURCHASE_AMOUNT.validateAmount(amount);
    }

    private void validateInputPrizeNumbers(List<Integer> numbers) {
        // 입력한 당첨 금액 유효성 검사
        ErrorMessage.INVALID_WINNING_NUMBER.validate(numbers);
        ErrorMessage.DUPLICATE_WINNING_NUMBER.validate(numbers);
        for (int number : numbers) {
            ErrorMessage.INVALID_NUMBER_RANGE.validate(number);
        }
    }

    private void validateInputBonusNumber(List<Integer> prizeNumbers, int bonusNumbers) {
        // 입력한 보너스 번호 유효성 검사
        ErrorMessage.INVALID_NUMBER_RANGE.validate(bonusNumbers);
        ErrorMessage.DUPLICATE_BONUS_WINNING_NUMBER.validate(prizeNumbers, bonusNumbers);
    }

    private void printErrorMessage(String message) {
        System.out.println(message);
    }
}
