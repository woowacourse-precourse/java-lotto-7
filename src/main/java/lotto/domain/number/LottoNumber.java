package lotto.domain.number;

public class LottoNumber {

    private static final int MAXIMUM_LOTTO_NUMBER = 45;
    private static final int MINIMUM_LOTTO_NUMBER = 1;

    private final int lottoNumber;

    private LottoNumber(int lottoNumber) {
        if(lottoNumber<MINIMUM_LOTTO_NUMBER || lottoNumber >MAXIMUM_LOTTO_NUMBER){
            throw new IllegalArgumentException("//여기 enum 에러값");
        }
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber from(int number) {
        return new LottoNumber(number);
    }

    public static LottoNumber from(NumberGenerator numberGenerator){
        return new LottoNumber(numberGenerator.create(MINIMUM_LOTTO_NUMBER,MAXIMUM_LOTTO_NUMBER));
    }

}
