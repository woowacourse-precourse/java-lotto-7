package lotto.policy;

public enum LottoNumberPolicy {
    MAX_NUMBER(45),
    MIN_NUMBER(1);

    private final int minOrMaxNumber;

    LottoNumberPolicy(int lottoNumber) {
        this.minOrMaxNumber = lottoNumber;
    }

    public int getMinOrMaxNumber() {
        return minOrMaxNumber;
    }
}
