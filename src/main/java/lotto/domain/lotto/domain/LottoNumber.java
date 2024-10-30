package lotto.domain.lotto.domain;

public class LottoNumber {

    private final int lottoNumber;

    private LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber from(
            final int number
    ) {
        return new LottoNumber(number);
    }

    private int validate(int number) {
        if(number < 0 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45번 이어야 합니다.");
        }

        return number;
    }

    public int getLottoNumber() {
        return lottoNumber;
    }
}
