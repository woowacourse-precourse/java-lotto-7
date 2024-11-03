package lotto.domain;

import java.util.List;
import lotto.domain.dto.LottoDetail;

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
