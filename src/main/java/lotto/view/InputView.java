package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lotto.common.exception.LottoException;

import static lotto.common.constant.LottoErrorCode.*;

public class InputView {
    public int readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        try {
            validatePurchaseAmount(input);
            return Integer.parseInt(input) / 1000;
        } catch (LottoException e) {
            System.out.println(e.getMessage());
            return readPurchaseAmount();
        }
    }

    public List<Integer> readWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        try {
            return parseWinningNumbers(input);
        } catch (LottoException e) {
            System.out.println(e.getMessage());
            return readWinningNumbers();
        }
    }

    public int readBonusNumber(List<Integer> winningNumbers) {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        try {
            int bonusNumber = Integer.parseInt(input);
            validateBonusNumber(bonusNumber, winningNumbers);
            return bonusNumber;
        } catch (LottoException e) {
            System.out.println(e.getMessage());
            return readBonusNumber(winningNumbers);
        }
    }

    private void validatePurchaseAmount(String input) {
        try {
            int price = Integer.parseInt(input);
            if (price % 1000 != 0 || price <= 0) {
                throw new LottoException(INVALID_PURCHASE_AMOUNT);
            }
        } catch (NumberFormatException e) {
            throw new LottoException(INVALID_INPUT_FORMAT);
        }
    }

    private List<Integer> parseWinningNumbers(String input) {
        try {
            List<Integer> numbers = Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            validateWinningNumbers(numbers);
            return numbers;
        } catch (NumberFormatException e) {
            throw new LottoException(INVALID_INPUT_FORMAT);
        }
    }

    private void validateWinningNumbers(List<Integer> numbers) {
        if (numbers.size() != 6 ||
                numbers.stream().distinct().count() != 6) {
            throw new LottoException(INVALID_NUMBER_COUNT);
        }
        if (numbers.stream().anyMatch(n -> n < 1 || n > 45)) {
            throw new LottoException(INVALID_NUMBER_RANGE);
        }
    }

    private void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new LottoException(INVALID_BONUS_NUMBER_RANGE);
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new LottoException(BONUS_NUMBER_DUPLICATE);
        }
    }
}
