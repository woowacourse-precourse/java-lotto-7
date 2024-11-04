package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.InvalidBonusNumberException;
import lotto.exception.InvalidLottoNumberException;
import lotto.exception.InvalidPurchaseAmountException;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class InputView {

    public static int requestPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            int amount = Integer.parseInt(Console.readLine());
            validatePurchaseAmount(amount);
            return amount;
        } catch (NumberFormatException e) {
            throw new InvalidPurchaseAmountException("구입 금액은 숫자여야 합니다.");
        }
    }

    private static void validatePurchaseAmount(int amount) {
        if (amount < 1000 || amount % 1000 != 0) {
            throw new InvalidPurchaseAmountException("구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }

    public static Set<Integer> requestWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요. (쉼표로 구분하여 입력)");
        String input = Console.readLine();
        String[] numberStrings = input.split(",");

        if (numberStrings.length != 6) {
            throw new InvalidLottoNumberException("당첨 번호는 6개의 숫자로 입력해야 합니다.");
        }

        Set<Integer> numbers = Arrays.stream(numberStrings)
                .map(String::trim)
                .map(InputView::parseNumber)
                .collect(Collectors.toSet());

        if (numbers.size() != 6) {
            throw new InvalidLottoNumberException("당첨 번호에는 중복된 숫자가 없어야 합니다.");
        }

        return numbers;
    }

    private static int parseNumber(String number) {
        try {
            int parsedNumber = Integer.parseInt(number);
            if (parsedNumber < 1 || parsedNumber > 45) {
                throw new InvalidLottoNumberException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
            return parsedNumber;
        } catch (NumberFormatException e) {
            throw new InvalidLottoNumberException("로또 번호는 숫자여야 합니다.");
        }
    }

    public static int requestBonusNumber(Set<Integer> winningNumbers) {
        System.out.println("보너스 번호를 입력해 주세요.");
        try {
            int bonusNumber = Integer.parseInt(Console.readLine());
            validateBonusNumber(bonusNumber, winningNumbers);
            return bonusNumber;
        } catch (NumberFormatException e) {
            throw new InvalidBonusNumberException("보너스 번호는 숫자여야 합니다.");
        }
    }

    private static void validateBonusNumber(int bonusNumber, Set<Integer> winningNumbers) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new InvalidBonusNumberException("보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new InvalidBonusNumberException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}