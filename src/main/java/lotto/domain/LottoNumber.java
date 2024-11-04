package lotto.domain;

import static lotto.utils.Constants.END_NUM;
import static lotto.utils.Constants.START_NUM;
import static lotto.utils.ErrorMessage.INVALID_LOTTO_NUM;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

    private final Integer number;

    protected LottoNumber(Integer number) {
        this.number = validateNumber(number);
    }

    protected LottoNumber(String input) {
        Integer parsedNum = parsedInt(input);
        this.number = validateNumber(parsedNum);
    }

    public static LottoNumber create(String input) {
        return new LottoNumber(input);
    }

    public Integer parsedInt(String num) {
        try {
            return Integer.parseInt(num);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUM.getMessage());
        }
    }

    public Integer validateNumber(Integer number) {
        if (number == null || number < START_NUM || number > END_NUM) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUM.getMessage());
        }
        return number;
    }

    @Override
    public String toString() {
        return number.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber lottoNumber = (LottoNumber) o;
        return Objects.equals(number, lottoNumber.number);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(number);
    }


    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(this.number, o.number);
    }
}
