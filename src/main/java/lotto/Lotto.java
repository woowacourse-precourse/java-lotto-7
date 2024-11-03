package lotto;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import lotto.repository.LottoRepository;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
    // TODO: 추가 기능 구현

    public Winning match(List<Integer> winningNumbers) {
        Map<Lotto, Integer> frequencyMap = new HashMap<>();
        int count = 0;
        for (Integer num : winningNumbers) {
            count += Collections.frequency(this.numbers, num);
            frequencyMap.put(this, count);
        }
        return Winning.findByMatchCount(count, containBonus());
    }

    public Boolean containBonus() {
        return numbers.contains(LottoRepository.bonus);
    }
}
