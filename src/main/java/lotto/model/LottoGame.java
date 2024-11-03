package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGame {
    private List<Integer> golden_numbers;
    private Integer bonus_number;

    public LottoGame(List<Integer> golden_numbers, Integer bonus_number) {
        this.golden_numbers = golden_numbers;
        this.bonus_number = bonus_number;
    }

    public LottoResult calculateResult(List<Lotto> all_lottos) {
        List<Integer> match_count = new ArrayList<>(Collections.nCopies(7,0));
        Integer bonus_match = 0;
        for (Lotto lotto: all_lottos) {
            Integer match = (int) golden_numbers.stream()
                    .filter(lotto.getNumbers()::contains)
                    .count();
            match_count.set(match, match_count.get(match) + 1);
            if (match == 5 && lotto.getNumbers().contains(bonus_number)) {
                bonus_match += 1;
            }
        }
        return new LottoResult(match_count, bonus_match);
    }
}
