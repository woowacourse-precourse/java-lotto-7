package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lotto.repository.LottoRepository;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        validate(sortedNumbers);
        this.numbers = sortedNumbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 있습니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

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
