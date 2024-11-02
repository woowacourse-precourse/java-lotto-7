package lotto.core.model;

import java.util.List;
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
            throw new IllegalArgumentException("로또 구입 금액을 입력해주세요.");
        }
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("로또 구입 금액은 숫자만 입력해주세요.");
        }
    }

    private void validate(Integer value) {
        if (value == null) {
            throw new IllegalArgumentException("로또 구입 금액을 입력해주세요.");
        }
        if (value < BASE_AMOUNT) {
            throw new IllegalArgumentException("로또 구입 금액은 1000 이상의 숫자를 입력해주세요.");
        }
        if (value % BASE_AMOUNT != 0) {
            throw new IllegalArgumentException("로또 구입 금액은 1000 단위의 숫자를 입력해주세요.");
        }
    }

    public Integer getValue() {
        return this.value;
    }

    public Integer getLottoCount() {
        return this.lottoCount;
    }
}
