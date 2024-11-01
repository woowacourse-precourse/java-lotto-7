package lotto.domain.payment;

public class LottoCount {
    private final int value;

    public LottoCount(int value) {
        this.value = value;
    }

    public static LottoCount of(int count) {
        return new LottoCount(count);
    }

    public int getValue() {
        return value;
    }
}
