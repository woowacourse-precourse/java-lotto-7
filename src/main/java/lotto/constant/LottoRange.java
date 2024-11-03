package lotto.constant;

import java.util.List;

public enum LottoRange {
    MIN_LOTTO_RANGE(1),
    MAX_LOTTO_RANGE(45),
    LOTTO_SIZE(6);

    private final Integer value;

    LottoRange(int lottoRange) {
        this.value = lottoRange;
    }

    public static boolean isAvailableRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < MIN_LOTTO_RANGE.value || number > MAX_LOTTO_RANGE.value) {
                return false;
            }
        }
        return true;
    }

    public Integer getValue() {
        return value;
    }
}
