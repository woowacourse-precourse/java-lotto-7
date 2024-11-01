package lotto.domain.vo;

import java.util.List;

public record LottoNumbers(List<Integer> numbers) {
    public boolean hasNumber(int number) {
        return numbers.contains(number);
    }
}
