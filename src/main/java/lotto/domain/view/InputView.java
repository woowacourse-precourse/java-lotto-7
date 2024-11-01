package lotto.domain.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.common.exception.BusinessException;
import lotto.domain.model.lotto.Lotto;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static lotto.common.constant.LottoConst.*;
import static lotto.common.exception.ErrorCode.*;

public class InputView {

    public int getUserPurchaseAmount() {
        printRequestAmount();
        return getAmountUntilValid();
    }

    private void printRequestAmount() {
        System.out.println(LOTTO_AMOUNT_REQUEST);
    }

    private int getAmountUntilValid() {
        while (true) {
            try {
                String input = Console.readLine();
                return amountExceptionThrower(input);
            } catch (BusinessException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int amountExceptionThrower(String input) {
        int amount = parseAmountOrThrow(input);
        isDivisableOrThrow(amount);
        return amount;
    }

    private int parseAmountOrThrow(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new BusinessException(NOT_NUMBER);
        }
    }

    private void isDivisableOrThrow(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new BusinessException(CANT_DIVIDE);
        }
    }

    public Lotto getWinningNumber() {
        printRequestWinningNumber();
        return getWinningNumberUntilValid();
    }

    private void printRequestWinningNumber() {
        System.out.println(LOTTO_WINNING_NUMBER_REQUEST);
    }

    private Lotto getWinningNumberUntilValid() {
        while (true) {
            try {
                String input = Console.readLine();
                return winningNumberExceptionThrower(input);
            } catch (BusinessException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Lotto winningNumberExceptionThrower(String input) {
        List<Integer> winningNumber = parseWinningNumberOrThrow(input);
        isSixNumbersOrThrow(winningNumber);
        return Lotto.create(winningNumber);
    }

    private List<Integer> parseWinningNumberOrThrow(String input) {
        try {
            String[] numbers = input.split(DELIMITER);
            return Arrays.stream(numbers)
                    .map(Integer::parseInt)
                    .filter(isWithinRangeCond())
                    .sorted()
                    .toList();
        } catch (NumberFormatException e) {
            throw new BusinessException(INCORRECT_WINNING_NUMBER);
        }
    }

    private static Predicate<Integer> isWithinRangeCond() {
        return integer -> integer >= START_NUM && integer <= END_NUM;
    }

    private void isSixNumbersOrThrow(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new BusinessException(LOTTO_INVALID_QUANTITY);
        }
    }

    public int getBonusNumber(Lotto winningNumber) {
        printRequestBonusNumber();
        return getBonusNumberUntilValid(winningNumber);
    }

    private void printRequestBonusNumber() {
        System.out.println(LOTTO_BONUS_NUMBER_REQUEST);
    }

    private int getBonusNumberUntilValid(Lotto winningNumber) {
        while (true) {
            try {
                String input = Console.readLine();
                return bonusNumberExceptionThrower(input, winningNumber);
            } catch (BusinessException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int bonusNumberExceptionThrower(String input, Lotto winningNumber) {
        int bonusNumber = parseAmountOrThrow(input);
        isWithinLimitOrThrow(bonusNumber);
        isUniqueNumberOrThrow(bonusNumber, winningNumber);
        return bonusNumber;
    }

    private void isUniqueNumberOrThrow(int amount, Lotto winningNumber) {
        if (winningNumber.isContainingNumber(amount)) {
            throw new BusinessException(DUPLICATE_BONUS_NUMBER);
        }
    }

    private void isWithinLimitOrThrow(int input) {
        if (input < START_NUM || input > END_NUM) {
            throw new BusinessException(INCORRECT_BONUS_NUMBER);
        }
    }
}