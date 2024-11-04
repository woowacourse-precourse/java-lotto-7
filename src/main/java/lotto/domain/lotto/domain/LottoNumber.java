package lotto.domain.lotto.domain;

import java.util.Objects;

public class LottoNumber {

    private final int lottoNumber;

    private LottoNumber(int lottoNumber) {
        validate(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber from(
            final int number
    ) {
        return new LottoNumber(number);
    }

    private int validate(int number) {
        if(number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45번 이어야 합니다.");
        }

        return number;
    }

    public int getLottoNumber() {
        return lottoNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }
}
