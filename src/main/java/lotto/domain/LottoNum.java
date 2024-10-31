package lotto.domain;

import static lotto.utils.ErrorMessage.INVALID_LOTTO_NUM;

import java.util.Objects;

public class LottoNum {

    private final Integer num;

    public LottoNum(Integer num) {
        this.num = validateNum(num);
    }

    public LottoNum(String num) {
        Integer parsedNum = parsedInt(num);
        this.num = validateNum(parsedNum);
    }

    public Integer parsedInt(String num) {
        try {
            return Integer.parseInt(num);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUM.getMessage());
        }
    }

    public Integer validateNum(Integer num) {
        if (num == null || num <= 0 || num > 45) {
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
}
