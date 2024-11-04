package lotto.model.db;

import java.util.List;
import lotto.exception.BusinessException;
import lotto.exception.ErrorMessage;

public class Lotto {

    private static final int LOTTO_NUM_CNT = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateDuplication(numbers);
        this.numbers = numbers.stream().sorted().toList();
    }

    private void validateDuplication(List<Integer> numbers) {
        if (isDuplicated(numbers)) {
            throw new BusinessException(ErrorMessage.DUPLICATED_LOTTO_NUM);
        }
    }

    private boolean isDuplicated(List<Integer> numbers) {
        return numbers.stream().distinct().count() != LOTTO_NUM_CNT;
    }

    public boolean contains(int num) {
        return numbers.contains(num);
    }

    public int getMatchCnt(Lotto lotto) {
        return (int) numbers.stream().filter(lotto::contains).count();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
