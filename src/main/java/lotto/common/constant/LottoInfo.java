package lotto.common.constant;

public enum LottoInfo {

    DEFAULT_LOTTO(0, 45, 6, 1000);

    private final Integer lowBoundOfLottoNumber;
    private final Integer highBoundOfLottoNumber;
    private final Integer countOfLottoNumber;
    private final Integer priceOfOneLotto;

    LottoInfo(Integer lowBoundOfLottoNumber, Integer highBoundOfLottoNumber, Integer countOfLottoNumber, Integer priceOfOneLotto) {
        this.lowBoundOfLottoNumber = lowBoundOfLottoNumber;
        this.highBoundOfLottoNumber = highBoundOfLottoNumber;
        this.countOfLottoNumber = countOfLottoNumber;
        this.priceOfOneLotto = priceOfOneLotto;
    }

    public Integer getLowBoundOfLottoNumber() {
        return lowBoundOfLottoNumber;
    }

    public Integer getHighBoundOfLottoNumber() {
        return highBoundOfLottoNumber;
    }

    public Integer getCountOfLottoNumber() {
        return countOfLottoNumber;
    }

    public Integer getPriceOfOneLotto() {
        return priceOfOneLotto;
    }
}
