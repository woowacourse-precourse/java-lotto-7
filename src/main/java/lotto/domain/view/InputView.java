package lotto.domain.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.common.exception.BusinessException;
import lotto.domain.model.user.Lotto;

import java.util.Arrays;
import java.util.List;

import static lotto.common.constant.LottoConst.*;
import static lotto.common.exception.ErrorCode.*;
import static lotto.domain.view.InputValidator.*;

public class InputView {

    /**
     * @param: 3가지의 Input Validator<br>
     * 1) 가격 <br>
     * 2) 당첨 번호 <br>
     * 3) 보너스 번호 <br>
     */
    private <T> T getInputUntilValid(InputValidator<T> validator) {
        while (true) {
            try {
                String input = Console.readLine();
                return validator.validate(input);
            } catch (BusinessException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    /**
     * 구입 금액 받기
     */
    public int getUserPurchaseAmount() {
        printRequestAmount();
        return getInputUntilValid(this::validateAmount);
    }

    private void printRequestAmount() {
        System.out.println(LOTTO_AMOUNT_REQUEST);
    }

    private int validateAmount(String input) {
        int amount = parseAmountOrThrow(input);
        validateDivisibility(amount);
        return amount;
    }

    private int parseAmountOrThrow(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new BusinessException(NOT_NUMBER);
        }
    }

    private void validateDivisibility(int amount) {
        if (IS_NOT_DIVISABLE_BY_LOTTO_PRICE.test(amount)) {
            throw new BusinessException(CANT_DIVIDE);
        }
    }

    /**
     * 당첨 로또 번호 받기
     */
    public Lotto getWinningNumber() {
        printRequestWinningNumber();
        return getInputUntilValid(this::validateWinningNumber);
    }

    private void printRequestWinningNumber() {
        System.out.println(LOTTO_WINNING_NUMBER_REQUEST);
    }

    private Lotto validateWinningNumber(String input) {
        List<Integer> winningNumbers = parseWinningNumberOrThrow(input);
        validateSixNumbers(winningNumbers);
        return Lotto.create(winningNumbers);
    }

    private List<Integer> parseWinningNumberOrThrow(String input) {
        try {
            return Arrays.stream(input.split(DELIMITER))
                    .map(Integer::parseInt)
                    .filter(IS_IN_LOTTO_RANGE)
                    .sorted()
                    .toList();
        } catch (NumberFormatException e) {
            throw new BusinessException(INCORRECT_WINNING_NUMBER);
        }
    }

    private void validateSixNumbers(List<Integer> numbers) {
        if (IS_NOT_SIX_NUMBERS.test(numbers.size())) {
            throw new BusinessException(LOTTO_INVALID_QUANTITY);
        }
    }

    /**
     * 보너스 번호 받기
     */
    public int getBonusNumber(Lotto winningNumber) {
        printRequestBonusNumber();
        return getInputUntilValid(input -> validateBonusNumber(input, winningNumber));
    }

    private void printRequestBonusNumber() {
        System.out.println(LOTTO_BONUS_NUMBER_REQUEST);
    }

    private int validateBonusNumber(String input, Lotto winningNumber) {
        int bonusNumber = parseAmountOrThrow(input);
        validateRange(bonusNumber);
        validateUnique(bonusNumber, winningNumber);
        return bonusNumber;
    }

    private void validateRange(int number) {
        if (!IS_IN_LOTTO_RANGE.test(number)) {
            throw new BusinessException(INCORRECT_BONUS_NUMBER);
        }
    }

    private void validateUnique(int number, Lotto winningNumber) {
        if (winningNumber.isContainingNumber(number)) {
            throw new BusinessException(DUPLICATE_BONUS_NUMBER);
        }
    }
}