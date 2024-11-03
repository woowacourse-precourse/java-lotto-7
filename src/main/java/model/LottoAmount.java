package model;

public class LottoAmount {

    private final int lottoAmountCount;
    private static final int LOTTO_VALUE = 1000;

    public LottoAmount(int money) {
        lottoAmountCount = money / LOTTO_VALUE;
    }

    public int getCount() {
        return lottoAmountCount;
    }
}
