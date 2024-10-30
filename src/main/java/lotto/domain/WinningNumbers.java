package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import lotto.constant.LottoConstant;

public class WinningNumbers {
    List<Integer> primaryNumbers;

    public WinningNumbers(List<Integer> primaryNumbers) {
        validate(primaryNumbers);
        this.primaryNumbers = primaryNumbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoConstant.LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
        HashSet<Integer> checkNumbersCount = new HashSet<>(numbers);
        if (checkNumbersCount.size() != numbers.size()){
            throw new IllegalArgumentException("[ERROR] 중복값 입력은 불가능합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WinningNumbers that = (WinningNumbers) o;
        return Objects.equals(primaryNumbers, that.primaryNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(primaryNumbers);
    }
}