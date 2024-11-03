package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.common.ErrorMessage;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    // 1-1. 로또 구입 금액 입력 메서드
    public static int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            int purchaseAmount = Integer.parseInt(Console.readLine());

            if (purchaseAmount % 1000 != 0) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_AMOUNT);
            }
            return purchaseAmount;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT);
        }
    }

    // 1-2. 당첨 번호 입력 메서드
    public static List<Integer> inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();

        List<Integer> winningNumbers = Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        if (winningNumbers.size() != 6 || !isValidNumberRange(winningNumbers)) {
            throw new IllegalArgumentException(winningNumbers.size() != 6
                    ? ErrorMessage.INVALID_WINNING_NUMBER_COUNT
                    : ErrorMessage.NUMBER_OUT_OF_RANGE);
        }

        return winningNumbers;
    }

    private static boolean isValidNumberRange(List<Integer> numbers) {
        return numbers.stream().allMatch(number -> number >= 1 && number <= 45);
    }

    // 1-3. 보너스 번호 입력 메서드
    public static int inputBonusNumber(List<Integer> winningNumbers) {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        String[] numbers = input.split(",");

        if (numbers.length != 1) { // 입력된 숫자가 1개가 아닌 경우 예외 발생
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER);
        }

        int bonusNumber = Integer.parseInt(numbers[0].trim()); // 보너스 번호를 숫자로 변환
        if (bonusNumber < 1 || bonusNumber > 45) { // 1 ~ 45 범위를 벗어나면 예외 발생
            throw new IllegalArgumentException(ErrorMessage.NUMBER_OUT_OF_RANGE);
        }
        validateBonusNumber(winningNumbers, bonusNumber);
        return bonusNumber;
    }
    public static void validateBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_DUPLICATE);
        }
    }
}
