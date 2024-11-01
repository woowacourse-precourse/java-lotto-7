package lotto.domain;

import static lotto.utils.Constants.END_NUM;
import static lotto.utils.Constants.START_NUM;
import static lotto.utils.ErrorMessage.INVALID_LOTTO_NUM;

import java.util.Objects;

public class LottoNum implements Comparable<LottoNum> {

    private final Integer num;

    protected LottoNum(Integer num) {
        this.num = validateNum(num);
    }

    protected LottoNum(String input) {
        Integer parsedNum = parsedInt(input);
        this.num = validateNum(parsedNum);
    }

    public static LottoNum create(String input) {
        return new LottoNum(input);
    }

    public Integer parsedInt(String num) {
        try {
            return Integer.parseInt(num);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUM.getMessage());
        }
    }

    public Integer validateNum(Integer num) {
        if (num == null || num < START_NUM || num > END_NUM) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUM.getMessage());
        }
        return num;
    }

    @Override
    public String toString() {
        return num.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNum lottoNum = (LottoNum) o;
        return Objects.equals(num, lottoNum.num);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(num);
    }


    @Override
    public int compareTo(LottoNum o) {
        return Integer.compare(this.num, o.num);
    }
}
