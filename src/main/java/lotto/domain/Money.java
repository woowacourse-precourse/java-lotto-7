package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.constant.GlobalConstant;
import lotto.constant.LotteryConst;
import lotto.exception.ExceptionMessages;

public class Money {

    private static final int ZERO = 0;
    private static final int VALUE_FOR_CALCULATE_RATE_OF_RETURN = 100;

    private final int amount;

    public Money(int amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(int amount) {
        validateNegativeDigit(amount);
        validateCannotDivisible(amount);
    }

    private void validateNegativeDigit(int amount) {
        if (amount < ZERO) {
            throw new IllegalArgumentException(ExceptionMessages.AMOUNT_CANNOT_BE_NEGATIVE_DIGIT.getMessage());
        }
    }

    private void validateCannotDivisible(int amount) {
        if (amount % LotteryConst.PRICE.getValue() != ZERO) {
            throw new IllegalArgumentException(ExceptionMessages.AMOUNT_CANNOT_DIVISIBLE.getMessage());
        }
    }

    public Tickets createTickets() {
        List<Lotto> tickets = new ArrayList<>();
        int count = amount / LotteryConst.PRICE.getValue();
        for (int i = GlobalConstant.INIT_VAL.getValue(); i < count; i++) {
            List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(
                    LotteryConst.MIN.getValue(),
                    LotteryConst.MAX.getValue(),
                    LotteryConst.AMOUNT.getValue()));
            Collections.sort(numbers);
            tickets.add(new Lotto(numbers));
        }

        return new Tickets(tickets);
    }

    public double calcRateOfReturn(long sumOfPrize) {
        return (double) sumOfPrize / amount * VALUE_FOR_CALCULATE_RATE_OF_RETURN;
    }
}
