package lotto.domain.number;

public class LottoNumber {

    private static final int MAXIMUM_LOTTO_NUMBER = 45;
    private static final int MINIMUM_LOTTO_NUMBER = 1;

    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        if(lottoNumber<MINIMUM_LOTTO_NUMBER || lottoNumber >MAXIMUM_LOTTO_NUMBER){
            throw new IllegalArgumentException("//여기 enum 에러값");
        }
        this.lottoNumber = lottoNumber;
    }

    public LottoNumber(NumberGenerator numberGenerator) {
        this.lottoNumber= numberGenerator.create(MINIMUM_LOTTO_NUMBER,MAXIMUM_LOTTO_NUMBER);
    }

}
