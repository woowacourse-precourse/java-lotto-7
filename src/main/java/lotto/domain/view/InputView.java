package lotto.domain.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.common.exception.BusinessException;
import lotto.domain.model.lotto.Lotto;

import java.util.Arrays;
import java.util.List;

import static lotto.common.constant.LottoConst.*;
import static lotto.common.exception.ErrorCode.*;

public class InputView {

    public int getUserPurchaseAmount() {
        printRequestAmount();
        return readValidAmount();
    }


    private void printRequestAmount() {
        System.out.println(LOTTO_AMOUNT_REQUEST);
    }

    private int readValidAmount() {
        while (true) {
            try {
                String input = Console.readLine();
                return validateAmount(input);
            } catch (BusinessException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int validateAmount(String input) {
        int amount = parseAmount(input);
        validateDivisibleByLottoPrice(amount);
        return amount;
    }

    private void validateDivisibleByLottoPrice(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new BusinessException(CANT_DIVIDE);
        }
    }

    public Lotto getWinningNumber() {
        printRequestWinningNumber();
        return readValidWinningNumber();
    }

    private void printRequestWinningNumber() {
        System.out.println(LOTTO_WINNING_NUMBER_REQUEST);
    }

    private Lotto readValidWinningNumber() {
        while (true) {
            try {
                String input = Console.readLine();
                return validWinningNumber(input);
            } catch (BusinessException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Lotto validWinningNumber(String input) {
        List<Integer> winningNumber = parseWinningNumber(input);
        isSixNumbers(winningNumber);
        return Lotto.create(winningNumber);
    }

    private List<Integer> parseWinningNumber(String input) {
        try {
            String[] numbers = input.split(DELIMITER);
            return Arrays.stream(numbers)
                    .map(Integer::parseInt)
                    .filter(integer -> integer >= START_NUM && integer <= END_NUM)
                    .sorted()
                    .toList();
        } catch (NumberFormatException e) {
            throw new BusinessException(INCORRECT_WINNING_NUMBER);
        }
    }

    private void isSixNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new BusinessException(LOTTO_INVALID_QUANTITY);
        }
    }

    public int getBonusNumber(Lotto winningNumber) {
        printRequestBonusNumber();
        return readValidBonusNumber(winningNumber);
    }

    private void printRequestBonusNumber() {
        System.out.println(LOTTO_BONUS_NUMBER_REQUEST);
    }

    private int readValidBonusNumber(Lotto winningNumber) {
        while (true) {
            try {
                String input = Console.readLine();
                return validBonusNumber(input, winningNumber);
            } catch (BusinessException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int validBonusNumber(String input, Lotto winningNumber) {
        int bonusNumber = parseAmount(input);
        isWithinLimit(bonusNumber);
        isContaininWithWinninNumber(bonusNumber, winningNumber);
        return bonusNumber;
    }

    private void isContaininWithWinninNumber(int amount, Lotto winningNumber) {
        if (winningNumber.isContainingNumber(amount)) {
            throw new BusinessException(DUPLICATE_BONUS_NUMBER);
        }
    }

    private int parseAmount(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new BusinessException(NOT_NUMBER);
        }
    }

    private void isWithinLimit(int input) {
        if (input < START_NUM || input > END_NUM) {
            throw new BusinessException(INCORRECT_BONUS_NUMBER);
        }
    }
}