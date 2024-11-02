package lotto.core.model;

import java.util.List;
import lotto.commons.numbers.Integers;
import lotto.core.constants.Error;
import lotto.core.dto.LottoPurchaseAmountDto;

public class LottoPurchaseAmount {

    private static final int BASE_AMOUNT = 1000;

    private final Integer value;

    private final Integer lottoCount;

    public LottoPurchaseAmount(String value) {
        this(LottoPurchaseAmount.parseString(value));
    }

    public LottoPurchaseAmount(Integer value) {
        validate(value);
        this.value = value;
        this.lottoCount = this.value / BASE_AMOUNT;
    }

    public static LottoPurchaseAmount dtoOf(LottoPurchaseAmountDto dto) {
        return new LottoPurchaseAmount(dto.value());
    }

    public static LottoPurchaseAmount lottosOf(List<Lotto> lottos) {
        Integer value = lottos.size() * BASE_AMOUNT;
        return new LottoPurchaseAmount(value);
    }

    private static Integer parseString(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(Error.LottoPurchaseAmount.REQUIRED_AMOUNT);
        }
        return Integers.parseIntOrThrow(value, Error.LottoPurchaseAmount.INVALID_AMOUNT_FORMAT);
    }

    private void validate(Integer value) {
        if (value == null) {
            throw new IllegalArgumentException(Error.LottoPurchaseAmount.REQUIRED_AMOUNT);
        }
        if (value < BASE_AMOUNT) {
            throw new IllegalArgumentException(Error.LottoPurchaseAmount.BELOW_BASE_AMOUNT);
        }
        if (value % BASE_AMOUNT != 0) {
            throw new IllegalArgumentException(Error.LottoPurchaseAmount.INVALID_BASE_AMOUNT_UNIT);
        }
    }

    public Integer getValue() {
        return this.value;
    }

    public Integer getLottoCount() {
        return this.lottoCount;
    }
}
