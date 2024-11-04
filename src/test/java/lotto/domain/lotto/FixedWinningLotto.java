package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.List;

class FixedWinningLotto implements WinningLotto {

    @Override
    public List<Integer> basicNumbers() {
        return new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
    }

    @Override
    public int bonusNumber() {
        return 7;
    }
}