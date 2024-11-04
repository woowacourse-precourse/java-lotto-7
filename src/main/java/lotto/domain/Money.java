package lotto.domain;

import static lotto.utils.ErrorMessage.BIG_MONEY;
import static lotto.utils.ErrorMessage.INVALID_MONEY_INPUT;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Objects;
import lotto.dto.MoneyDto;
import lotto.utils.DtoMapper;

public class Money {
    private static final int LOTTO_PRICE = 1000;
    private static final int SCALE = 1;
    private static final int ZERO = 0;

    private final Long amount;
    private long lottoCount;

    protected Money(String input) {
        Long parsedMoney = parseMoney(input);
        this.amount = validateMoney(parsedMoney);
        this.lottoCount = calculateLottoCount(parsedMoney);
    }

    public static Money create(String input) {
        return new Money(input);
    }

    public MoneyDto toDto() {
        return DtoMapper.toMoneyDto(calculateLottoCount(amount));
    }

    protected String calculateProfitRate(BigDecimal sumPercentage) {
        return sumPercentage.divide(BigDecimal.valueOf(amount), SCALE, RoundingMode.HALF_UP)
                .toString();
    }

    private Long parseMoney(String input) {
        validateInput(input);

        try {
            BigInteger bigInteger = new BigInteger(input);
            validateMaxMoney(bigInteger);

            return bigInteger.longValue();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_MONEY_INPUT.getMessage());
        }
    }

    private void validateMaxMoney(BigInteger value) {
        if (value.compareTo(BigInteger.valueOf(Long.MAX_VALUE / LOTTO_PRICE * LOTTO_PRICE)) > 0) {
            throw new IllegalArgumentException(BIG_MONEY.getMessage());
        }
    }

    private void validateInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(INVALID_MONEY_INPUT.getMessage());
        }
    }

    private Long validateMoney(Long amount) {
        if (amount <= ZERO || amount % LOTTO_PRICE != ZERO) {
            throw new IllegalArgumentException(INVALID_MONEY_INPUT.getMessage());
        }

        return amount;
    }

    private Long calculateLottoCount(Long money) {
        return money / LOTTO_PRICE;
    }

    public boolean lottoTry() {
        if (lottoCount <= ZERO) {
            return false;
        }
        lottoCount--;
        return true;
    }

    @Override
    public String toString() {
        return amount.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Money money = (Money) o;
        return lottoCount == money.lottoCount && Objects.equals(amount, money.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, lottoCount);
    }
}
