package lotto.policy;

public enum LottoNumberPolicy {
    MAX_NUMBER(45),
    MIN_NUMBER(1),
    NUMBER_SCALE(6);

    private final int number;

    LottoNumberPolicy(int lottoNumber) {
        this.number = lottoNumber;
    }

    public int number() {
        return number;
    }
}
