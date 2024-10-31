package lotto.domain.lotto;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FixedWinningLotto implements WinningLotto {

    @Override
    public List<Integer> basicNumbers() {
        return List.of(1, 2, 3, 4, 5, 6);
    }

    @Override
    public int bonusNumber() {
        return 7;
    }
}