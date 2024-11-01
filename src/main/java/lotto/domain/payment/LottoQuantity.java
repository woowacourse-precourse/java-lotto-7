package lotto.domain.payment;

public class LottoQuantity {

    private final int value;

    public LottoQuantity(int value) {
        this.value = value;
    }

    public static LottoQuantity of(int count) {
        return new LottoQuantity(count);
    }

    public int getValue() {
        return value;
    }

}
