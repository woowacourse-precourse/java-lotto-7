package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        if (hasDuplicates(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
        }

        if (!isInLottoNumRange(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1이상 45이하 이어야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
    public boolean hasDuplicates(List<Integer> list) {
        return list.stream()
                .distinct()
                .count() != list.size();
    }

    public boolean isInLottoNumRange(List<Integer> list) {
        return list.stream()
                .allMatch(integer -> integer >= LottoInfo.MIN_NUM_RANGE && integer <= LottoInfo.MAX_NUM_RANGE);
    }

}
