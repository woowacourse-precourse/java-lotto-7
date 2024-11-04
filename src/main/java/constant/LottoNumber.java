package constant;

public enum LottoNumber {
    LOTTO_NUMBER_MIN(1),
    LOTTO_NUMBER_MAX(45),
    LOTTO_NUMBER_COUNT(6);

    private final Integer lottoNumber;

    LottoNumber(Integer lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public Integer getLottoNumber() {
        return lottoNumber;
    }
}
