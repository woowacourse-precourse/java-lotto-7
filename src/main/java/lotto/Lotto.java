package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoValidator.validateLottoNumbers(numbers);
        this.numbers = numbers;
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
