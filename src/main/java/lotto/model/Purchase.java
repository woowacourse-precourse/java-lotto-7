package lotto.model;

public class Purchase {
    private static final int PRICE = 1000;
    private final int payment; // TODO 원시타입 포장 고민
    private final int lottoCount;

    public Purchase(final String payment) {
        validate(payment);
        this.payment = Integer.parseInt(payment);
        this.lottoCount = this.payment / PRICE;
    }

    private void validate(String payment) {
        // TODO 예외 처리
    }

    public int getLottoCount() {
        return lottoCount;
    }
}
