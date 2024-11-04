package lotto.util;

import lotto.message.ErrorMessage;

import java.math.BigInteger;
import java.util.List;
import java.util.Set;

public class Validator {
    private final Integer MIN_NUMBER = 1;
    private final Integer MAX_NUMBER = 45;

    public BigInteger validPurchaseMoney(String number) {
        if (!isNumber(number))
            throw new IllegalArgumentException(ErrorMessage.PREFIX.getMessage() + ErrorMessage.NONE_NUMBER.getMessage());

        BigInteger purchaseMoney = new BigInteger(number);
        if (!isDivisibleByThousand(purchaseMoney))
            throw new IllegalArgumentException(ErrorMessage.PREFIX.getMessage() + ErrorMessage.NONE_DIVIDE_THOUSAND.getMessage());
        return purchaseMoney;
    }

    private boolean isNumber(String number) {
        return number.matches("\\d+");
    }

    private boolean isDivisibleByThousand(BigInteger purchaseMoney) {
        return purchaseMoney.remainder(BigInteger.valueOf(1000)).equals(BigInteger.ZERO);
    }

    public List<Integer> validWinningNumbers(String winningNumbers) {
        Set<Integer> winningNumberList = isNumbers(winningNumbers);

        if (!areBetweenOneAndFourtyFive(winningNumberList))
            throw new IllegalArgumentException(ErrorMessage.PREFIX.getMessage() + ErrorMessage.INVALID_RANGE.getMessage());
        if (!isSixNumber(winningNumberList.size()))
            throw new IllegalArgumentException(ErrorMessage.PREFIX.getMessage() + ErrorMessage.INVALID_NUMBER_COUNT.getMessage());
        return winningNumberList.stream().toList();
    }

    public BigInteger validBonusNumber(String bonusNumber) {
        if (!isNumber(bonusNumber))
            throw new IllegalArgumentException(ErrorMessage.PREFIX.getMessage() + ErrorMessage.NONE_NUMBER.getMessage());

        BigInteger bonus = new BigInteger(bonusNumber);
        if (!isBetweenOneAndFourtyFive(bonus))
            throw new IllegalArgumentException(ErrorMessage.PREFIX.getMessage() + ErrorMessage.INVALID_RANGE.getMessage());
        return bonus;
    }

    private Set<Integer> isNumbers(String winningNumbers) {
        Splitter splitter = new Splitter();

        try {
            return splitter.splitNumberByComma(winningNumbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.PREFIX.getMessage() + ErrorMessage.NONE_NUMBER.getMessage());
        }
    }

    private boolean areBetweenOneAndFourtyFive(Set<Integer> winningNumbers) {
        for (Integer winningNumber : winningNumbers) {
            if (winningNumber.compareTo(MIN_NUMBER) < 0)
                return false;
            if (winningNumber.compareTo(MAX_NUMBER) > 0)
                return false;
        }
        return true;
    }

    private boolean isBetweenOneAndFourtyFive(BigInteger bonusNumber) {
        if (bonusNumber.compareTo(BigInteger.ONE) < 0) {
            return false;
        }
        return bonusNumber.compareTo(BigInteger.valueOf(45L)) <= 0;
    }

    private boolean isSixNumber(int size) {
        return size == 6;
    }
}
