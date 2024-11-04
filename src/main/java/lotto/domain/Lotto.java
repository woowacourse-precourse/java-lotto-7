package lotto.domain;

import java.util.List;
import lotto.domain.dto.LottoDetail;
import lotto.vo.ErrorMessage;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateExistNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_COUNT.getMessage());
        }
    }

    private void validateExistNumber(List<Integer> numbers) {
        List<Integer> filter = numbers.stream().distinct().toList();
        if (filter.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.EXIST_LOTTO_NUMBER.getMessage());
        }
    }

    public LottoDetail toDTO() {
        return new LottoDetail(numbers);
    }

    public long getHitCount(Winning winning) {
       return numbers.stream().filter(winning::compareTo).count();
    }

    public long getBonusHitCount(Bonus bonus) {
        return numbers.stream().filter(bonus::compareTo).count();
    }
    // TODO: 추가 기능 구현
}
