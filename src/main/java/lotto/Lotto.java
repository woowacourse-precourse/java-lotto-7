package lotto;

import java.util.Collections;
import java.util.HashSet;
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
    }

    private void validateDuplication(List<Integer> numbers){
        if(numbers.size() != new HashSet<>(numbers).size()){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    public WinningRank match(Lotto winningLotto, int bonusNumber){
        int matchCount = (int) numbers.stream()
                .filter(winningLotto.numbers::contains)
                .count();
        boolean matchBonus = numbers.contains(bonusNumber);
        return WinningRank.valueOf(matchCount,matchBonus);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }


}
