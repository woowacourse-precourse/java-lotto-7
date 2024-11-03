package lotto.util;

import lotto.message.ErrorMessage;

import java.math.BigInteger;
import java.util.List;

public class Validator {
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

    public List<BigInteger> validWinningNumbers(String winningNumbers) {
        List<BigInteger> winningNumberList = isNumbers(winningNumbers);

        if (!areBetweenOneAndFourtyFive(winningNumberList))
            throw new IllegalArgumentException(ErrorMessage.PREFIX.getMessage() + ErrorMessage.INVALID_RANGE.getMessage());
        if (!isSixNumber(winningNumberList.size()))
            throw new IllegalArgumentException(ErrorMessage.PREFIX.getMessage() + ErrorMessage.INVALID_NUMBER_COUNT.getMessage());
        return winningNumberList;
    }

    public BigInteger validBonusNumber(String bonusNumber) {
        if (!isNumber(bonusNumber))
            throw new IllegalArgumentException(ErrorMessage.PREFIX.getMessage() + ErrorMessage.NONE_NUMBER.getMessage());

        BigInteger bonus = new BigInteger(bonusNumber);
        if (!isBetweenOneAndFourtyFive(bonus))
            throw new IllegalArgumentException(ErrorMessage.PREFIX.getMessage() + ErrorMessage.INVALID_RANGE.getMessage());
        return bonus;
    }

    private List<BigInteger> isNumbers(String winningNumbers) {
        Splitter splitter = new Splitter();

        try {
            return splitter.splitNumberByComma(winningNumbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.PREFIX.getMessage() + ErrorMessage.NONE_NUMBER.getMessage());
        }
    }

    private boolean areBetweenOneAndFourtyFive(List<BigInteger> winningNumbers) {
        for (BigInteger winningNumber : winningNumbers) {
            if (winningNumber.compareTo(BigInteger.ONE) < 0)
                return false;
            if (winningNumber.compareTo(BigInteger.valueOf(45L)) > 0)
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
